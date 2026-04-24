# Build stage
FROM eclipse-temurin:17-jdk AS builder

WORKDIR /build

# Copy Maven project
COPY pom.xml .
COPY src src

# Build the application
RUN apt-get update && apt-get install -y maven && \
    mvn -B package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the JAR from builder stage
COPY --from=builder /build/target/banking-system-1.0.0.jar app.jar

# Expose port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 \
    CMD curl -f http://localhost:8080/api/accounts || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
