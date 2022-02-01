FROM openjdk:15

WORKDIR /app

COPY target/*.jar app.jar
COPY bootstrap.yml bootstrap.yml
EXPOSE 8081 8500


CMD ["java" ,"-Djava.security.egd=file:/dev/./urandom --spring.config.location=classpath:file:/app/bootstrap.yml","-jar","/app/app.jar"]
