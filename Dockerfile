FROM openjdk:17-jdk-alpine

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar
COPY run .

EXPOSE 8080

ENTRYPOINT ["./run"]
