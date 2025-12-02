#!/bin/bash

# Compile all java files
# We find all .java files and pass them to javac
find . -name "*.java" > sources.txt
javac @sources.txt

# Check if compilation was successful
if [ $? -eq 0 ]; then
    # Run Main
    java Main
fi

# Cleanup .class files and sources.txt
find . -name "*.class" -delete
rm sources.txt
