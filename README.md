# aws-iot-pubsub

mvn clean package

subscribe:
java -jar target/*.jar consume myTopic 

publisher:
java -jar target/*.jar publish  myTopic  trips.txt