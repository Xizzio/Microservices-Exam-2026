# Microservices Shop Project

This project is a structured Spring Boot microservice shop application that utilizes PostgreSQL for datastore and RabbitMQ for messaging and communication between services. The architecture consists of four main services: Customer, Order, Notification, and Inventory. Each service is designed to handle specific functionalities and communicate with each other through messaging.

## Usefull terminal commands
- mvn clean install
- docker-compose build --no-cache
- docker-compose up
- docker-compose down -v ("-v" for full reset of volumes)

## Postman GET and POST URLs
### Handeling user customer-service (register a new user first, then try login)
- To register a new user: POST http://localhost:8081/api/auth/register
Body JSON:
{
    "email": "test@test.com",
    "username": "testuser",
    "password": "testpassword"
}

- To login to existing user: POST http://localhost:8081/api/auth/login
Body JSON:
{
    "username": "testuser",
    "password": "testpassword"
}

### Handeling products inventory-service and order-service
- add product to inventory database: POST http://localhost:8084/api/products
Body JSON:
{
  "productName": "milk",
  "quantity": 304,
  "price": 18.00
}

- Get the inventory database table: GET http://localhost:8084/api/products
- Order products: POST http://localhost:8084/api/products/decrease
Body JSON:
{
  "productName": "milk",
  "quantity": 2
}

## Project Structure

```
webshop-microservices
├── .github
│   └── maven.yml
├── .mvn/
│   └── wrapper/
│       ├── maven-wrapper-0.5.6.jar
│       └── maven-wrapper.properties
├── common
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       └── com/
│   │   │           └── microservices/
│   │   │               └── common/
│   │   └── resources/
│   ├── pom.xml
│   └── README.md
├── customer-service
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── microservices/
│   │       │           └── customer/
│   │       │               ├── controller/
│   │       │               ├── dto/
│   │       │               ├── model/
│   │       │               ├── repository/
│   │       │               ├── service/
│   │       │               └── CustomerServiceApplication.java
│   │       resources/
│   │       └── application.yml
│   ├── target/
│   ├── dockerfile
│   ├── pom.xml
│   └── README.md
├── db_init/
│   ├── customer_db.sql
│   ├── inventory_db.sql
│   ├── notification_db.sql
│   └── order_db.sql
├── inventory-service
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── microservices/
│   │       │           └── inventory/
│   │       │               ├── controller/
│   │       │               ├── dto/
│   │       │               ├── model/
│   │       │               ├── repository/
│   │       │               ├── service/
│   │       │               └── InventoryServiceApplication.java
│   │       resources/
│   │       └── application.yml
│   ├── target/
│   ├── dockerfile
│   ├── pom.xml
│   └── README.md
├── notification-service
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── microservices/
│   │       │           └── notification/
│   │       │               ├── controller/
│   │       │               ├── model/
│   │       │               ├── repository/
│   │       │               ├── service/
│   │       │               └── NotificationServiceApplication.java
│   │       resources/
│   │       └── application.yml
│   ├── target/
│   ├── dockerfile
│   ├── pom.xml
│   └── README.md
├── order-service
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── microservices/
│   │       │           └── order/
│   │       │               ├── client/
│   │       │               ├── controller/
│   │       │               ├── dto/
│   │       │               ├── model/
│   │       │               ├── repository/
│   │       │               ├── service/
│   │       │               └── OrderServiceApplication.java
│   │       resources/
│   │       └── application.yml
│   ├── target/
│   ├── dockerfile
│   ├── pom.xml
│   └── README.md
├── .gitattributes
├── .gitignore
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Services Overview

- **Customer Service**: Manages customer-related operations like, registration and login.
- **Inventory Service**: Manages product inventory, including stock quantity and product add/remove if admin. The customer is also able to POST a product and choose the quantity, the product quantity will update after order is confirmed.
- **Order Service**: Handles order processing, including order creation and retrieval of order history.
- **Notification Service**: Sends notifications to customers regarding their orders and stores the customer receipt.

## Communication

The services communicate with each other using RabbitMQ for asynchronous messaging. This allows for decoupled service interactions and improved scalability.

## Database Configuration

Each service has its own database configuration using PostgreSQL. The initializing SQL files for each service are located in the `root/db_init` directory.

## Docker

When running this project I used Docker.desktop

## Running the Application

To run the entire application, first open up the terminal like powershell and run `mvn clean install`, then use Docker Compose to start all services `docker-compose up --build`, including RabbitMQ and PostgreSQL. The docker-compose.yml file in the root directory contains the necessary configurations.

If you need to clean restart before running `docker-compose up --build` then use the command `docker-compose down -v` if docker already was up and had volumes.

## Getting Started

1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean install` to build target files then run `docker-compose up --build` to start all services.
4. If you have Docker Desktop downloaded, you can check out the running services easier.