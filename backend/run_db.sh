#!/bin/bash
export DATABASE_URL=jdbc:postgresql://localhost:5432/checkup_project
export SETTINGS_DIR=$(pwd)/target/classes
export DB_SCRIPT_DIR=$(pwd)/src/main/resources/db

curdir=$(pwd)

if [ -d $DB_SCRIPT_DIR ]; then
    cd $DB_SCRIPT_DIR
    echo "from postgres:10.5
    ENV POSTGRES_USER postgres
    ENV POSTGRES_PASSWORD postgres
    ENV POSTGRES_DB checkup_project
    ADD . /docker-entrypoint-initdb.d/" >> Dockerfile
    docker build -t my-postgres .
    docker stop postres-checkup
    docker container rm postres-checkup
    docker run -d --rm --name postres-checkup -p 5432:5432 my-postgres
    rm Dockerfile
    cd $curdir
else
    echo Database source dir $DB_SCRIPT_DIR doesn\'t exists
fi
mvn clean install -DskipTests && mvn exec:java
