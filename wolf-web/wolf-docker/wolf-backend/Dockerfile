FROM openjdk:8-jre
WORKDIR /app
ADD  wolf*-exec.jar  app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]