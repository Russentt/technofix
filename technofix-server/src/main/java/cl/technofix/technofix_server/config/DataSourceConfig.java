package cl.technofix.technofix_server.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Bean
    public DataSource dataSource() {
        String password = System.getenv("DB_PASSWORD");
        if (password == null || password.trim().isEmpty()) {
            password = System.getenv("SPRING_DATASOURCE_PASSWORD");
        }
        if (password == null || password.trim().isEmpty()) {
            password = "nope, not yet.";
        }

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password.trim());

        return dataSource;
    }
}
