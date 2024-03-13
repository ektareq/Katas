package com.tek.kata.stringcalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	private static final String NUMBERS_WITH_UNIQUE_SEPARATOR = "1.0,2.2";
	private static final String NUMBERS_WITH_2_SEPARATORS = "1.0,2.2\n2";
	private static final String NUMBERS_FINISH_WITH_COMMA_THROW_EXCEPTION = "1.0,2.2,";

	@Test
	void emptyStringReturnString0() {
		//assertInstanceOf(String.class, new StringCalculator().add(""));
		assertEquals("0", new StringCalculator().add(""));
	}
	
	@Test
	void numbersWithUniqueSeparator(){
		assertEquals("3.2", new StringCalculator().add(NUMBERS_WITH_UNIQUE_SEPARATOR));
	}
	
	@Test
	void numbersWithMultipleSeparators() {
		assertEquals("5.2", new StringCalculator().add(NUMBERS_WITH_2_SEPARATORS));
	}
	
	@Test
	void InputEndWithCommaThrowException() {
        assertThrows(Exception.class, () -> {
        	new StringCalculator().add(NUMBERS_FINISH_WITH_COMMA_THROW_EXCEPTION);
        });
	}
	
	@Test
	void inputWithFollowedSeparatorsThrowException() {
        assertThrows(Exception.class, () -> {
        	new StringCalculator().add("1.2,\n3");
        	new StringCalculator().add("1.2\n,3");
        });
	}

}
