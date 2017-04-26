FROM java:8-jre-alpine

VOLUME /tmp
ADD ant-network-rest.jar app.jar
RUN sh -c 'touch /app.jar'

EXPOSE 2002

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]