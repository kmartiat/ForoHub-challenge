# 💬 ForoHub ![Status badge](https://img.shields.io/badge/status-in%20progress-yellow)

> This is one of the challenges proposed by Alura Latam in the Oracle Next Education program.

This project is a REST API that allows management of topics and user authentication with JWT.

## 🚀 Demo

Here's how to use the Forum Hub API using Swagger:

## ⚙️ Project Structure

1. `controller`: Contains the interactive menu, connection to services and a validator
2. `domain`: Entities for our database.
3. `dto`: Filter to send the data from dto not entities.
4. `repository`: Applying Spring Data JPA to make the queries.
5. `service`: All our persistence logics and api consumption.
6. `config`: Contains configuration classes for security or spring-doc.
7. `utils`: Contains the menu and textual interface options.

## 🔧 Installation

Before all, make sure you have Java (JAVA SDK 17) and some IDE (for example IntelliJ IDEA or Eclipse) installed.

#### 1. Initialize the project

- Clone the repository
  ``` bash
  git clone https://github.com/kmartiat/ForoHub-challenge.git
  ```

#### 2. Create the MySQL database on your computer.

#### 3. Open the project in IDE.

This can be done with the IDE of choice (IntelliJ IDEA or another).

#### 4. Define the following environment variables

- DB_HOST: your host (localhost for example)
- DB_NAME: database name
- DB_USERNAME: database username
- DB_PASSWORD: database password
- SECRET_JWT: secret word for jwt

#### 5. Run ForoHubApplication class.

## 🛠️ Built With

### Tech Stack

- Java 17

- Spring Boot

- Spring Data JPA

- Hibernate ORM

- MySQL

- Spring Security

- JWT (java-jwt)

- Springdoc Openapi

## 📝 License

The MIT License (MIT)