package com.xdebuggers.core.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Configuration class for setting up MSSQL Data Source for CS (Custom Spring)
 * framework.
 * Enables JPA repositories for MSSQL and configures JdbcTemplate,
 * EntityManagerFactory, and TransactionManager.
 */
@Configuration
@ConditionalOnProperty(name = "cs.datasource.type", havingValue = "mssql")
@EnableJpaRepositories(basePackages = "com.xdebuggers.core.repository.mssql", entityManagerFactoryRef = "mssqlEntityManagerFactory", transactionManagerRef = "mssqlTransactionManager")
public class MssqlDataSourceConfig {

    /**
     * Configures the MSSQL DataSource based on the properties under
     * "cs.datasource.mssql" prefix.
     *
     * @return Configured MSSQL DataSource.
     */
    @Bean(name = "mssqlDataSource")
    @ConfigurationProperties(prefix = "cs.datasource.mssql")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * Configures a JdbcTemplate for the MSSQL DataSource.
     *
     * @param dataSource MSSQL DataSource.
     * @return Configured JdbcTemplate.
     */
    @Bean(name = "mssqlJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("mssqlDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * Configures the EntityManagerFactory for MSSQL based on JPA properties.
     *
     * @param builder       EntityManagerFactoryBuilder.
     * @param dataSource    MSSQL DataSource.
     * @param jpaProperties JPA properties.
     * @return Configured LocalContainerEntityManagerFactoryBean.
     */
    @Bean(name = "mssqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mssqlDataSource") DataSource dataSource,
            JpaProperties jpaProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.xdebuggers.core.model.mssql")
                .persistenceUnit("mssql")
                .properties(jpaProperties.getProperties())
                .build();
    }

    /**
     * Configures the TransactionManager for MSSQL.
     *
     * @param entityManagerFactory MSSQL EntityManagerFactory.
     * @return Configured PlatformTransactionManager.
     */
    @Bean(name = "mssqlTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("mssqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
