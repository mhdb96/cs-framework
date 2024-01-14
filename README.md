# CS Framework

CS Framework is a customizable and modular Java framework built on the Spring framework. It simplifies common operations like caching, database connectivity, and email sending by providing easy-to-use annotations and configurable properties. This README provides an overview of the three core modules in CS Framework: Cache, DataSource, and Email.

## Cache Module

### Description

The Cache module in CS Framework leverages Infinispan to provide a flexible caching solution for applications. It allows developers to easily configure and use different cache configurations, such as long-term, medium-term, and short-term caches, each with its own Time-To-Live (TTL) settings.

### Usage

- Annotate your application with `@EnableCSCache` to enable caching configuration.
- Use the provided cache names (`longterm-cache`, `mediumterm-cache`, `shortterm-cache`) in your application to utilize specific cache configurations.
- Implement caching in your code using Spring's `@Cacheable` annotation and referencing the configured cache names.

### Why to Use

- Improves application performance by caching frequently accessed data.
- Configurable cache settings cater to various use cases with different TTLs.
- Enhances code readability and maintainability by centralizing caching configurations.

### How to Use

1. Add the `@EnableCSCache` annotation to your main application class.
2. Use the provided cache names in your code with the `@Cacheable` annotation.
3. Customize caching behavior by adjusting TTLs in the CacheConfig class.

## DataSource Module

### Description

The DataSource module simplifies database connectivity in CS Framework by providing configurations for H2, MSSQL, and Oracle databases. It supports dynamic switching between different database implementations through YAML configuration.

### Usage

- Annotate your application with `@EnableCSDataSource` to enable data source configuration.
- Specify the desired database type in the YAML configuration (`cs.datasource.type`) to dynamically switch between H2, MSSQL, and Oracle.

### Why to Use

- Streamlines database connectivity with multiple implementations (H2, MSSQL, Oracle).
- Provides flexibility to switch databases dynamically based on application requirements.
- Promotes clean code by separating data source configurations from application logic.

### How to Use

1. Add the `@EnableCSDataSource` annotation to your main application class.
2. Specify the desired database type in the YAML configuration (`cs.datasource.type`).
3. Customize database-specific properties in the respective configuration classes.

## Email Module

### Description

The Email module facilitates email sending in CS Framework by configuring JavaMailSender through a straightforward EmailConfig class. It simplifies email properties management and promotes clean email sending code.

### Usage

- Annotate your application with `@EnableCSEmail` to enable email configuration.
- Customize email properties in the `application.yml` file under the `cs.email` prefix.

### Why to Use

- Simplifies email configuration and sending in Java applications.
- Improves maintainability by centralizing email configuration in one place.
- Enhances code readability with clean and concise email sending code.

### How to Use

1. Add the `@EnableCSEmail` annotation to your main application class.
2. Customize email properties in the `application.yml` file under the `cs.email` prefix.
3. Inject the configured `JavaMailSender` bean into your services or controllers for sending emails.
