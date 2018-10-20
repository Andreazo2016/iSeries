FROM openjdk:8
VOLUME /tmp
ADD target/iSeries-0.0.1-SNAPSHOT.jar iSeries-0.0.1-SNAPSHOT.jar
EXPOSE 8080 3036
ENTRYPOINT ["java", "-jar", "iSeries-0.0.1-SNAPSHOT.jar" ]