# DataSource Module

## Description

The DataSource module simplifies database connectivity in CS Framework by providing configurations for H2, MSSQL, and Oracle databases. It supports dynamic switching between different database implementations through YAML configuration.

## Usage

- Annotate your application with `@EnableCSDataSource` to enable data source configuration.
- Specify the desired database type in the YAML configuration (`cs.datasource.type`) to dynamically switch between H2, MSSQL, and Oracle.

## Why to Use

- Streamlines database connectivity with multiple implementations (H2, MSSQL, Oracle).
- Provides flexibility to switch databases dynamically based on application requirements.
- Promotes clean code by separating data source configurations from application logic.

## How to Use

1. Add the `@EnableCSDataSource` annotation to your main application class.
2. Specify the desired database type in the YAML configuration (`cs.datasource.type`).
3. Customize database-specific properties in the respective configuration classes.
