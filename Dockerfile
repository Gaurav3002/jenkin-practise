FROM tomcat:8.0-jre8
EXPOSE 8080
COPY  target/book-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/book-0.0.1-SNAPSHOT.jar