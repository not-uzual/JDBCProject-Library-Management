# Library Management System - JDBC Project

A simple Java-based Library Management System using JDBC to connect to MySQL database.

## Features

- **Create**: Add new books to the library
- **Read**: View all books in the library  
- **Update**: Modify book records (currently supports updating publication year)
- **Delete**: Remove books from the library

## Project Structure

```
src/
├── App.java                  # Main application entry point
├── DatabaseConnection.java   # Database connection utility
└── CRUD.java                 # CRUD operations for book management

lib/
└── mysql-connector-j-8.0.33.jar   # MySQL JDBC driver

bin/                          # Compiled class files
```

## Database Schema

The application expects a MySQL database named `library` with a `books` table:

```sql
CREATE DATABASE library;
USE library;

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    release_year INT
);
```

## How to Run

### Prerequisites
- Java 8 or higher
- MySQL server running
- Database and table created as shown above

### Running the JAR file
```bash
java -jar library-management.jar
```

### Running from source
```bash
# Compile
javac -cp "lib/mysql-connector-j-8.0.33.jar" -d bin src/*.java

# Run
java -cp "bin;lib/mysql-connector-j-8.0.33.jar" App
```

## Database Configuration

Update the database connection details in `DatabaseConnection.java`:
- **URL**: `jdbc:mysql://localhost:3306/library`
- **Username**: `root`
- **Password**: `letsgo` (change as needed)

## Usage

1. Run the application
2. Choose from the menu options:
   - 1: Register a new book
   - 2: Show all books
   - 3: Update book record
   - 4: Delete book record
   - 5: Exit

## Technologies Used

- Java
- JDBC
- MySQL
- MySQL Connector/J

## Author

Created as a learning project for database connectivity using JDBC.
