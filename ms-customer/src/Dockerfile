FROM openjdk:17

ADD target/*.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

RUN chmod +x app.jar