FROM openjdk:17
VOLUME /tmp
EXPOSE 8092
ARG JAR_FILE=target/Programa_Team1-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

