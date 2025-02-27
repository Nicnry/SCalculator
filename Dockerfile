# Utilise une image officielle de Maven avec OpenJDK 17
FROM maven:3.8.5-openjdk-17 AS builder

# Définit le répertoire de travail
WORKDIR /app

# Copie le fichier pom.xml et les fichiers de code source
COPY pom.xml .
COPY src ./src

# Build l'application
RUN mvn clean package -DskipTests

# Utilise une image Java pour exécuter l'application
FROM openjdk:17-jdk-slim
COPY --from=builder /app/target/crud-0.0.1-SNAPSHOT.jar crud-app.jar

# Définit la commande par défaut pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/crud-app.jar"]
