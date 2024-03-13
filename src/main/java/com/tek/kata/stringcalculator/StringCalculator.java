package com.tek.kata.stringcalculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import org.springframework.util.Assert;

public class StringCalculator {

	
	public StringCalculator() {
	}
	
	public String add(String numbersStringValue) {
		//com.tek.utility.Assert.notBlank("numbersStringValue", numbersStringValue);
		Assert.notNull(numbersStringValue, "Arg cannot be null");
		Assert.isTrue(!numbersStringValue.endsWith(","), "Arg shouldn't end with comma");
		Assert.isTrue(numbersStringValue.matches("[0-9,\\.\\n]*"), "");
		Assert.isTrue(!numbersStringValue.matches(",\n") && !numbersStringValue.matches("\n,"), "Arg shouldn't give followed separators");
		
		String[] stringNumberArray = numbersStringValue.split(",|\n");
		//if(stringNumberArray.length > 3) throw new IllegalArgumentException("Arg have more than 3 numbers");
		if(numbersStringValue.equals("")) return "0";
		
		Double r = Arrays.stream(stringNumberArray).map(s -> Double.valueOf(s)).reduce((d1,d2) -> d1 + d2).get();
		
		return r+"";
	}
	
	private static BinaryOperator<Double> add(final Double a, final Double b){
		return (x, y) -> x + y;
	}

}
