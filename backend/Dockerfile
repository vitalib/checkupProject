FROM maven:3-jdk-11-slim


COPY src /usr/src/checkup/src
COPY pom.xml /usr/src/checkup

WORKDIR /usr/src/checkup

RUN mvn -PproductionServer clean install -DskipTests

CMD ["mvn", "exec:java"]
