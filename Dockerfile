FROM openjdk:22-jdk-slim AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

COPY pom.xml /app
COPY src /app/src

RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw clean package -f /app/pom.xml -DskipTests

FROM openjdk:22-jdk-slim
WORKDIR /app

COPY --from=build /app/target/kotlin-coffee-api-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]