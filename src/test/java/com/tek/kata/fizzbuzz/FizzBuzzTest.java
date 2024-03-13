package com.tek.kata.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

	@Test
	public void test_all_fizzBuzz_cases() {
		assertEquals("1", new Word(1).fizzBuzz());
		assertEquals("Fizz", new Word(3).fizzBuzz());
		assertEquals("Buzz", new Word(5).fizzBuzz());
		assertEquals("FizzBuzz", new Word(15).fizzBuzz());
	}
}
