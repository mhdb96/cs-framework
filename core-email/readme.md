# Email Module

## Description

The Email module facilitates email sending in CS Framework by configuring JavaMailSender through a straightforward EmailConfig class. It simplifies email properties management and promotes clean email sending code.

## Usage

- Annotate your application with `@EnableCSEmail` to enable email configuration.
- Customize email properties in the `application.yml` file under the `cs.email` prefix.

## Why to Use

- Simplifies email configuration and sending in Java applications.
- Improves maintainability by centralizing email configuration in one place.
- Enhances code readability with clean and concise email sending code.

## How to Use

1. Add the `@EnableCSEmail` annotation to your main application class.
2. Customize email properties in the `application.yml` file under the `cs.email` prefix.
3. Inject the configured `JavaMailSender` bean into your services or controllers for sending emails.
