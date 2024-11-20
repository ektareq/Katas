package com.tek.kata.bankocr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  https://codingdojo.org/kata/BankOCR/
 */
public class BankOcrTest {
	
	@Test
	void should_throw_Exception_if_entry_is_blank() throws Exception {
		assertThrows(IllegalStateException.class, ()-> {
			BankOcr bankOcr = new BankOcr("");
			BankOcr bankOcr2 = new BankOcr(null);
		});
	}
	
	@Test
	void should_throw_Exception_if_not_4_lines() throws Exception {
		assertThrows(IllegalStateException.class, ()-> {
			BankOcr bankOcr = new BankOcr("ddddddddddddddsssssssss");
		});
	}
	
	@Test
	void should_throw_Exception_if_not_27_chars_per_line() throws Exception {
		assertThrows(IllegalStateException.class, ()-> {
			BankOcr bankOcr = new BankOcr("ddddddddddddddsssssssss"
					+ "sdsssssssssssssssssss"
					+ "ddddddddddddddddddddddddd"
					+ "ffffffffff");
		});
	}
	
	@Test
	void nominal_use_case() throws Exception {
		BankOcr bankOcr = new BankOcr(
				  "    _  _     _  _  _  _  _ \n"
				+ "  | _| _||_||_ |_   ||_||_|\n"
				+ "  ||_  _|  | _||_|  ||_| _|\n"
				+ "                           ");
		
		assertEquals("123456789", bankOcr.resolveCode());
		
	}
	
	@Test
	void should_have_valid_number() throws Exception {
		BankOcr bankOcr = new BankOcr(
				  "    _  _     _  _  _  _  _ \n"
				+ "  | _| _||_||_ |_   ||_||_|\n"
				+ "  ||_  _|  | _||_|  ||_| _|\n"
				+ "                           ");
		
		assertTrue(bankOcr.isValid());
	}
}
