FROM ukathinokkula/tomcat

### Open Ports
EXPOSE 8080
ADD ./target/LEM-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]