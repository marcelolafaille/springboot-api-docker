## MS
#FROM azul/zulu-openjdk-alpine:8
# For Java 8, try this
# FROM openjdk:8-jdk-alpine
# For Java 11, try this
#FROM adoptopenjdk/openjdk11:alpine-jre
FROM openjdk:11.0.8-jre-slim
VOLUME /tmp
EXPOSE 8080
COPY target/springboot-api-docker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
