package com.tek.kata.tennis;

public class Tennis {
	
	private Score score;
	
	public Tennis() {
		this.score = Score.LOVE_ALL;
	}
	
	public Score score() {
		return this.score;
	}

	public void serverWinPoint() {
		this.score =this.score.serverWin();
	}
	
	public void receverWinPoint() {
		this.score = this.score.receverWin();
	}

}
