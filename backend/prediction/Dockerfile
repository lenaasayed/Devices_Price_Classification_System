# FROM apache-maven-3.9.6 AS build
FROM maven AS build

# // .\mvnw spring-boot:run
COPY src /src
COPY pom.xml pom.xml 
COPY .mvn /.mvn
# RUN /mvnw.cmd -f clean pom.xml  package
# RUN ./mvnw spring-boot:run
#
# Package stage
#
FROM openjdk:15

ADD target/prediction-0.0.1-SNAPSHOT.jar prediction-0.0.1-SNAPSHOT.jar
EXPOSE 7000
ENTRYPOINT ["java","-jar","/prediction-0.0.1-SNAPSHOT.jar"]