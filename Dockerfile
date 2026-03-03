# =========================
# Stage 1 - Build
# =========================
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app

# Cache de dependências
COPY pom.xml .
RUN mvn -B -q -DskipTests dependency:go-offline

# Código-fonte
COPY src ./src

# Build do projeto
RUN mvn -B -DskipTests clean package

# =========================
# Stage 2 - Runtime
# =========================
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia apenas o jar final
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]