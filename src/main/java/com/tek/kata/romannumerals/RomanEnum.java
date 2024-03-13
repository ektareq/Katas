package com.tek.kata.romannumerals;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum RomanEnum {
	M(1000, 'M'),
	D(500, 'D'),
	C(100, 'C'),
	L(50, 'L'),
	X(10, 'X'), 
	V(5, 'V'), 
	I(1, 'I');
	
	RomanEnum(Integer num, Character romanCharNumber){
		this.num = num;
		this.romanCharNumber = romanCharNumber;
	}
	
	private Integer num;
	private Character romanCharNumber;
	
	public static final Map<Integer,RomanEnum> mapValues = Arrays.stream(RomanEnum.values()).collect(Collectors.toMap(RomanEnum::getNum, rm -> rm));
	
	public Character getRomanCharNumber() {
		return romanCharNumber;
	}
	
	public Integer getNum() {
		return num;
	}
	
    public RomanEnum next() {
    	if(this.equals(I)) return I;
        return RomanEnum.values()[this.ordinal() + 1];
    }
}
