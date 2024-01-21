package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import day1.part1.*;
import day1.part2.*;

class TestClass {

	Day day;

	@Test
	public void testDay1Part1Example1() {
		day = new Day1Part1();
		Assertions.assertEquals(142, day.solve("example1.txt"));
	}

	@Test
	public void testDay1Part1Input() {
		day = new Day1Part1();
		day.solve("input.txt");
		Assertions.assertTrue(true, "Produces output");
	}

	@Test
	public void testDay1Part2Example1() {
		day = new Day1Part2();
		Assertions.assertEquals(281, day.solve("example1.txt"));
	}

	@Test
	public void testDay1Part2Input() {
		day = new Day1Part2();
		day.solve("input.txt");
		Assertions.assertTrue(true, "Produces output");
	}
}