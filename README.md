# Book Library API

A RESTful API built with Spring Boot that simulates a digital book library system. 
Users can add books, search by author, genre, or title, and manage the full book catalog.

## Tech Stack

- Java 17
- Spring Boot 4.0.6
- Spring Data JPA / Hibernate
- PostgreSQL
- Docker & Docker Compose
- Maven
- Lombok

## Features

- Full CRUD operations for books
- Search by author (partial match), genre, and title (partial match)
- Filter books published after a specific year
- Global exception handling with proper HTTP status codes
- Containerized with Docker for portable deployment

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/books | Get all books |
| GET | /api/books/{id} | Get book by ID |
| GET | /api/books/search?author= | Search by author |
| GET | /api/books/search?genre= | Search by genre |
| GET | /api/books/search?title= | Search by title |
| GET | /api/books/published-after?year= | Get books published after a year |
| POST | /api/books | Add a new book |
| PUT | /api/books/{id} | Update a book |
| DELETE | /api/books/{id} | Delete a book |

## Running Locally

### Prerequisites
- Java 17
- PostgreSQL
- Maven

### Steps
1. Clone the repository: git clone https://github.com/venkatahaswitha-afk/book-library-api.git
2. Create a PostgreSQL database
```sql
   CREATE DATABASE book_library_db;
```

3. Update `src/main/resources/application.properties` with your DB credentials

4. Run the application : ./mvnw spring-boot:run
5. API will be available at `http://localhost:8080`

## Running with Docker

### Prerequisites
- Docker Desktop

### Steps
1. Clone the repository : git clone https://github.com/venkatahaswitha-afk/book-library-api.git
2. Run with Docker Compose : docker-compose up --build
3. API will be available at `http://localhost:8080`

## Sample Request

### Add a book
```json
POST /api/books
{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "genre": "Classic",
  "description": "A story of wealth and the American Dream",
  "publishedYear": 1925,
  "availableCopies": 3
}
```

### Search by author : GET /api/books/search?author=Fitzgerald
## Error Handling

The API returns structured error responses for all error cases:

```json
{
  "status": 404,
  "message": "Book with id 999 not found",
  "timestamp": "2026-05-12T15:00:00"
}
```

Save it, then commit and push:
git add .
git commit -m "Add README"
git push
