# FILE: /Microservices-Exam/common/README.md
# This file contains documentation specific to the common module.

The common module provides shared configurations, Data Transfer Objects (DTOs), and utility classes that are used across different microservices in the application.

## Structure

- **config**: Contains configuration classes that are shared across services.
- **dto**: Contains Data Transfer Objects used for communication between services.
- **utils**: Contains utility classes that provide common functionalities.

## Usage

This module is designed to be included as a dependency in other microservices (Customer, Order, Notification, Inventory) to promote code reuse and maintainability.

## Dependencies

Ensure that the common module is included in the `pom.xml` of each microservice that requires its functionalities. 

## Configuration

Configuration properties can be defined in `application.properties` or `application.yml` files located in the `src/main/resources` directory. These properties can include settings for RabbitMQ, database connections, and other shared configurations.