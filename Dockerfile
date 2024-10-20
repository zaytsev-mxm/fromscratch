FROM openjdk:20-jdk

WORKDIR /app

COPY build/libs/fromscratch-1.0-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]