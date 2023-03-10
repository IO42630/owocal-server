# Build
FROM maven:3.8.5-amazoncorretto-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package assembly:single

# Run
FROM amazoncorretto:17
COPY --from=build /home/app/target/owocal-server-0.0.1-jar-with-dependencies.jar /usr/local/lib/owocal-server.jar
WORKDIR /home/app/target/
EXPOSE 8090
ENTRYPOINT ["java","-jar","/usr/local/lib/owocal-server.jar"]
