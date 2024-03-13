package com.tek.kata.wordwrap;

import static com.tek.utility.Assert.notBlank;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Wrapper {

	public String wrap(String inputString, int columnNumber) {
		notBlank("inputString", inputString);
		if(inputString.length() <= columnNumber) return inputString;
		
		String[] words = inputString.split("\\W+");
		for (String word : words) {
			if(word.length() > columnNumber) throw new IllegalStateException(String.format("word %s plus grand que la longeur de colonne !", word));
		}
		
		//ListIterator<String> listTerator = Arrays.asList(words).listIterator()
		StringBuilder sBuilder = new StringBuilder();
		
		for (String word : words) {
			if(sBuilder.length() + word.length() > columnNumber) {
				// delete last trailing space before line feed
				sBuilder.deleteCharAt(sBuilder.length() -1);
				sBuilder.append('\n');
			}
			// filling words and spaces till column limit
			sBuilder.append(word);
			sBuilder.append(" ");
		}	
		
		return sBuilder.toString().trim();
	}

}
