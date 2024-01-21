#!/bin/bash

day_number=$1

# Create new folders
mkdir src/day$day_number
mkdir src/day$day_number/part1
mkdir src/day$day_number/part2

# Initialize part 1 and part 2 classes
printf "package day${day_number}.part1;\n\nimport aoc.Day;\n\npublic class Day${day_number}Part1 extends Day {\n\n\tpublic int solve(String filename) {\n\t\treturn -1;\n\t}\n}" > src/day${day_number}/part1/Day${day_number}Part1.java
printf "package day${day_number}.part2;\n\nimport aoc.Day;\n\npublic class Day${day_number}Part2 extends Day {\n\n\tpublic int solve(String filename) {\n\t\treturn -1;\n\t}\n}" > src/day${day_number}/part2/Day${day_number}Part2.java

# Create input text files
touch src/day$day_number/part1/example1.txt
touch src/day$day_number/part1/input.txt
touch src/day$day_number/part2/example1.txt
touch src/day$day_number/part2/input.txt