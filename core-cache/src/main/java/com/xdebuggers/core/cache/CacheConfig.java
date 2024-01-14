package com.xdebuggers.core.cache;

import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.spring.starter.embedded.InfinispanCacheConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Configuration class for setting up Infinispan cache configurations.
 */
@Configuration
public class CacheConfig {

    /**
     * Configures the Infinispan cache manager with a local, synchronous cache mode.
     *
     * @return InfinispanCacheConfigurer instance.
     */
    @Bean
    InfinispanCacheConfigurer cacheConfigurer() {
        return manager -> {
            final org.infinispan.configuration.cache.Configuration ispnConfig = new ConfigurationBuilder()
                    .clustering().cacheMode(CacheMode.LOCAL)
                    .build();

            manager.defineConfiguration("local-sync-config", ispnConfig);
        };
    }

    /**
     * Configures a cache for long-term storage with a lifespan of 30 minutes.
     *
     * @return Configuration for the long-term cache.
     */
    @Bean(name = "longterm-cache")
    org.infinispan.configuration.cache.Configuration longtermCache() {
        return new ConfigurationBuilder()
                .expiration().lifespan(30, TimeUnit.MINUTES) // TTL: 30 minutes
                .build();
    }

    /**
     * Configures a cache for medium-term storage with a lifespan of 10 minutes.
     *
     * @return Configuration for the medium-term cache.
     */
    @Bean(name = "mediumterm-cache")
    org.infinispan.configuration.cache.Configuration mediumtermCache() {
        return new ConfigurationBuilder()
                .expiration().lifespan(10, TimeUnit.MINUTES) // TTL: 10 minutes
                .build();
    }

    /**
     * Configures a cache for short-term storage with a lifespan of 5 minutes.
     *
     * @return Configuration for the short-term cache.
     */
    @Bean(name = "shortterm-cache")
    org.infinispan.configuration.cache.Configuration shorttermCache() {
        return new ConfigurationBuilder()
                .expiration().lifespan(5, TimeUnit.MINUTES) // TTL: 5 minutes
                .build();
    }
}
