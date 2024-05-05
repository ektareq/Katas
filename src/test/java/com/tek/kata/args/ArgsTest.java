package com.tek.kata.args;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ArgsTest {

	@Test
	void Should_return_right_typped_value_from_raw_arg_value() throws Exception {
		// return Integer
		assertEquals(8080, extracted("-p 8080").getValueOf("p"));

		// know boolean key
		assertEquals(true, extracted("-l").getValueOf("l"));

		// return string
		assertEquals("tata", extracted("-l -p 8080 -g tata").getValueOf("g"));

		// unknow key return false
		assertEquals(false, extracted("-l -p 8080 -g tata").getValueOf("m"));

		assertThrows(IllegalStateException.class, () -> {
			extracted("-g tata secondShitArgs").getValueOf("g");
		});

		assertThrows(IllegalStateException.class, () -> {
			extracted("-lkeyDouble").getValueOf("a");
		});
	}

	private ArgsParser extracted(String rawArgs) throws JsonMappingException, JsonProcessingException {
		return new ArgsParser(rawArgs,
				Map.of(
						"l", new ArgsModel<Boolean>("l", Boolean.class, false, null), 
						"p", new ArgsModel<Integer>("p", Integer.class, 8888, null), 
						"g", new ArgsModel<String>( "g", String.class, "empty", null))
				);
	}

}
