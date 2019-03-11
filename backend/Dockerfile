FROM maven:3-jdk-11-slim


COPY src /usr/src/checkup/src
COPY pom.xml /usr/src/checkup

ENV DATABASE_URL=jdbc:postgresql://postgres:5432/checkup_project
ENV SETTINGS_DIR=$(pwd)/target/classes

WORKDIR /usr/src/checkup
RUN mvn clean install -DskipTests

CMD ["mvn", "exec:java"]