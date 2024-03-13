package com.tek.kata.wordwrap;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WrapperTest {

	@Test
	void inputLenghtLessThanColumnNumberReturnIndentity() {
		Assertions.assertEquals("abc", new Wrapper().wrap("abc", 6));
	}
	
	@Test
	void anyWordGreaterThanColumnNumberThrowException() throws Exception {
        assertThrows(Exception.class, () -> {
        	new Wrapper().wrap("tr trajet", 4);
        });
	}
	
	@Test
	void nominalTestCase() throws Exception {
		Assertions.assertEquals("projet trajet\nmadaf", new Wrapper().wrap("projet trajet madaf", 14));
	}
	
    @Test
    public void wrapJustBeforeWordBoundary() throws Exception {
    	Assertions.assertEquals("word\nword", new Wrapper().wrap("word word", 4));
    }
    
    @Test
    public void wrapJustBeforeWordBoundary2() throws Exception {
    	Assertions.assertEquals("word\nword", new Wrapper().wrap("word word", 5));
    }

}
