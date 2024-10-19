FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/trailers-0.0.1-SNAPSHOT.jar trailers-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/trailers-0.0.1-SNAPSHOT.jar"]
