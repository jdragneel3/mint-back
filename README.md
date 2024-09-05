# Instructor Scheduling System

## Overview

This project is a Java-based application using Micronaut for managing the scheduling of instructors in a training organization. It provides functionality to create, read, update, and delete instructors and their associated events. The system follows the MVC pattern and uses PostgreSQL for data persistence.

## Prerequisites

- Java 17 or higher
- Micronaut 4.x
- PostgreSQL
- Gradle
- Docker (optional, for running with Docker Compose)

## Setup

### Database Configuration

The application uses PostgreSQL as the database. Configure the database connection as follows:

- **Database Name**: mintdb
- **Username**: mintdb
- **Password**: interview

Ensure the PostgreSQL server is running and accessible.

### Application Configuration

The application's database configuration is located in `src/main/resources/application.yml`. Make sure it contains the following settings:

```yaml
datasources:
  default:
    url: jdbc:postgresql://localhost:5432/mintdb
    username: mintdb
    password: interview
    driver-class-name: org.postgresql.Driver

flyway:
  url: jdbc:postgresql://localhost:5432/mintdb
  user: mintdb
  password: interview
```
## Running the Application

### Local Development
To run the application locally, use Gradle:

```bash
./gradlew run
```

## Endpoints

### Instructors

- **Create Instructor**: `POST /instructors`
- **Get Instructor**: `GET /instructors/{id}`
- **Update Instructor**: `PUT /instructors/{id}`
- **Delete Instructor**: `DELETE /instructors/{id}`
- **Get All Instructors**: `GET /instructors`

### Events

- **Create Event**: `POST /events`
- **Get Event**: `GET /events/{id}`
- **Update Event**: `PUT /events/{id}`
- **Delete Event**: `DELETE /events/{id}`
- **Get All Events for Instructor**: `GET /instructors/{id}/events`

## Data Model

### Organization

- `id`: UUID
- `name`: String
- `address`: String
- `contactEmail`: String
- `contactPhone`: String
- `instructors`: List<Instructor>

### Instructor

- `id`: UUID
- `firstName`: String
- `lastName`: String
- `birthday`: LocalDate

### Event

- `id`: UUID
- `startDate`: LocalDate
- `endDate`: LocalDate
- `eventType`: String
- `description`: String

## Development

### Project Structure

- **api.mint.controller**: Controllers for handling HTTP requests.
- **api.mint.service**: Services for business logic.
- **api.mint.model**: Data models and entities.
- **api.mint.dto**: Data Transfer Objects (DTOs) for requests and responses.
- **api.mint.mapper**: Mappers for converting between entities and DTOs.


## Running Tests
To run tests, use:

```bash
./gradlew test
```