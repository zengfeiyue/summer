# Dockerfile
FROM openjdk:8
ADD target/summer-school-provider-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]