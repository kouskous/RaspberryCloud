FROM armv7/armhf-java8
EXPOSE 8080
ADD ./target/data-storage-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]