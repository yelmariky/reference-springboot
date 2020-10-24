FROM openjdk:8-jdk-alpine


WORKDIR /app
ADD target/reference-springboot*.jar reference-springboot.jar
RUN mkdir /app/logs

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","reference-springboot.jar"]

## docker build . -t reference-springboot:v1