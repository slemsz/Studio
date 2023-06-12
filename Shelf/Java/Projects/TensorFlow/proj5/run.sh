#!/bin/bash

tree
cd ./App/
mvn clean install
clear
mvn compile
clear
mvn package
clear
java -cp target/App-vrsn-0.0.jar com.mycompany.app.App
cd ./../
