package com.tek.kata.bowling;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum BowlingThrow {

	ONE('1', 1),
	FIVE('5', 5),
	NINE('9', 9),
	STRIKE('X', 10),
	SPARE('/', null),
	MISS('-', 0);
	
	private Character c;
	private Integer score;
	
	private BowlingThrow(Character c, Integer score) {
		this.c = c;
		this.score = score;
	}
	
	public Character getC() {
		return c;
	}
	
	public Integer getScore() {
		return score;
	}
	
	private static final Map<Character, BowlingThrow> mapThrows = Arrays.stream(BowlingThrow.values()).collect(Collectors.toMap(b -> b.getC(), b -> b));
	
	public static BowlingThrow fromChar(Character c) {
		return mapThrows.get(c);
	}
}
