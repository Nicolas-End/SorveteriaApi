##=== BUILD ===
FROM eclipse-temurin:latest
LABEL authors="Nicolas-End"

WORKDIR /Sorveteria api

COPY target/SorverteriaApi-0.0.1-SNAPSHOT.jar .


EXPOSE 8080


CMD ["java", "-jar", "SorverteriaApi-0.0.1-SNAPSHOT.jar"]