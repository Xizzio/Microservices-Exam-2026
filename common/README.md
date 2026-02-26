# FILE: /Microservices-Exam/common/README.md
# This file contains documentation specific to the common module.

The common module provides shared configurations, Data Transfer Objects (DTOs), and utility classes that are used across different microservices in the application.

## Usage

This module is designed to be included as a dependency in other microservices (Customer, Order, Notification, Inventory) to promote code reuse and maintainability.

## Dependencies

Ensures that the common module is included in the `pom.xml` of each microservice that requires its functionalities. 