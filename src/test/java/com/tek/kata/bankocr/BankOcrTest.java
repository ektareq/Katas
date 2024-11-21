package com.tek.kata.bankocr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 *  https://codingdojo.org/kata/BankOCR/
 */
public class BankOcrTest {
	
	@Test
	void should_throw_Exception_if_entry_is_blank() throws Exception {
		assertThrows(IllegalStateException.class, ()-> {
			BankOcr bankOcr = new BankOcr("");
			BankOcr bankOcr2 = new BankOcr((String)null);
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
	
	@Test
	void should_have_not_valid_number() throws Exception {
		BankOcr bankOcr = new BankOcr(
				  "       _     _  _  _  _  _ \n"
				+ "  |  | _||_||_ |_   ||_||_|\n"
				+ "  |  | _|  | _||_|  ||_| _|\n"
				+ "                           ");
		
		assertFalse(bankOcr.isValid());
	}
	
	@Test
	void should_read_input_ocr_file_and_extract_account_numbers_into_output_file_with_valid_numner() throws Exception {
        assertFileContentsEqual("raw_valid_numbers.txt", "expected_valid_numbers.txt");
	}
	
	@Test
	void should_read_input_ocr_file_and_extract_account_numbers_into_output_file_with_not_valid_numner() throws Exception {
        assertFileContentsEqual("raw_not_valid_numbers.txt", "expected_not_valid_numbers.txt");
	}
	
    // Helper method for reading files and comparing byte arrays
    private void assertFileContentsEqual(String inputFile, String expectedFile) throws Exception {
        InputStream rawIs = getClass().getClassLoader().getResourceAsStream(inputFile);
        BankOcr bo = new BankOcr(rawIs);

        InputStream expectedIs = getClass().getClassLoader().getResourceAsStream(expectedFile);
        Path resultFile = bo.extractAccountNumbers();

        byte[] expected = expectedIs.readAllBytes();
        byte[] result = Files.readAllBytes(resultFile);

        assertTrue(Arrays.equals(expected, result), "The extracted account numbers do not match the expected result.");
    }
}
