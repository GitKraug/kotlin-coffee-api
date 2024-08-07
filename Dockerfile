FROM openjdk:22-jdk-slim AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

COPY pom.xml /app
COPY src /app/src

RUN ./mvnw clean package -f /app/pom.xml -DskipTests

FROM openjdk:22-jdk-slim
WORKDIR /app

COPY --from=build /app/target/tempokraug-api-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]