FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} virtual-store-parent-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/virtual-store-parent-0.0.1-SNAPSHOT.jar"]