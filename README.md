# TaskManagementApplication

1. Introduction
The Task Management Application is designed to help users manage tasks efficiently. This documentation provides an overview of the application's architecture, setup instructions, and additional notes for developers.

2. Architecture Overview
Technologies Used
Backend:

Java
Spring Boot
Hibernate
H2 Database (for development)

Frontend:
Postman

Project Structure
src/main/java/com/taskmanagement:
controller: Handles HTTP requests and responses.

model: Defines data entities (e.g., Task).
repository: Manages interactions with the database.
service: Implements business logic and interacts with repositories.

3. Setup Instructions
Prerequisites
JDK 1.8
Maven or Gradle

Steps
Clone the repository:
bash
Copy code
git clone <repository-url>
Navigate to the project directory:
bash
Copy code
cd task-management-application
Build the project:
Using Maven:
bash
Copy code
mvn clean install
Using Gradle:
bash
Copy code
./gradlew build
Run the application:
bash
Copy code
java -jar target/taskmanagement-application.jar
Access the application at http://localhost:8770

4. Usage
Access the Task Listing:

Open your web browser and go to http://localhost:8770/tasks 


Task Creation:

Use appropriate REST API verbs to create/save task information.
Task Details:

Access task details by providing the task ID as a path parameter.
Task Editing:

Use appropriate REST API verbs to update/modify task information.
Task Deletion:

Delete tasks from the list by specifying task ID as a query parameter.

5. Additional Notes for Developers
Exception Handling:

Ensure proper error handling and validation in CRUD operations.
Clean Code Practices:

Focus on clean, readable, and maintainable code.

6. Database Configuration:

For development, the application uses an H2 in-memory database. Update the database configuration for production use.
Dependency Management:

Utilize Maven or Gradle for backend dependency management.
Testing:

Write unit tests for backend API endpoints using frameworks like JUnit.

7. License
This project is written by Amadou Dioulde Bah.
