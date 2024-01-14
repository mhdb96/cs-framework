# core-email Module

The core-email module provides configurations for sending emails using Spring Boot's JavaMailSender. It includes the setup for an SMTP-based mail sender with customizable email properties.

## Usage

- Include this module as a dependency to enable email sending capabilities.
- Utilize the EmailConfig class for configuring and creating the JavaMailSender.

## Why to Use

- Simplifies email sending functionality in your application.
- Allows for easy customization of email properties such as host, port, and credentials.

## How to Use

1. Add this module as a dependency in your project.
2. Import the EmailConfig class in your application configuration.
3. Use **@Autowired** to inject the JavaMailSender where email sending is required.
4. Customize email properties in the application.yml file to fit your specific email server configuration.
