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

# Compilamos solo el microservicio student
RUN ./gradlew :microservice:student:build -x test --no-daemon

# ----------- RUNTIME STAGE ----------- #
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/microservices/student/build/libs/*.jar msvc-student.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "msvc-student.jar"]

#   To build image docker
#   docker build -t msvc-student -f microservices/student/Dockerfile .