# Demo project Spring REST and Gradle

### Compiler
``
./gradlew clean build
``

### Run jar
``
java -jar demo-example-1.0.0.jar
``

## Mongo DB and Docker

#### load image
``
docker pull mongo
``
#### view image
``
docker images
``
#### Start
``
docker run --name my_mongo -d -p 127.0.0.1:27017:27017 mongo
``