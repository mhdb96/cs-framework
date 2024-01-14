package com.xdebuggers.core.cache;

import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.spring.starter.embedded.InfinispanCacheConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    InfinispanCacheConfigurer cacheConfigurer() {
        return manager -> {
            final org.infinispan.configuration.cache.Configuration ispnConfig = new ConfigurationBuilder()
                    .clustering().cacheMode(CacheMode.LOCAL)
                    .build();

            manager.defineConfiguration("local-sync-config", ispnConfig);
        };
    }

    @Bean(name = "longterm-cache")
    org.infinispan.configuration.cache.Configuration longtermCache() {
        return new ConfigurationBuilder()
                .expiration().lifespan(30, TimeUnit.MINUTES) // TTL: 30 minutes
                .build();
    }

    @Bean(name = "mediumterm-cache")
    org.infinispan.configuration.cache.Configuration mediumtermCache() {
        return new ConfigurationBuilder()
                .expiration().lifespan(10, TimeUnit.MINUTES) // TTL: 10 minutes
                .build();
    }

    @Bean(name = "shortterm-cache")
    org.infinispan.configuration.cache.Configuration shorttermCache() {
        return new ConfigurationBuilder()
                .expiration().lifespan(5, TimeUnit.MINUTES) // TTL: 5 minutes
                .build();
    }
}