package com.tek.kata.leapyears;

public class LeapYear {

	public final int year;
	
	public LeapYear(int year) {
		this.year = year;
	}
	
	public boolean isLeap() {
		return this.year % 4 == 0;
	}
}
