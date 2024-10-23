FROM openjdk:17-jdk-slim

# Set the working-directory in the container
WORKDIR /devops-project

# Copy jar file to the docker container
COPY target/quizGame-1.0-SNAPSHOT.jar /devops-project/quizApp.jar

ENTRYPOINT ["java", "-jar","/devops-project/quizApp.jar"]

#EXPOSE 8080

