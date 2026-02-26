# Order Service README

# Order Service

This is the Order Service part of the microservices architecture and is responsible for managing customer-related operations. It is responsible for managing customer orders, including creating and retrieving order information.

## Features

- Update stock quantity after customer order
- Communicate with other services (Customer, inventory and Notification) via RabbitMQ
- Create message for notifiaction service

## Openfeign

Using openfeign since im using Spring Cloud instead of RestTemplate, this is to connect the order to inventory where we will decrease the quantity of product in the inventory_db.