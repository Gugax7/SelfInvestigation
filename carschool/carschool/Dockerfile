# --- Stage 1: Build the application ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application (this runs inside Docker using Java 21)
RUN mvn clean package -DskipTests

# --- Stage 2: Run the application ---
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/carschool-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]