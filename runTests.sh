#!/bin/bash

file_name=TestClass.java

echo "Compiling..."
javac -d bin -sourcepath src -cp .:lib/junit-platform-console-standalone-1.9.3.jar src/aoc/$file_name

STATUS="${?}"

if [ $STATUS -eq 1 ]; then
	echo "Compilation Failed"
	exit 1
fi

printf "Running tests...\n\n"

java -jar lib/junit-platform-console-standalone-1.9.3.jar -cp bin/ -c "aoc.${file_name%.*}"

echo "Cleaning up class files..."
rm -rf bin
mkdir bin
touch bin/.keep
echo "Done!"