# core-cache Module

The core-cache module provides configurations for Infinispan caching to enhance application performance. It includes the setup for an embedded cache manager with customizable cache properties.

## Usage

- Include this module as a dependency to enable caching capabilities.
- Utilize the CacheConfig class for configuring and creating the Infinispan cache manager.

## Why to Use

- Improves application performance by caching frequently accessed data.
- Allows for efficient data storage and retrieval, reducing database load.

## How to Use

1. Add this module as a dependency in your project.
2. Import the CacheConfig class in your application configuration.
3. Use the @Cacheable annotation on methods or classes to enable caching.
4. Customize cache properties in the application.yml file to fit your specific caching needs.
