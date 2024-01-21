package day1.part2;

import aoc.Day;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;

public class Day1Part2 extends Day {

	Map<String, Integer> numbers = Map.of(
		"one", 1,
		"two", 2,
		"three", 3,
		"four", 4,
		"five", 5,
		"six", 6,
		"seven", 7,
		"eight", 8,
		"nine", 9
	);
	Set<Character> startingLetters;

	public Day1Part2() {
		super();
		startingLetters = numbers.keySet().stream()
			.map(s -> s.charAt(0))
			.collect(Collectors.toSet());
	}

	public int solve(String filename) {

		List<String> lines = readFile(filename);
		if (lines == null) {
			return -1;
		}

		AtomicInteger runningSum = new AtomicInteger();

		lines.forEach(line -> {
			int left = -1;
			int right = -1;
			
			for (int i = 0; i < line.length(); i++) {
				
				char c = line.charAt(i);
				int newNumber = -1;

				if (Character.isDigit(c)) {
					newNumber = Character.getNumericValue(c);
				
				} else {
					if (startingLetters.contains(c) && i < line.length() - 2) {
						List<String> potentialNumbers = numbers.keySet().stream()
							.filter(number -> number.charAt(0) == c)
							.collect(Collectors.toList());

						info("Potential numbers: " + potentialNumbers.toString());

						int foundNumber = -1;

						// Iterate 5 (max number length) starting from the next character
						List<String> numbersToRemove = new ArrayList<>();
						for (int j = 1; j < 5; j++) {
							info("Getting char at index: " + (i+j));
							char nextChar = line.charAt(i+j);
							for (String number : potentialNumbers) {
								if (number.charAt(j) != nextChar) {
									numbersToRemove.add(number);
								} else {
									if (number.length() - 1 == j) {
										foundNumber = numbers.get(number);
										i += j - 1;
										info("Found number: " + foundNumber + ", i is now " + i + " for line: " + line);
									} 
								}
							}

							for (String number : numbersToRemove) {
								potentialNumbers.remove(number);
							}

							if (foundNumber != -1 || potentialNumbers.size() == 0 || i + j + 1 == line.length()) {
								break;
							}
						}

						newNumber = foundNumber;
					}
				}

				if (newNumber != -1) {
					if (left == -1) {
						left = newNumber;
					} else {
						right = newNumber;
					}
				}
			}

			if (right == -1) {
				right = left;
			}

			int sum = (10 * left) + right;
			info(String.format("-------- Line: %s, left: %d, right: %d, sum: %d", line, left, right, sum));
			if (left > 9 || right > 9 || left == -1 || right == -1)
				throw new IllegalStateException("Left or right cannot be -1 or greater than 9");
			runningSum.getAndAdd(sum);
		});

		logFinalValue(runningSum.get());
		return runningSum.get();
	}
}