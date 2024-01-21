FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY ./currency-provider/target/currency-provider-0.0.1-SNAPSHOT.jar app1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app1.jar"]
