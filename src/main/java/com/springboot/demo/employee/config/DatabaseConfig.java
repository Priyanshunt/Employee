package com.springboot.demo.employee.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
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
        final OracleDataSource oracleDataSource = new OracleDataSource();
        oracleDataSource.setURL(url);
        oracleDataSource.setUser(username);
        oracleDataSource.setPassword(password);
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setConnectionInitSql("ALTER SESSION SET CURRENT_SCHEMA=" + proxyUser);
        hikariConfig.setDataSource(oracleDataSource);
        return new HikariDataSource(hikariConfig);
    }
}
