FROM maven:3-jdk-11-slim

COPY src /usr/src/checkup/src
COPY pom.xml /usr/src/checkup
COPY target /usr/src/checkup/target

WORKDIR /usr/src/checkup

CMD ["mvn", "exec:java"]
