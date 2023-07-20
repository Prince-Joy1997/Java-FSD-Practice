# Spring Boot Assessment - 1

## Problem Statement

Create a Spring Boot application to perform CRUD operations on a User entity. 
The User entity should have the following fields:
```
    id: Long
    name: String
    email: String
    password: String
```

The entity must be created in the `in.stackroute.ust.domain` package and the 
repository must be created in the `in.stackroute.ust.repository` package. 
The controller must be created in the `in.stackroute.ust.controller` package.

## Requirements

1. The application should have the following endpoints:
    - GET /users
    - GET /users/{id}
    - POST /users
    - PUT /users/{id}
    - DELETE /users/{id}
2. The application should use an in-memory database to store the data. Use H2 for this purpose.
3. The application should use Spring Data JPA to perform database operations.

## Submission

Fork and clone this repository. 
Push your code to your forked repository and submit the link to your repository.


All the best!
