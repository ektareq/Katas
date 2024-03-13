package com.tek.kata.bowling;

import static com.tek.utility.Assert.notBlank;

import java.util.ArrayList;
import java.util.List;

public class Bowling {
	
	private final List<Frame> frames = new ArrayList<Frame>();

	public Bowling(String sequence) {
		notBlank("sequence", sequence);
		String[] stringFrames = sequence.split(" ");
		
		for (int i = 0; i < stringFrames.length; i++) {
			frames.add(new Frame(i, stringFrames[i]));
		}
	}

	public Integer score() {
		return frames.stream().limit(10).map(f -> f.score(frames)).reduce(0, (s1, s2) -> s1 +s2);
	}

}
