FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY ./exchangeApiApplication/target/exchangeApiApplication-0.0.1-SNAPSHOT.jar app3.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app3.jar"]
