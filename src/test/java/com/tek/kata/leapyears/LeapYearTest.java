package com.tek.kata.leapyears;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LeapYearTest {

	@Test
	void test() {
		assertEquals(true, new LeapYear(2004).isLeap());
		assertEquals(false, new LeapYear(2003).isLeap());
	}

}
