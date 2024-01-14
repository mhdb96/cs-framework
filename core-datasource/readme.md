# core-datasource Module

The core-datasource module provides essential configurations for DataSources using HikariCP. It offers standardized DataSource setup for Oracle and MSSQL databases.

## Usage

- Include this module as a dependency to enable centralized DataSource management.
- Use the provided DataSourceConfig class to configure and create Oracle and MSSQL DataSources.

## Why to Use

- Centralized management of database connections with standardized configurations.
- Enables developers to easily switch between Oracle and MSSQL databases.

## How to Use

1. Add this module as a dependency in your project.
2. Import the DataSourceConfig class in your application configuration.
3. Use **@Autowired** to inject the desired DataSource (e.g., @Autowired @Qualifier("oracleDataSource") DataSource dataSource).
4. Customize properties in the application.yml file to fit your specific database configurations.
