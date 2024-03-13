package com.tek.kata.bowling;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.*;
import static org.junit.jupiter.api.DynamicTest.*;

import java.util.List;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class BowlingTest {

	
	/*
	 * 	X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300
		9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
		5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150
	 */
	@Test
	void test_proposed() {
		assertEquals(0, new Bowling("-- -- -- -- -- -- -- -- -- --").score());
		assertEquals(20, new Bowling("11 11 11 11 11 11 11 11 11 11").score());
		assertEquals(29, new Bowling("1/ 11 11 11 11 11 11 11 11 11").score());
		assertEquals(30, new Bowling("X 11 11 11 11 11 11 11 11 11").score());
		// 20 + 11 + 16 
		assertEquals(47, new Bowling("X 1/ 11 11 11 11 11 11 11 11").score());
		assertEquals(90, new Bowling("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-").score());
		assertEquals(300, new Bowling("X X X X X X X X X X X X").score());
		assertEquals(150, new Bowling("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5").score());
	}
}
