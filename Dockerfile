FROM java:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD target/api.jar /
ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "api.jar"] 