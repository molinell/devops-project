#FROM openjdk:17-jdk-slim
FROM openjdk:17-slim

# Set the working-directory in the container
WORKDIR /devops-project

# Copy jar file to the docker container
COPY target/quizGame-1.0.jar quizApp.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quizApp.jar"]



