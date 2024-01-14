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
 * Configuration class for setting up H2 Data Source for CS (Custom Spring)
 * framework.
 * Enables JPA repositories for H2 and configures JdbcTemplate,
 * EntityManagerFactory, and TransactionManager.
 */
@Configuration
@ConditionalOnProperty(name = "cs.datasource.type", havingValue = "h2")
@EnableJpaRepositories(basePackages = "com.xdebuggers.core.repository.h2", entityManagerFactoryRef = "h2EntityManagerFactory", transactionManagerRef = "h2TransactionManager")
public class H2DataSourceConfig {

    /**
     * Configures the H2 DataSource based on the properties under "cs.datasource.h2"
     * prefix.
     *
     * @return Configured H2 DataSource.
     */
    @Bean(name = "h2DataSource")
    @ConfigurationProperties(prefix = "cs.datasource.h2")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * Configures a JdbcTemplate for the H2 DataSource.
     *
     * @param dataSource H2 DataSource.
     * @return Configured JdbcTemplate.
     */
    @Bean(name = "h2JdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("h2DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * Configures the EntityManagerFactory for H2 based on JPA properties.
     *
     * @param builder       EntityManagerFactoryBuilder.
     * @param dataSource    H2 DataSource.
     * @param jpaProperties JPA properties.
     * @return Configured LocalContainerEntityManagerFactoryBean.
     */
    @Bean(name = "h2EntityManagerFactory")
    @ConfigurationProperties(prefix = "cs.datasource.jpa")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("h2DataSource") DataSource dataSource,
            JpaProperties jpaProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.xdebuggers.core.model.h2")
                .persistenceUnit("h2")
                .properties(jpaProperties.getProperties())
                .build();
    }

    /**
     * Configures the TransactionManager for H2.
     *
     * @param entityManagerFactory H2 EntityManagerFactory.
     * @return Configured PlatformTransactionManager.
     */
    @Bean(name = "h2TransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("h2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
