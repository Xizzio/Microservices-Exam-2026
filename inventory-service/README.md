# Inventory Service README

# Inventory Service

The Inventory Service is a microservice responsible for managing the inventory of products in the shop. It handles operations related to product quantity levels, availability, and inventory product purchase inputs.

## Features

- Update stock quantity with admin user
- Communicate with other services (Customer and Order) via RabbitMQ
- View and order product including quantity

## Dependencies

This module relies on the following dependencies:
- Spring Boot
- RabbitMQ for messaging
- PostgreSQL for database management
- Maven for dependency management