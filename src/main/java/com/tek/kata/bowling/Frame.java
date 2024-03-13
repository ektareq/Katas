package com.tek.kata.bowling;

import static com.tek.utility.Assert.notBlank;
import static com.tek.utility.Assert.notNull;

import java.util.List;

import org.springframework.util.Assert;

public class Frame implements Comparable<Frame> {
	
	private final Integer turn;

	private final List<BowlingThrow> bThrows;
	
	public Frame(Integer turn, String stringFrame) {
		notBlank("stringFrame", stringFrame);
		notNull("turn", turn);
		
		this.turn = turn;
		
		Assert.isTrue(stringFrame.toCharArray().length <= 2,
				"String frame peux pas être supérieur strictement à 2 caractères");
		BowlingThrow firstThrow = BowlingThrow.fromChar(stringFrame.charAt(0));
		BowlingThrow secondThrow = stringFrame.length() > 1 ? BowlingThrow.fromChar(stringFrame.charAt(1)) : BowlingThrow.MISS;
		
		bThrows = List.of(firstThrow, secondThrow);
	}
	
	public Integer score(List<Frame> frames) {
		if(getFirstThrow().equals(BowlingThrow.STRIKE)) {
			Frame nextFrame = frames.get(turn+1);
			Frame next2Frame = frames.get(turn+2);
			if(nextFrame.getFirstThrow().equals(BowlingThrow.STRIKE)) {
				return 10 + 10 + next2Frame.getFirstThrow().getScore();
			} else if(nextFrame.getSecondThrow().equals(BowlingThrow.SPARE)) {
				return 10 + 10;
			} else {
				return 10 + nextFrame.getFirstThrow().getScore() + nextFrame.getSecondThrow().getScore();
			}
		} else if(getSecondThrow().equals(BowlingThrow.SPARE)) {
			Frame nextFrame = frames.get(turn+1);
			return 10 + nextFrame.getFirstThrow().getScore();
		} else {
			return bThrows.get(0).getScore() + bThrows.get(1).getScore();
		}
	}
	
	private BowlingThrow getFirstThrow() {
		return bThrows.get(0);
	}
	
	private BowlingThrow getSecondThrow() {
		return bThrows.get(1);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.turn.equals(((Frame)obj).getTurn());
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.turn.hashCode();
	}
	
	@Override
	public int compareTo(Frame o) {
		// TODO Auto-generated method stub
		return this.turn.compareTo(o.getTurn());
	}
	
	public Integer getTurn() {
		return turn;
	}
	
}
