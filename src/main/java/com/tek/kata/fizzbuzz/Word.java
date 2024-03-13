package com.tek.kata.fizzbuzz;

public class Word {

	private final Integer i;
	
	public Word(int i){
		this.i = i;
	}
	
	public String fizzBuzz() {
		if(i % 3 != 0 && i % 5 != 0) return String.valueOf(this.i);
		
		StringBuilder builder = new StringBuilder();
		if(i % 3 == 0) builder.append("Fizz");
		if(i % 5 == 0) builder.append("Buzz");
		
		return builder.toString();
	}
}
