# === Build stage ===
FROM maven AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# === Run stage ===
FROM ubuntu/jre:21-24.04
WORKDIR /java
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/java/app.jar"]

