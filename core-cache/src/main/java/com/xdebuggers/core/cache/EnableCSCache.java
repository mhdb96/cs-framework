package com.xdebuggers.core.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to enable caching with CS (Custom Spring) Cache
 * configuration.
 * Imports the {@link CacheConfig} class and enables Spring caching support.
 * <p>
 * Usage example:
 * 
 * <pre>
 * {@literal @}EnableCSCache
 * public class MyApplication {
 *     public static void main(String[] args) {
 *         SpringApplication.run(MyApplication.class, args);
 *     }
 * }
 * </pre>
 * </p>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CacheConfig.class)
@EnableCaching
public @interface EnableCSCache {
}
