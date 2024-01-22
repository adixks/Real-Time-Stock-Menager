FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY ./mail-service/target/mail-service-0.0.1-SNAPSHOT.jar app4.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app4.jar"]
