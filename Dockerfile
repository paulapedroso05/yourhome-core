# Etapa 1: Build
FROM maven:3.8-openjdk-17-slim AS build

COPY ~/.m2/settings.xml /usr/share/maven/conf/settings.xml

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests -Dspring.profiles.active=dev

# Etapa 2: Produção
FROM eclipse-temurin:17 AS production
LABEL authors="paulacerchiaropedroso"

WORKDIR /app

COPY --from=build /app/target/core-1.0.0.jar app.jar

EXPOSE 8080
ENTRYPOINT java -jar app.jar --spring.profiles.active=prod