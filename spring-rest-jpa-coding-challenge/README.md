# Feedback API

You are developing a REST api that will allow the customers of a store to provide feedback to the products 
that they have purchased from that store. One user is allowed to register one feedback for a product. The user should be able to list all the products available in the store and provide feedback to one of the product. The 
user should also be able to edit or delete the feedback which was provided earlier. In addition to this make sure the user is able to list all the feedbacks provided by the user for different products and different feedbacks provided for one product.

## Endpoints

| Method              | Endpoint| Description |
| :---------------- | :------ | ---- |
|GET|       /api/products/|                 List all products in the store|
|GET|       /api/products/:pid/feedbacks|   List all feedbacks available for that product |
|POST|      /api/products/:pid/feedbacks|   Provide a new feedback  for that product |
|GET|       /api/feedbacks/:uid|            Lists all the feedback made by the user|
|PUT|       /api/feedbacks/:fid|            Edit the feedback made by the user|
|DELETE|    /api/feedbacks/:fid|            Delete the feedback made by the user|

## Database Schema

### **Products**

|Column|    Datatype|   Constraints|
| :---------------- | :------ | ----: |
|ProductId| Integer| Primary Key|
|Description| Varchar| Not empty|

### **Users**

|Column|    Datatype|   Constraints|
| :---------------- | :------ | ----: |
|UserId| Integer| Primary Key|
|Username| Varchar| Not empty|
|Password| Integer| Foreign Key|

### **Feedbacks**

|Column|    Datatype|   Constraints|
| :---------------- | :------ | ----: |
|FeedbackId| Integer| Primary Key|
|Comment| Varchar| Not empty|
|Product| Integer| Foreign Key|
|User| Integer| Foreign Key|

## Instructions

- A user is allowed to make only one feedback on a product. If the user tried to provide more that one feedback then `FeedbackAlreadyProvidedException` must be thrown.
- All fields are mandatory, incase user is not providing the data then `MalformedRequestException` must be thrown.
- Use the `schema.sql` to create the database schema.
- Populate the data into the `products` and `users` table using `data.sql`.
- Use JPA mapping whereever necessary.
- Implement console logging and file logging.
- Only `WARN` and `ERROR` logs needs to be logged into the log file.
- Make sure detailed error messages and stacktrace information is logged into the log files.
- While handling errors make sure the stacktrace information is not shared with the user.


## Requirements

- Use `Spring Boot` to develop the `REST API`.
- Use `Spring Data JPA` to interact with the database.
- Use `H2` as the database.
- Use Java `record` as `DTO`'s.
- Use Swagger to generate documentation for the API.
- The API must have a `repository` layer.
- The API must have a `service` layer.
- The API must implement logging.
- The API must handle exceptions.
