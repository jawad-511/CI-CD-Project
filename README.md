
# Testing Project

## Overview
This project is a Spring Boot application that performs CRUD operations for a task management system. It is packaged using Docker and managed through a Jenkins CI/CD pipeline.

## Project Structure
- **src/main/java**: Contains the Java source code for the Spring Boot application.
- **src/main/resources/application.properties**: Configuration file for the Spring Boot application.
- **Jenkinsfile**: Jenkins pipeline configuration to automate build, test, packaging, and deployment processes.
- **Dockerfile**: Docker configuration to package the application in a Docker container.

## Requirements
To run this project, you need the following tools installed:
- **Java 17**: Required to build and run the Spring Boot application.
- **Maven**: Required to manage dependencies and build the project.
- **Docker**: Required to containerize and run the application.
- **Jenkins**: Required for CI/CD automation (optional if not using Jenkins).

## Setup and Installation

### 1. Clone the repository
```bash
git clone https://github.com/Eng-Eyad77/Testing-Project.git
cd Testing-Project
```

### 2. Build the project using Maven
Compile and package the application:
```bash
mvn clean compile
mvn package -DskipTests=false
```

### 3. Run the application with Docker
Build the Docker image and run the container:
```bash
docker build -t mvc-image .
docker run -d --name spring-boot-app -p 8081:8081 mvc-image
```

### 4. Access the application
After running the container, the application should be accessible at:
```
http://localhost:8081
```

If you are deploying on a server, replace `localhost` with your server IP.

## Jenkins Pipeline

The project includes a `Jenkinsfile` that defines a pipeline with the following stages:
1. **Checkout**: Pulls the latest code from the `main` branch.
2. **Build**: Compiles the code using Maven.
3. **Test**: Runs unit tests.
4. **Package**: Packages the application as a JAR file.
5. **Build Docker Image**: Creates a Docker image for the application.
6. **Deploy Docker Container**: Deploys the Docker container to the specified port (8081).

### Notifications
The pipeline is configured to send email notifications to `four.engineers2025@gmail.com` upon success or failure of the pipeline execution.

### Jenkins Configuration
To set up Jenkins for this project:
1. Add a new pipeline job in Jenkins.
2. Use the GitHub repository URL: `https://github.com/Eng-Eyad77/Testing-Project.git`
3. Ensure that your Jenkins has Docker and Maven installed and configured.
4. Set up SMTP settings in Jenkins to enable email notifications.

## Dockerfile Details
The Dockerfile is structured in two stages:
1. **Build Stage**: Uses a Maven image to build the project and create a JAR file.
2. **Runtime Stage**: Uses a lightweight JDK image to run the application.

### Ports
The application is configured to run on **port 8081**, which is exposed by Docker and mapped to the host.

### Environment Configuration
The `application.properties` file configures the application to run on `0.0.0.0:8081`.

## Troubleshooting
If you encounter issues:
- Ensure Docker and Jenkins have the necessary permissions.
- Check the Jenkins console for pipeline logs.
- Confirm Docker and Jenkins services are running properly on your server.

## License
This project is licensed under the MIT License.

## Contact
For questions or feedback, please reach out to the project owner.
