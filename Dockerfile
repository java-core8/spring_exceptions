FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9999
ADD build/libs/autorize%20-0.0.1-SNAPSHOT-plain.jar spring_exceptions.jar
ENTRYPOINT ["java", "-jar", "spring_exceptions.jar"]
