package com.tek.kata.romannumerals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RomanNumeralsTest {
	
	@Test
	void with_1_return_I() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("I", rn.toRomanNumber(1));
	}
	
	@Test
	void with_2_return_II() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("II", rn.toRomanNumber(2));
	}
	
	@Test
	void with_3_return_III() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("III", rn.toRomanNumber(3));
	}
	
	@Test
	void with_5_return_V() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("V", rn.toRomanNumber(5));
	}
	
	@Test
	void with_6_return_VI() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("VI", rn.toRomanNumber(6));
	}
	
//	@Test
//	void with_4_return_IV() throws Exception {
//		RomanNumerals rn = new RomanNumerals();
//		assertEquals("IV", rn.toRomanNumber(4));
//	}
	
	@Test
	void with_10_return_X() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("X", rn.toRomanNumber(10));
	}
	
	@Test
	void with_13_return_XIII() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("XIII", rn.toRomanNumber(13));
	}
	
	@Test
	void with_7_return_VII() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("VII", rn.toRomanNumber(7));
	}
	
	@Test
	void with_16_return_XVI() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("XVI", rn.toRomanNumber(16));
	}
	
	@Test
	void with_23_return_XXIII() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("XXIII", rn.toRomanNumber(23));
	}
	
	@Test
	void with_51_return_LI() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("LI", rn.toRomanNumber(51));
	}
	
	@Test
	void with_666_return_DCLXVI() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("DCLXVI", rn.toRomanNumber(666));
	}
	
	@Test
	void with_509_return_DIX() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("DCLXVI", rn.toRomanNumber(666));
	}
	
	@Test
	void with_4888_return_MMMMDCCCLXXXVIII() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("DCLXVI", rn.toRomanNumber(666));
	}
	
	@Test
	void with_4_return_IV() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("IV", rn.toRomanNumber(4));
	}
	
	@Test
	void with_9_return_IX() throws Exception {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("IX", rn.toRomanNumber(9));
	}
	
}
