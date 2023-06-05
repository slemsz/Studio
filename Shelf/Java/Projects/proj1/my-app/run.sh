#!/bin/bash

mvn compile
mvn package
clear
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
mvn clean
