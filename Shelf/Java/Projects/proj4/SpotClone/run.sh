#!/bin/bash

mvn clean install
mvn compile
mvn package
clear
#mvn exec:exec
java -cp target/classes com.mycompany.app.App
