#!/bin/bash

# Pull new changes
git pull

# Prepare Jar
mvn clean
mvn package

# Ensure, that docker-compose stopped
docker-compose stop

# Start new deployment
docker-compose up --build -d

cd /target

java -jar Graduation-release.jar