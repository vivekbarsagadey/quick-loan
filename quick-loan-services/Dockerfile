FROM java:8
VOLUME /tmp
ARG JAR_FILE
EXPOSE 8080
ADD /target/quick-loan-services.jar quick-loan-services.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/quick-loan-services.jar"]