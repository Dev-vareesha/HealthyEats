# First stage: build the Spring Boot app using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY HealthyEats/pom.xml .
COPY HealthyEats/src ./src
RUN mvn clean package -DskipTests

# Second stage: run the app with JDK
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
