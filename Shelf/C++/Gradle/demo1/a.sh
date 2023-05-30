#!/bin/bash

# Execute gradle build command
./gradlew build --scan
./app/build/exe/main/debug/app
