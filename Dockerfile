# Use an OpenJDK runtime as the base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built from your Spring Boot application into the container
COPY .mvn/maven-wrapper.jar /app/maven-wrapper.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 8080

# Command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "maven-wrapper.jar"]