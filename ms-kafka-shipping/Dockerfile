FROM openjdk:11.0.2-jre-slim
COPY build/libs/ms-kafka-shipping-0.0.1-SNAPSHOT.jar .
CMD /usr/bin/java -Xmx400m -Xms400m  -XX:TieredStopAtLevel=1 -noverify -jar ms-kafka-shipping-0.0.1-SNAPSHOT.jar -Xdebug -Xrunjdwp:transport=dt_socket,address=8001,server=y,suspend=n
EXPOSE 9501
EXPOSE 8001
