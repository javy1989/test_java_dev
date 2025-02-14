# Test Neoris: Microservices Project

This repository contains two microservices developed for the technical test:
- **ms-account**: Manages bank accounts and transactions.
- **ms-customer**: Handles customer and personal information.

## Project Structure
```
test_java_dev/
│
├── ms-account/         # Microservice for account management
│   ├── src/            # Source code
│   ├── target/         # Compiled JAR files
│   ├── Dockerfile      # Docker configuration for containerization
│   └── ...
├── ms-customer/        # Microservice for customer management
│   ├── src/            # Source code
│   ├── target/         # Compiled JAR files
│   ├── Dockerfile      # Docker configuration for containerization
│   └── ...
├── docker-compose.yml  # Orchestrates services, RabbitMQ, and PostgreSQL
└── README.md           # Project documentation
```

---

## Features

### **1. ms-customer**
- Handles customer registration and management.
- Exposes REST APIs for:
  - Creating and updating customer details.
  - Retrieving customer information.

### **2. ms-account**
- Manages bank accounts and transactions.
- Exposes REST APIs for:
  - Creating accounts for customers.
  - Registering transactions (deposits, withdrawals).

### **3. RabbitMQ Integration**
- RabbitMQ is used for inter-service communication:
  - **ms-customer** publishes account creation events.
  - **ms-account** consumes these events to create accounts.

### **4. PostgreSQL**
- Both services use PostgreSQL for persistent storage:
  - **Schema `clients`**: Stores customer and personal information.
  - **Schema `accounts`**: Stores account and transaction data.

---

## Prerequisites

Before running the project, ensure the following tools are installed:
- [Java 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

---

## How to Run the Project

### **1. Build the Microservices**
From the root directory of each microservice (`ms-account`, `ms-customer`), run:
```bash
mvn clean package
```

### **2. Run with Docker Compose**
Ensure the JAR files are built and located in the `target/` directory of each microservice, then execute:
```bash
docker-compose up --build
```


## Environment Variables

These environment variables can be set to customize the deployment.

### **RabbitMQ**
| Variable              | Description                              | Default           |
|-----------------------|------------------------------------------|-------------------|
| `RABBITMQ_HOST`       | RabbitMQ server hostname.               | `localhost`       |
| `RABBITMQ_PORT`       | RabbitMQ server port.                   | `5672`            |
| `RABBITMQ_USERNAME`   | RabbitMQ username.                      | `guest`           |
| `RABBITMQ_PASSWORD`   | RabbitMQ password.                      | `guest`           |

### **PostgreSQL**
| Variable              | Description                              | Default           |
|-----------------------|------------------------------------------|-------------------|
| `DB_HOST`             | PostgreSQL server hostname.             | `localhost`       |
| `DB_PORT`             | PostgreSQL server port.                 | `5432`            |
| `DB_NAME`             | Database name.                          | `test_java`       |
| `DB_USERNAME`         | Database username.                      | `java_test_user`     |
| `DB_PASSWORD`         | Database password.                      | `java_test_password` |

---

## Testing

### **Run Integration Tests**
To run integration tests with H2 (in-memory database), execute:
```bash
mvn test
```


## Author

- **Name:** Ricardo Bravo
- **Contact:** ricardoj.bravo@hotmail.com
- **Date:** 2025-01-21

