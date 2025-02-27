# Étape de construction
FROM openjdk:17-jdk-slim as builder

# Installer Maven dans l'étape de construction
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copier le pom.xml et les sources
COPY pom.xml .
COPY src /app/src

# Construire le projet
RUN mvn clean install -DskipTests

# Étape d'exécution
FROM openjdk:17-jdk-slim

# Installer Maven également dans l'étape d'exécution
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copier le pom.xml et les sources de l'étape de construction
COPY --from=builder /app /app

# Exposer le port
EXPOSE 8080

# Utiliser Maven pour démarrer l'application en mode développement avec hot reload
CMD ["mvn", "spring-boot:run"]
