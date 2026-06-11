**Part 4 - Project Investigation**

1.  What is Spring Boot?
Spring Boot is an open-source, Java-based framework. It is built directly on top of Spring Framework acting as an automation layer, 
making it easier to create and run applications by providing default configurations and embedded servers, allowing developers to build 
applications quickly with minimal setup.

2.  What is Maven?
Maven is a build automation and dependency management tool that helps manage libraries, compile code, run tests and package applications. 
It is mainly used for Java projects.

3.  What is the purpose of pom.xml?
Pom.xml (Project Object Model) file is the heart of the projects created. It is the main configuration file in a Maven Project.
It is in xml format. Maven uses it to download project information, dependencies, plugins and build settings required for the application.
    
4. What is the purpose of application.properties?
The application.properties file is used to configure a Spring Boot application. It stores settings such as database connection details, server ports 
and other application-specific properties.

5. What does @SpringBootApplication do?
@SpringBootApplication annotation is a convenient meta-annotation used to mark the main configuration class and entry point of a Spring Boot application.
It reduces configuration complexity by combining configuration, component scanning, and auto-configuration to simplify application setup. 

6. Why do developers use dependency management tools such as Maven?
Developers use Maven to automatically download and manage project libraries, ensure consistent project builds, reduce manual configuration, and simplify 
dependency updates.

7. What is a REST API?
A (Representational State Transfer Application Programming Interface) REST API is an interface that allows applications to communicate over the internet
(HTTP) using standard methods such as GET, POST, PUT, and DELETE data from a server.

8. What is JSON?
JSON (JavaScript Object Notation) is a lightweight data format used to store and exchange information. It is easy for humans to read and write as well as 
applications to process.

9. What is Dependency Injection?
Dependency Injection (DI) is a software design technique where an object receives its required dependencies from an external source rather than creating them itself.

**Part 5 - Package Structure**

1. The controller package expose the application's REST API endpoints. It contains classes that handle incoming HTTP requests and return responses to clients.

2. The service package contains the business logic of the application by processing data and coordinates communication between controllers and repositories.

3. The repository package contains interfaces that perform CRUD (Create, Read, Update, Delete) operations. It is responsible for interacting with the database.

4. The entity package contains classes that represent database tables. These classes are mapped to database tables using JPA annotations.

5. Data Transfer Object (DTO) package contains objects used to transfer data between different layers of the application without exposing internal entities differently.

6. The config package contains configuration classes used to customize the application's behaviour, such as security, database, or bean configurations.

7. The exception package contains custom exception classes and handlers used to manage errors and provide meaningful responses to users.