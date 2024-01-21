package day1;

import aoc.Day;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day1 extends Day {

	public int solve(String filename) {

		List<String> lines = readFile("day1/" + filename);
		if (lines == null) {
			return -1;
		}

		AtomicInteger runningSum = new AtomicInteger();

		lines.forEach(line -> {
			info(line);
			int left = -1;
			int leftReserve = -1;
			int right = -1;
			int rightReserve = -1;
			
			for (int i = 0; i < (line.length() / 2) + 1; i++) {
				int j = line.length() - (i+1);

				char cb = line.charAt(i);
				char ce = line.charAt(j);
				
				if (Character.isDigit(cb)) {
					if (left == -1) {
						left = Character.getNumericValue(cb);
					} else {
						leftReserve = Character.getNumericValue(cb);
					}
				}

				if (Character.isDigit(ce)) {
					if (right == -1) {
						right = Character.getNumericValue(ce);
					} else {
						rightReserve = Character.getNumericValue(ce);
					}
				}
			}

			if (right == -1) {
				right = leftReserve != -1 ? leftReserve : left;
			}
			if (left == -1) {
				left = rightReserve != -1 ? rightReserve : right;
			}

			int sum = (10 * left) + right;
			info(String.format("left: %d, right: %d, sum: %d", left, right, sum));
			if (left > 9 || right > 9 || left == -1 || right == -1)
				throw new IllegalStateException("Left or right cannot be -1 or greater than 9");
			runningSum.getAndAdd(sum);
		});

		return runningSum.get();
	}


}