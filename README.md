# Bookshop Demo
A demo bookshop Spring Boot project using REST
## Prerequisite
- Apache Kafka version 2.13-2.60
- Java 8+
## Steps
### Windows
#### Start ZooKeeper service
`cd <kafka folder>/bin/windows`
1. `zookeeper-server-start.bat ../../config/zookeeper.properties`
#### Start Kafka broker service
1. `kafka-server-start.bat ../../config/server.properties`
#### Read events using consumer
_If it doesn't work, run this after running the Spring Boot application_
1. `kafka-console-consumer.bat --topic bookTopic --from-beginning --bootstrap-servers localhost:9092`
## Running the application
1. After cloning this repository, run `gradlew clean build`
2. Then `gradlew bootRun`
3. To access H2 console, use `localhost:8080/h2-console` and connect
4. Get all books records by entering `/books`
5. Get an individual valid book record by entering `/book/<isbn>`, Kafka consumer will consume the individual book record that was produced in the Kafka topic.
HTTP reponse can be viewed from Postman or browser console.
## Terminate Kafka environment
1. Stop consumer client with `Ctrl-C`
2. Stop Kafka broker with `Ctrl-C`
3. Stop ZooKeeper service with `Ctrl-C`
