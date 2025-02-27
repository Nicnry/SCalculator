# CRUD Facilitator with Spring

This project provides a CRUD facilitator based on Spring to simplify the creation of CRUD operations for entities. It uses abstract classes to minimize code repetition and speed up development.

## Features
- Create, read, update, and delete operations for entities.
- Abstract classes for entities, DTOs, controllers, and services.
- Simplified database configuration with Spring.
- Fully containerized with Docker for easy deployment and management.

## Prerequisites
- Docker
- Docker Compose
- Java 17 or higher (for local development, if needed)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Nicnry/JavaSpringCrud.git
   cd JavaSpringCrud
2. Edit .env.example with correct informations (Docker database and app name)
3. Build and start the containers:
   ```bash
   docker-compose up --build
4. The project started on port 8080.
