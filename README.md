# FinTrack - Personal Finance Tracker API

A RESTful API built with Spring Boot for tracking personal income and expenses

## Tech Stack

- Java 22
- Spring Boot 3.5
- Spring Security + JWT
- PostgreSQL
- Docker
- Maven

## Features

- User registration and login with JWT auth
- BCrypt password hashing
- Income and expense trackinig
- Category management
- Monthly financial summary (total income, total expense, net balance)

## Getting Started

### Prerequisites

- Java 22
- Docker

### Run the database
``` bash
docker run --name fintrack-db -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=fintrackdb -p 5433:5432 -d postgres
```

### Run the application
```bash
./mvnw spring-boot:run
```

## API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/register | Register a new user |
| POST | /api/auth/login | Login and get JWT token |

### Users
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/users | Get all users |
| DELETE | /api/users/{id} | Delete a user |

### Categories
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/categories | Get all categories |
| POST | /api/categories | Create a category |
| DELETE | /api/categories/{id} | Delete a category |

### Transactions
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/transactions | Get all transactions |
| POST | /api/transactions | Create a transaction |
| DELETE | /api/transactions/{id} | Delete a transaction |
| GET | /api/transactions/summary/{userId} | Get financial summary |

## Authentication

All endpoints except `/api/auth/**` require a JWT token in the header:
```
Authorization: Bearer <token>
```
