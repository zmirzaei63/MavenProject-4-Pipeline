# Base image with Java 8
FROM openjdk:8
# Expose the application port
EXPOSE 8080
ADD /target/lab3-1.0-SNAPSHOT.jar lab3-1.0-SNAPSHOT.jar

RUN ls
RUN pwd
# Define the command to run the application
CMD ["bash", "-c", "java -jar lab3-1.0-SNAPSHOT.jar && sleep 50"]
