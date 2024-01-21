package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import day1.part1.*;
import day1.part2.*;
import day2.part1.*;
import day2.part1.*;

class DayTest {

	Day day;

	@Test
	public void testDay1Part1Example1() {
		day = new Day1Part1();
		Assertions.assertEquals(142, day.solve("example1.txt"));
	}

	@Test
	public void testDay1Part1Input() {
		day = new Day1Part1();
		Assertions.assertEquals(55386, day.solve("input.txt"));
	}

	@Test
	public void testDay1Part2Example1() {
		day = new Day1Part2();
		Assertions.assertEquals(281, day.solve("example1.txt"));
	}

	@Test
	public void testDay1Part2Input() {
		day = new Day1Part2();
		Assertions.assertEquals(54824, day.solve("input.txt"));
	}

	@Test
	public void testDay2Part1Example1() {
		day = new Day2Part1();
		Assertions.assertEquals(8, day.solve("example1.txt"));
	}
}