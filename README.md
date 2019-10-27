# Todo list web application using Spring Boot and MySQL (in progress)

A simple Todo list application using Spring Boot with the following options:

- Spring JPA and MySQL for data persistence,
- Thymeleaf templae for the rendering,
- Spring Security for authentication and authorization,

To build and run the sample from a fresh clone of this repo:

## Configure MySQL

1. Create a database in your MySQL instance.
2. Update the application.properties file in the src/main/resources folder with the URL, username and password for your MySQL instance. The table schema for the Todo objects will be created for you in the database.

## Build and run the sample

1. mvnw package
2. java -jar target/TodoDemo-0.0.1-SNAPSHOT.jar
3. Open a web browser to http://localhost:8080
