package com.xdebuggers.core.email;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to enable email configuration with CS (Custom Spring)
 * framework.
 * Imports the {@link EmailConfig} class to configure JavaMailSender for sending
 * emails.
 * <p>
 * Usage example:
 * 
 * <pre>
 * {@literal @}EnableCSEmail
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
@Import(EmailConfig.class)
public @interface EnableCSEmail {
}