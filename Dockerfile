FROM tomcat:8.5.73-jdk11-corretto
COPY target/*.war /usr/local/tomcat/webapps/power-plant-api.war
CMD ["catalina.sh","run"]