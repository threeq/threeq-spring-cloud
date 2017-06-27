FROM java:8-jre-alpine

VOLUME /tmp
ADD ant-network-api-service.jar app.jar
RUN sh -c 'touch /app.jar'

EXPOSE 2000

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]