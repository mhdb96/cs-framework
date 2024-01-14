package com.xdebuggers.core.datasource;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to enable CS (Custom Spring) Data Source configuration.
 * Imports the {@link H2DataSourceConfig}, {@link MssqlDataSourceConfig}, and
 * {@link OracleDataSourceConfig} classes.
 * <p>
 * Usage example:
 * 
 * <pre>
 * {@literal @}EnableCSDataSource
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
@Import({ H2DataSourceConfig.class, MssqlDataSourceConfig.class, OracleDataSourceConfig.class })
public @interface EnableCSDataSource {
}
