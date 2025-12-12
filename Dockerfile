# ====== BUILD STAGE ======
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copio prima i file Maven per sfruttare la cache
COPY .mvn/ .mvn/
COPY mvnw mvnw
COPY pom.xml pom.xml

# Scarico dipendenze (cache layer)
RUN chmod +x mvnw && ./mvnw -DskipTests dependency:go-offline

# Copio sorgenti e buildo
COPY src/ src/
RUN ./mvnw -DskipTests package

# ====== RUN STAGE ======
FROM eclipse-temurin:21-jre
WORKDIR /app

# Render imposta PORT automaticamente
ENV PORT=8080

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Avvio: profilo demo (H2) + porta di Render
CMD ["sh","-c","java -jar app.jar --spring.profiles.active=demo --server.port=${PORT}"]
