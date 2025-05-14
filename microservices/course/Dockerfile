FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copiamos solo los archivos necesarios para cachear dependencias
COPY gradle gradle
COPY gradlew .
COPY build.gradle.kts settings.gradle.kts .
RUN ./gradlew build -x test --no-daemon || true

COPY . .

RUN ./gradlew :microservice:course:build -x test --no-daemon

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/microservices/course/build/libs/*.jar msvc-course.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "msvc-course.jar"]

#   To build image docker
#   docker build -t msvc-course -f microservices/course/Dockerfile .