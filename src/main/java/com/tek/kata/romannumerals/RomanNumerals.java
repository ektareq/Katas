package com.tek.kata.romannumerals;

public class RomanNumerals {
	
	public String toRomanNumber(Integer number) {
		StringBuilder builder = new StringBuilder();

		integerToRomanNumber(number, RomanEnum.M, builder);

		return builder.toString();

	}

	private int integerToRomanNumber(Integer numberToRomanize, RomanEnum rEnum, StringBuilder builder) {
		int mathNumber = rEnum.getNum();
		Character romanNumber = rEnum.getRomanCharNumber();
		
		/*
		 *	Condition if pour Gérer les cas d'inversion des chiffres romains ex : 9 = IX et 4 = IV
		 */
		if(numberToRomanize != 0 && numberToRomanize == rEnum.next().getNum() - 1) {
			builder.append(RomanEnum.I.getRomanCharNumber()).append(rEnum.next().getRomanCharNumber());
			return 0;
		}
		
		// quotient de division
		int qDiv = numberToRomanize / mathNumber;
		
		for (int i = 0; i < qDiv; i++) {
			builder.append(romanNumber);
		}
		
		// condition d'arret de la recursion
		if(rEnum == RomanEnum.I) return 0;
		
		// rest of division
		int rDiv = numberToRomanize % mathNumber;
		
		return integerToRomanNumber(rDiv, rEnum.next(), builder);
	}

}
