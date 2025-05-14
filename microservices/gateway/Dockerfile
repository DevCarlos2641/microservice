# ----------- BUILD STAGE ----------- #
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copiamos solo los archivos necesarios para cachear dependencias
COPY gradle gradle
COPY gradlew .
COPY build.gradle.kts settings.gradle.kts .

# Descargamos dependencias sin compilar aún
RUN ./gradlew build -x test --no-daemon || true

# Ahora sí, copiamos el resto del proyecto
COPY . .

RUN ./gradlew :microservice:gateway:build -x test --no-daemon

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/microservices/gateway/build/libs/*.jar msvc-gateway.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "msvc-gateway.jar"]

#   To build image docker
#   docker build -t msvc-gateway -f microservices/gateway/Dockerfile .