package com.xdebuggers.core.email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Configuration class for defining JavaMailSender for sending emails in CS
 * (Custom Spring) framework.
 */
@Configuration
@Import(EmailProperties.class)
public class EmailConfig {

    /**
     * Creates and configures the JavaMailSender based on the provided email
     * properties.
     *
     * @param emailProperties Email properties.
     * @return Configured JavaMailSender.
     */
    @Bean
    public JavaMailSender javaMailSender(EmailProperties emailProperties) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailProperties.getHost());
        mailSender.setPort(emailProperties.getPort());
        mailSender.setUsername(emailProperties.getUsername());
        mailSender.setPassword(emailProperties.getPassword());
        // ... other JavaMailSender properties

        return mailSender;
    }
}