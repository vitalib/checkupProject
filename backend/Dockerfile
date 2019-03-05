FROM maven:3-jdk-11-slim


COPY src /usr/src/checkup/src
COPY pom.xml /usr/src/checkup

WORKDIR /usr/src/checkup
RUN mvn clean install
 
CMD ["mvn", "exec:java"]