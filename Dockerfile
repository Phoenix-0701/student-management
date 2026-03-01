# Stage 1: Build - Sử dụng Maven để biên dịch code thành file JAR 
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests [cite: 296-299]

# Stage 2: Run - Sử dụng JRE nhỏ gọn để chạy ứng dụng 
FROM eclipse-temurin:21-jre
WORKDIR /app
# Lấy file JAR đã build từ Stage 1 sang Stage 2 
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080 [cite: 303]
ENTRYPOINT ["java", "-jar", "app.jar"] [cite: 304]