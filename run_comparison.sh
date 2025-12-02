#!/bin/bash
find src -name "*.java" > sources.txt
javac -d out @sources.txt
if [ $? -eq 0 ]; then
    java -cp out com.nivaassudhan.aoc25.Main
fi
rm sources.txt
