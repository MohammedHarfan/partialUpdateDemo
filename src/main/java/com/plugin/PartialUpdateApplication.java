package com.plugin;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@EntityScan(basePackages = "com.plugin.model")
@EnableJpaRepositories(basePackages = {"com.plugin.repository"})
@ComponentScan(basePackages = {"com.plugin.repository", "com.plugin.service", "com.plugin.util"})
public class PartialUpdateApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(PartialUpdateApplication.class, args);
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("spring.datasource.url"));
        config.setUsername(env.getProperty("spring.datasource.username"));
        config.setPassword(env.getProperty("spring.datasource.password"));
        config.setMinimumIdle(Integer.valueOf(env.getProperty("spring.datasource.hikari.minimum-idle")));
        config.setMaximumPoolSize(Integer.valueOf(env.getProperty("spring.datasource.hikari.maximum-pool-size")));
        config.setAutoCommit(true);
        return getDataSource(config);
    }

    private DataSource getDataSource(HikariConfig config) {
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "false");
        //config.addDataSourceProperty("useLocalSessionState", "true");
        config.addDataSourceProperty("rewriteBatchedStatements", "true");
        config.addDataSourceProperty("cacheResultSetMetadata", "true");
        config.addDataSourceProperty("cacheServerConfiguration", "true");
        config.addDataSourceProperty("elideSetAutoCommits", "true");
        config.addDataSourceProperty("maintainTimeStats", "false");
        return new HikariDataSource(config);
    }

}
