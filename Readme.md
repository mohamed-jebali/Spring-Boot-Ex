
<p align="center">
  <a href="https://www.postgresql.org/">
    <img src="https://vscjava.gallerycdn.vsassets.io/extensions/vscjava/vscode-spring-initializr/0.11.2023070103/1688180724473/Microsoft.VisualStudio.Services.Icons.Default" height="250">
  </a>
</p>

## Spring Initializr
Go to [Spring Initializr](https://start.spring.io/)

## Project Configuration
- **Project:** Maven
- **Language:** Java
- **Spring Boot Version:** 2.6.0 (or a stable version)

## Project Metadata
- **Group:** com.example
- **Artifact:** demo
- **Name:** nome-progetto
- **Description:** Demo project for Spring Boot
- **Package Name:** com.example.demo
- **Packaging:** Jar
- **Java Version:** 17 (or a version compatible with Spring Boot)

## Dependencies
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL**


## Connection To PostgreSQl

- Terminal Example input:

1. `template1=# GRANT ALL PRIVILEGES ON DATABASE "template1" TO mohamed;
GRANT`

2. `template1=# GRANT ALL PRIVILEGES ON DATABASE "template1" TO postgres;
GRANT`

3. Add to pom.xml the JPA DATA dependency


