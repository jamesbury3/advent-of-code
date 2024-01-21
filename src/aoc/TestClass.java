package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import day1.*;

class TestClass {

	Day day;

	@Test
	public void testDay1Part1Example1() {
		day = new Day1Part1();
		int val = day.solve("part1example1.txt");
		Assertions.assertEquals(142, val);
	}

	@Test
	public void testDay1Part1Input() {
		day = new Day1Part1();
		int val = day.solve("part1input.txt");
		System.out.println("Value: " + val);
		Assertions.assertTrue(true, "Produces output");
	}

	@Test
	public void testDay1Part2Example1() {
		day = new Day1Part2();
		int val = day.solve("part2example1.txt");
		Assertions.assertEquals(281, val);
	}

	@Test
	public void testDay1Part2Input() {
		day = new Day1Part2();
		int val = day.solve("part2input.txt");
		System.out.println("Value: " + val);
		Assertions.assertTrue(true, "Produces output");
	}
}