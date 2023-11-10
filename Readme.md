## Overview
This is a SimpleWarehouse Project. Built with Spring Boot, and MySQL





## System Design

#### Backend - Repository Design Pattern
In this project, we have adopted the Repository Design Pattern as a fundamental architectural approach to manage our data access layer. 

* Separation of Concerns
The Repository pattern allows us to decouple our application's business logic from the underlying data access code. By isolating data access into repositories, we can make changes to our database-related code without impacting the core business logic of the application.

* Code Reusability
Utilizing repositories enables us to reuse data access logic across different parts of the application. Instead of duplicating database queries or CRUD operations throughout our codebase, we can centralize this logic in repository classes.


* Clean and Structured Architecture
Adopting the Repository pattern aligns with our goal of maintaining a clean and structured architecture for our application. It complements other design principles and patterns, such as the Single Responsibility Principle.

### Logging - Singleton Design Pattern
A Singleton logger provides a globally accessible point to log messages from any part of the application. Developers don't need to pass logger instances as parameters or create new instances for different parts of the code. This simplifies the logging process and makes it more convenient.


#### Database
A relational database was used to utilize the ACID features that is supported by NoSQL. As we deal with data warehouse store, maintaining the data integrity and efficiency is crucial part of designing our system.

#### Performance

* In order to optimize the retrieval process, a clustered index was added to the database table.
* ORM framework implements lazy loading, which allows data to be loaded on-demand as needed rather than loading all related data upfront. This also improves the efficiency of data retrieval.
* In addition, ORM frameworks include built-in caching mechanisms that can help reduce the number of database queries by storing and reusing data

#### Security
* Spring uses an Object-Relational Mapping (ORM) library to access databases which designed to help prevent SQL injection vulnerabilities. 
* Data Validation on both Front & Back end.


#### Maintainability & Scalabiliy

* Packages were implemented in respect to the Microservice architecture
* All methods follows the Single Responsibility Principle
