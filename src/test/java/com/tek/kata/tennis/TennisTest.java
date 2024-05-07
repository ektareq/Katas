package com.tek.kata.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TennisTest {
	
	@Test
	void scoreShouldBeLoveAllAtBeginning() {
		assertEquals(Score.LOVE_ALL,  new Tennis().score());
	}
	
	@Test
	void scoreShouldBeFifteenLoveWhenServerWinFirstPoint() {
		Tennis tennis = new Tennis();
		tennis.serverWinPoint();
		assertEquals(Score.FIFTEEN_LOVE,  tennis.score());
	}
	
	@Test
	void scoreShouldBeLoveAllFifteenWhenReceverWinFirstPoint() {
		Tennis tennis = new Tennis();
		tennis.receverWinPoint();
		assertEquals(Score.LOVE_FIFTEEN,  tennis.score());
	}
	
	@Test
	void scoreShouldBeFifteenAllWhenServerAndReceverWinPointOneTimeEach() {
		Tennis tennis = new Tennis();
		tennis.receverWinPoint();
		tennis.serverWinPoint();
		assertEquals(Score.FIFTEEN_ALL,  tennis.score());
	}
	
	@Test
	void scoreShouldBeThirtyLove() {
		Tennis tennis = new Tennis();
		tennis.serverWinPoint();
		tennis.serverWinPoint();
		assertEquals(Score.THIRTY_LOVE,  tennis.score());
	}
	@Test
	void scoreShouldBeFortyLove() {
		Tennis tennis = new Tennis();
		tennis.serverWinPoint();
		tennis.serverWinPoint();
		tennis.serverWinPoint();
		assertEquals(Score.FORTY_LOVE,  tennis.score());
	}
	
	@Test
	void scoreShouldBeLoveThirty() {
		Tennis tennis = new Tennis();
		tennis.receverWinPoint();
		tennis.receverWinPoint();
		assertEquals(Score.LOVE_THIRTY,  tennis.score());
	}
	
	@Test
	void scoreShouldBeLoveForty() {
		Tennis tennis = new Tennis();
		tennis.receverWinPoint();
		tennis.receverWinPoint();
		tennis.receverWinPoint();
		assertEquals(Score.LOVE_FORTY,  tennis.score());
	}
	
	@Test
	void scoreShouldBeDeuce() {
		Tennis tennis = deuce();
		assertEquals(Score.DEUCE,  tennis.score());
	}
	
	@Test
	void scoreShouldBeAdvantageServer() {
		Tennis tennis = deuce();
		tennis.serverWinPoint();
		assertEquals(Score.ADVANTAGE_SERVER,  tennis.score());
	}
	
	@Test
	void scoreShouldBeAdvantageRecever() {
		Tennis tennis = deuce();
		tennis.receverWinPoint();
		assertEquals(Score.ADVANTAGE_RECEIVER,  tennis.score());
	}
	
	@Test
	void scoreShouldBeDeuceAfterAdvantageServer() {
		Tennis tennis = deuce();
		tennis.serverWinPoint();
		tennis.receverWinPoint();
		assertEquals(Score.DEUCE,  tennis.score());
	}
	
	@Test
	void scoreShouldBeDeuceAfterAdvantageRecever() {
		Tennis tennis = deuce();
		tennis.receverWinPoint();
		tennis.serverWinPoint();
		assertEquals(Score.DEUCE,  tennis.score());
	}
	
	@Test
	void scoreShouldBeVictoryForServer() {
		Tennis tennis = deuce();
		tennis.serverWinPoint();
		tennis.serverWinPoint();
		assertEquals(Score.GAME_FOR_SERVER,  tennis.score());
	}
	
	@Test
	void scoreShouldBeVictoryForRecever() {
		Tennis tennis = deuce();
		tennis.receverWinPoint();
		tennis.receverWinPoint();
		assertEquals(Score.GAME_FOR_RECEVER,  tennis.score());
	}
	
	

	private Tennis deuce() {
		Tennis tennis = new Tennis();
		tennis.serverWinPoint();
		tennis.serverWinPoint();
		tennis.serverWinPoint();
		tennis.receverWinPoint();
		tennis.receverWinPoint();
		tennis.receverWinPoint();
		return tennis;
	}
	
	
	
	
	

}
