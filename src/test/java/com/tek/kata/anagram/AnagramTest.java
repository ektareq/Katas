package com.tek.kata.anagram;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnagramTest {
	
	private Anagram an;
	
	@BeforeEach
	void setUp() {
		an = new Anagram("documenting");
	}
	
	@Test()
	void ifFirstWordOrSecondWordIsNull_ThrowException() throws Exception {
		assertThrows(Exception.class, ()-> {
			an.isDocumenting(null, "");
		});
		
		assertThrows(Exception.class, ()-> {
			an.isDocumenting("", null);
		});
	}
	
	@Test()
	void ifFirstWordOrSecondWordIsEmpty_ThrowException() throws Exception {
		assertThrows(Exception.class, ()-> {
			an.isDocumenting("word1", "");
		});
		
		assertThrows(Exception.class, ()-> {
			an.isDocumenting("", "word2");
		});
	}
	
	@Test
	void ifWord1AndWord2NotEmpty_dontThrowAnyException() throws Exception {
		assertDoesNotThrow(() -> an.isDocumenting("word1", "word2"));
	}
	
	@Test
	void if_not_anagram_return_false() throws Exception {
		assertFalse(an.isDocumenting("word1", "word2"));
	}
	
	@Test
	void with_documentin_and_g_return_true() throws Exception {
		assertTrue(an.isDocumenting("documentin", "g"));
	}
	
	@Test
	void with_g_and_documenting_return_true() throws Exception {
		assertTrue(an.isDocumenting("g", "documentin"));
	}
	
	@Test
	void with_ument_and_docing_return_true() throws Exception {
		assertTrue(an.isDocumenting("ument", "docing"));
	}
	
	@Test
	void with_umentt_and_docing_return_true() throws Exception {
		assertFalse(an.isDocumenting("umentt", "docing"));
	}
	
	@Test
	LineIterator test_read_file_in_classpath() throws Exception {
		return FileUtils.lineIterator(new File(getClass().getClassLoader().getResource("anagram-words.txt").getFile()));
	}
	
	@Test
	void test_split_words_from_classpath_resource() throws Exception {
		LineIterator lnIt = test_read_file_in_classpath();
		String[] firstWordLine = null;
		while (lnIt.hasNext()) {
			 firstWordLine = lnIt.next().split("\s+");
			break;
		}
		
		assertEquals("acrobat", firstWordLine[0]);
		assertEquals("africa", firstWordLine[1]);
		assertEquals("alaska", firstWordLine[2]);
	}
}
