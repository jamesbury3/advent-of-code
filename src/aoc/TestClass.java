package aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import day1.*;

class TestClass {

	Day day;

	@Test
	public void testDay1Example1() {
		day = new Day1();
		int val = day.solve("example1.txt");
		Assertions.assertEquals(142, val);
	}

	@Test
	public void testDay1Input() {
		day = new Day1();
		int val = day.solve("input.txt");
		System.out.println("Value: " + val);
		Assertions.assertTrue(true, "Produces output");
	}
}