# Cache Module

## Description

The Cache module in CS Framework leverages Infinispan to provide a flexible caching solution for applications. It allows developers to easily configure and use different cache configurations, such as long-term, medium-term, and short-term caches, each with its own Time-To-Live (TTL) settings.

## Usage

- Annotate your application with `@EnableCSCache` to enable caching configuration.
- Use the provided cache names (`longterm-cache`, `mediumterm-cache`, `shortterm-cache`) in your application to utilize specific cache configurations.
- Implement caching in your code using Spring's `@Cacheable` annotation and referencing the configured cache names.

## Why to Use

- Improves application performance by caching frequently accessed data.
- Configurable cache settings cater to various use cases with different TTLs.
- Enhances code readability and maintainability by centralizing caching configurations.

## How to Use

1. Add the `@EnableCSCache` annotation to your main application class.
2. Use the provided cache names in your code with the `@Cacheable` annotation.
3. Customize caching behavior by adjusting TTLs in the CacheConfig class.
