FROM openjdk:17-alpine3.13
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/TodoApp-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ToDo.jar
ENTRYPOINT ["java","-Djava.security.egd-file:/dev/./urandom","-jar","/ToDo.jar"]