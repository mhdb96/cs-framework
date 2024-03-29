package com.xdebuggers.core.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
 * Configuration class for setting up Oracle Data Source for CS (Custom Spring)
 * framework.
 * Enables JPA repositories for Oracle and configures JdbcTemplate,
 * EntityManagerFactory, and TransactionManager.
 */
@Configuration
@ConditionalOnProperty(name = "cs.datasource.type", havingValue = "oracle")
@EnableJpaRepositories(basePackages = "com.xdebuggers.core.repository.oracle", entityManagerFactoryRef = "oracleEntityManagerFactory", transactionManagerRef = "oracleTransactionManager")
public class OracleDataSourceConfig {

    /**
     * Configures the Oracle DataSource as the primary data source based on the
     * properties under "cs.datasource.oracle" prefix.
     *
     * @return Configured Oracle DataSource.
     */
    @Primary
    @Bean(name = "oracleDataSource")
    @ConfigurationProperties(prefix = "cs.datasource.oracle")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * Configures a JdbcTemplate for the Oracle DataSource.
     *
     * @param dataSource Oracle DataSource.
     * @return Configured JdbcTemplate.
     */
    @Primary
    @Bean(name = "oracleJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("oracleDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * Configures the EntityManagerFactory for Oracle based on JPA properties.
     *
     * @param builder       EntityManagerFactoryBuilder.
     * @param dataSource    Oracle DataSource.
     * @param jpaProperties JPA properties.
     * @return Configured LocalContainerEntityManagerFactoryBean.
     */
    @Primary
    @Bean(name = "oracleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("oracleDataSource") DataSource dataSource,
            JpaProperties jpaProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.xdebuggers.core.model.oracle")
                .persistenceUnit("oracle")
                .properties(jpaProperties.getProperties())
                .build();
    }

    /**
     * Configures the TransactionManager for Oracle.
     *
     * @param entityManagerFactory Oracle EntityManagerFactory.
     * @return Configured PlatformTransactionManager.
     */
    @Primary
    @Bean(name = "oracleTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("oracleEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
