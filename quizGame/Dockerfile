#FROM openjdk:17-jdk-slim

# Set the working-directory in the container
#WORKDIR /devops-project

# Copy jar file to the docker container
#COPY target/quizGame-1.0.jar /devops-project/quizApp.jar

#ARG JAR_FILE=target/quizGame-1.0.jar
#ADD ${JAR_FILE} /quizApp.jar

#ENTRYPOINT ["java", "-jar","/devops-project/quizApp.jar"]
#FROM openjdk:8-jre

FROM openjdk:17-slim

WORKDIR /devops-project
ENTRYPOINT ["java", "-jar", "/app.jar"]

ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
EXPOSE 8080

