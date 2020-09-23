# Bookshop Demo
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
1. `kafka-console-consumer.bat --topic bookTopic --from-beginning --bootstrap-servers localhost:9092`
### Terminate Kafka environment
1. Stop consumer client with `Ctrl-C`
2. Stop Kafka broker with `Ctrl-C`
3. Stop ZooKeeper service with `Ctrl-C`
