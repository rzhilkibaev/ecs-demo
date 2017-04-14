FROM java:8-jre

EXPOSE 8080 8081

COPY target/ecs-demo-service-1.0-SNAPSHOT.jar /
COPY config.yml /

CMD ["java", "-jar", "ecs-demo-service-1.0-SNAPSHOT.jar", "server", "config.yml"]
