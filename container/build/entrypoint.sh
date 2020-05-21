#!/bin/bash

java -jar /application/applications.jar --spring.datasource.url=jdbc:postgresql://$PAO_COMUNICATION_DATABASE_HOST/$PAO_COMUNICATION_DATABASE_NAME --spring.datasource.username=$PAO_COMUNICATION_DATABASE_USER --spring.datasource.password=$PAO_COMUNICATION_DATABASE_PASSWORD --server.port=8082