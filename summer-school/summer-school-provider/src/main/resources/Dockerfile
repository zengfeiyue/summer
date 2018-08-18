# Dockerfile
FROM java:8-jre
ADD summer-school-provider-0.0.1-SNAPSHOT.jar app.jar
ENV ZOOKEEPER_SERVER 127.0.0.1
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]