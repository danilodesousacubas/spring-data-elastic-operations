FROM java:8-jdk-alpine
ADD target/api.jar /
ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "./target/api.jar"] 