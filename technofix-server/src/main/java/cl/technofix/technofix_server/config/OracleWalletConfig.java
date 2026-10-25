package cl.technofix.technofix_server.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Configuration
public class OracleWalletConfig implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String base64Wallet = System.getenv("ORACLE_WALLET_BASE64");

        if (base64Wallet == null || base64Wallet.trim().isEmpty()) {
            System.out.println("ORACLE_WALLET_BASE64 env variable not found. Using local wallet path.");
            return;
        }

        try {
            Path walletDir = Files.createTempDirectory("oracle_wallet_");
            String cleanBase64 = base64Wallet.replaceAll("\\s+", "");
            byte[] zipBytes = Base64.getDecoder().decode(cleanBase64);

            Path actualWalletRoot = walletDir;

            try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipBytes))) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    File file = new File(walletDir.toFile(), entry.getName());
                    if (!file.toPath().normalize().startsWith(walletDir.normalize())) {
                        throw new SecurityException("Malformed zip entry detected: " + entry.getName());
                    }

                    if (entry.isDirectory()) {
                        Files.createDirectories(file.toPath());
                    } else {
                        Files.createDirectories(file.getParentFile().toPath());
                        Files.copy(zis, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        if (file.getName().equalsIgnoreCase("tnsnames.ora")) {
                            actualWalletRoot = file.getParentFile().toPath();
                        }
                    }
                    zis.closeEntry();
                }
            }

            String walletPath = actualWalletRoot.toAbsolutePath().toString().replace("\\", "/");
            System.setProperty("wallet.path", walletPath);
            System.setProperty("oracle.net.tns_admin", walletPath);
            String envPass = System.getenv("DB_PASSWORD");
            System.out.println("=== RENDER AUTH DEBUG ===");
            System.out.println("DB_PASSWORD env var exists? " + (envPass != null));
            if (envPass != null) {
                System.out.println("DB_PASSWORD length: " + envPass.length());
                System.out.println("First char: '" + envPass.charAt(0) + "' | Last char: '"
                        + envPass.charAt(envPass.length() - 1) + "'");
            }
            Path tnsFile = Path.of(walletPath, "tnsnames.ora");
            if (Files.exists(tnsFile)) {
                String tnsContent = Files.readString(tnsFile);
                System.out.println("TNS Entry: " + tnsContent.lines().findFirst().orElse("empty"));
            }
            System.out.println("=========================");
            System.out.println("Oracle Wallet extracted successfully to: " + walletPath);

        } catch (Exception e) {
            throw new IllegalStateException("Critical Error: Failed to unpack Oracle Wallet at application startup.",
                    e);
        }
    }
}