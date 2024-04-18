FROM maven:3.8.5-openjdk-17
VOLUME /tmp
COPY . .
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]