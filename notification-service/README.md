# Notification Service README

# Notification Service

This is the Notification Service part of the microservices architecture and is responsible for managing customer-related operations. It is responsible for handling notifications related to customer orders and receipts.

## Features

- Send notification message and receipt to console after customer order
- Communicate with other services (Order) via RabbitMQ
- Handle incoming messages for notifiaction service

## Dependencies

This service relies on the following dependencies:
- Spring Boot
- Spring Web
- Spring Data JPA
- RabbitMQ Client