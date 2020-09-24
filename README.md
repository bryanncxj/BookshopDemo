# Bookshop Demo
A demo bookshop Spring Boot project using REST
## Prerequisite
- Apache Kafka version 2.13-2.60
- Java 8+
## Steps
### Clone repository
1. `git clone https://github.com/bryanncxj/BookshopDemo.git` in your folder.
### Windows
`cd <kafka folder>/bin/windows`
#### Start ZooKeeper service
1. `zookeeper-server-start.bat ../../config/zookeeper.properties`
#### Start Kafka broker service
1. `kafka-server-start.bat ../../config/server.properties`
#### Create Book topic
1. `kafka-topics.bat --create --topic bookTopic --bootstrap-server localhost:9092`
#### Read events from topic using consumer
1. `kafka-console-consumer.bat --topic bookTopic --from-beginning --bootstrap-servers localhost:9092`
## Running the application
1. After cloning this repository, run `gradlew clean build`
2. Then `gradlew bootRun`
3. Enter `localhost:8080` to get prompt by Spring Security for credentials. Enter username as `user` and password as `password`.
    * If entering on Postman, go to **Authorization** and change type to **Basic Auth**, then enter credentials.
4. Get all books records by entering `/books`
5. Get an individual valid book record by entering `/books/<isbn>`, Kafka consumer will consume the individual book record that was produced in the Kafka topic.

To access H2 console, use `localhost:8080/h2-console` and connect.

HTTP response can be viewed from Postman or browser console.

Logout using `/logout`.
## Terminate Kafka environment
1. Stop consumer client with `Ctrl-C`
2. Stop Kafka broker with `Ctrl-C`
3. Stop ZooKeeper service with `Ctrl-C`
