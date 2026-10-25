package cl.technofix.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Configuration
public class OracleWalletConfig implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String base64Wallet = System.getenv("ORACLE_WALLET_BASE64");

        if (base64Wallet == null || base64Wallet.trim().isEmpty()) {
            System.out.println("ORACLE_WALLET_BASE64 env variable not found. Skipping runtime extraction.");
            return;
        }

        try {
            Path walletDir = Files.createTempDirectory("oracle_wallet_");
            byte[] zipBytes = Base64.getDecoder().decode(base64Wallet.trim());

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
                        Files.copy(zis, file.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                    }
                    zis.closeEntry();
                }
            }

            String walletPath = walletDir.toAbsolutePath().toString();
            System.setProperty("oracle.net.tns_admin", walletPath);

        } catch (Exception e) {
            throw new IllegalStateException("Critical Error: Failed to unpack Oracle Wallet at application startup.",
                    e);
        }
    }
}