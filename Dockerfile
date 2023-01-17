FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

RUN mkdir ./logs

COPY ./target/elfin-tech-1.0.0-SNAPSHOT.jar ./app.jar

ENV SPRING_PROFILES_ACTIVE "demo"

CMD ["java", "-jar", "./app.jar"]