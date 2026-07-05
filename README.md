# Product Management System

A Java EE web application for managing products and categories through a centralized administration interface.

The application provides CRUD operations, authentication mechanisms, and database persistence using Java Enterprise technologies.

## Overview

This project was developed to explore server-side web development concepts and enterprise application architecture using Java EE.

The system enables administrators to manage products and categories while ensuring data consistency through a relational database.

## Features

- Product management
  - Create products
  - Update products
  - Delete products
  - View product details

- Category management
  - Create categories
  - Update categories
  - Delete categories
  - View category details

- Authentication
  - Administrator login
  - Logout functionality
  - Session management

- Database integration
  - Persistent storage using MySQL
  - JDBC connectivity

## Architecture

The application follows a layered architecture inspired by the MVC pattern.

Presentation Layer (JSP)
        │
        ▼
Controller Layer (Servlets)
        │
        ▼
Business Logic
        │
        ▼
Persistence Layer (JDBC)
        │
        ▼
MySQL Database

## Tech Stack

| Technology | Description |
|------------|------------|
| Java | Core language |
| Java EE | Enterprise web development |
| Servlets | Request processing |
| JSP | User interface |
| JDBC | Database access |
| MySQL | Relational database |
| Maven | Dependency management |
| Apache Tomcat | Application server |

## Project Structure
src
└── main
    ├── java
    │   └── com.example
    │       ├── models
    │       └── servlets
    │
    ├── resources
    └── webapp


## Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL
- Apache Tomcat

### Installation

Clone the repository:

bash
git clone https://github.com/sayarinessrine/jee-product-management.git


Build the project:

bash
mvn clean install


Deploy the generated WAR file on Apache Tomcat.

## Future Improvements

- RESTful API migration
- Spring Boot implementation
- JWT Authentication
- Role-based access control
- Docker containerization
- Automated testing

## Author

**Nessrine Sayari**

Software Engineering Student at ESPRIT

Backend Development • Software Architecture • Cloud Computing
