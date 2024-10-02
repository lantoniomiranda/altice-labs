FROM ibm-semeru-runtimes:open-21-jdk-jammy AS build

RUN apt-get update && apt-get install -y maven && apt-get clean

WORKDIR /app

RUN mvn wrapper:wrapper

COPY . .

RUN ./mvnw package -Dquarkus.package.type=uber-jar

FROM openjdk:21

WORKDIR /app

COPY --from=build /app/target/*-runner.jar /app/application.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/application.jar"]
