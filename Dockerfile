FROM openjdk:17-jdk-slim
MAINTAINER Malathi
COPY teamapi-0.0.1-SNAPSHOT.jar teamapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/teamapi-0.0.1-SNAPSHOT.jar"]