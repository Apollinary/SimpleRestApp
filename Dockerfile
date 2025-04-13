FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
COPY target/simple-rest-app-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
