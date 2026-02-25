# Order Service README

# Order Service

This is the Order Service part of the microservices architecture and is responsible for managing customer-related operations. It is responsible for managing customer orders, including creating and retrieving order information.

## Features

- Update stock quantity after customer order
- Communicate with other services (Customer, inventory and Notification) via RabbitMQ
- Create message for notifiaction service

## Dependencies

This module relies on the following dependencies:
- Spring Boot
- RabbitMQ
- PostgreSQL
- Maven