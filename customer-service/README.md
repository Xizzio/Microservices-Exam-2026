# Customer Service README

# Customer Service

This is the Customer Service part of the microservices architecture and is responsible for managing customer-related operations. It provides functionalities to handle customer data, including creation and deletion of customer information. This is also where the user logs in to a customer and admin user.

## Features

- Log in to a user with username and password
- Communicate with other services (Inventory and Order) via RabbitMQ
- Create new users
- Delete users with admin user

## Dependencies

This module relies on the following dependencies:
- Spring Boot
- Spring Data JPA
- RabbitMQ Client
- PostgreSQL Driver