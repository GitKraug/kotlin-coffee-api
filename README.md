# Coffee API ☕️

![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)
![Docker](https://img.shields.io/badge/docker-ready-blue.svg)
![Kotlin](https://img.shields.io/badge/kotlin-v1.8.0-orange.svg)
![Spring Boot](https://img.shields.io/badge/spring--boot-3.0.0-brightgreen.svg)
![PostgreSQL](https://img.shields.io/badge/postgresql-15-blue.svg)

## Overview

The **Coffee API** is a simple RESTful API that provides data about different types of coffee. 
The intention was to learn more about the Kotlin language, in addition to integration testing using Testcontainers and WireMock.
A PostgreSQL database is used to store the coffee data.
The project is fully containerized using Docker and Docker Compose for easy setup and deployment.

## Features

- 📋 List all types of coffee
- 🔍 Get details about a specific type of coffee by ID
- 👥 List all coffee customers
- ➕ Add a new type of coffee
- ❌ Delete a coffee entry by ID

## Technologies

- **Language:** Kotlin
- **Framework:** Spring Boot
- **Database:** PostgreSQL
- **Containerization:** Docker, Docker Compose
- **Integration testing:** WireMock, Testcontainers

## Getting Started

### 1. Clone the repository

```bash
git clone git@github.com:GitKraug/kotlin-coffee-api.git
cd coffee-api
```

### 2. Build and Run the Application
Build the Docker containers and start the application:

```bash
docker-compose up --build
```
This will start the Coffee API and PostgreSQL database in separate containers.

### 3. API Endpoints

| HTTP Method | Endpoint             | Description                                 |
|-------------|----------------------|---------------------------------------------|
| **GET**     | `/api/coffee/all`    | Retrieve a list of all coffee types         |
| **POST**    | `/api/coffee/new`    | Add a new coffee                            |
| **DELETE**  | `/api/coffee/{id}`   | Delete a coffee by ID                       |
| **GET**     | `/api/customers/all` | Retrieve a list of all coffee customers     |

### 4. Accessing the API
Once the containers are up and running, you can access the API at 

```bash
http://localhost:8080/api/coffees
```

### 5. Configuration
The application can be configured via environment variables. The project utilizes Spring Profiling to load the correct 
configurations for the correct environments. Make sure to set `SPRING_PROFILES_ACTIVE` when running the app outside of Docker.

## ☕ Fuel Your Code with Coffee API ##
Ready to caffeinate your development? With the Coffee API, you're just a sip away from brewing up robust and rich applications. Dive in, explore the endpoints, and start coding with the energy and aroma that only coffee can inspire.