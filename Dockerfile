FROM openjdk:8-jdk-alpine

ADD target/postgres-searching-0.0.1.jar postgres-searching.jar
COPY run-java.sh run-java.sh
ENTRYPOINT JAVA_APP_JAR=postgres-searching.jar ./run-java.sh