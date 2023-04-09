package com.springboot.demo.employee.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.springboot.demo.employee.repository")
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.proxy-user}")
    private String proxyUser;

    @Bean
    @Primary
    public DataSource dataSource() throws SQLException {
        final Properties properties = new Properties();
        properties.setProperty(OracleConnection.CONNECTION_PROPERTY_PROXY_CLIENT_NAME, proxyUser);
        final OracleDataSource oracleDataSource = new OracleDataSource();
        oracleDataSource.setURL(url);
        oracleDataSource.setUser(username);
        oracleDataSource.setPassword(password);
        oracleDataSource.setConnectionProperties(properties);
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setConnectionInitSql("ALTER SESSION SET CURRENT_SCHEMA=" + proxyUser);
        hikariConfig.setDataSource(oracleDataSource);
        return new HikariDataSource(hikariConfig);
    }
}
