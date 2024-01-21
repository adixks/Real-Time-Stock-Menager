FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY ./currency-persistance-service/target/currency-persistance-service-0.0.1-SNAPSHOT.jar app2.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app2.jar"]
