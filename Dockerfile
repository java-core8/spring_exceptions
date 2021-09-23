FROM adoptopenjdk/openjdk11
VOLUME /tmp
EXPOSE 9999
ADD build/libs/autorize-0.0.1-SNAPSHOT.jar spring_exceptions.jar
ENTRYPOINT ["java", "-jar", "spring_exceptions.jar"]
