FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew :microservice:eureka:build -x test

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/microservices/eureka/build/libs/*.jar msvc-eureka.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "msvc-eureka.jar"]

#   To build image docker
#   docker build -t msvc-eureka -f microservices/eureka/Dockerfile .