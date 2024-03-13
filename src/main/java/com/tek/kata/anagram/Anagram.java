package com.tek.kata.anagram;

import static com.tek.utility.Assert.notBlank;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.ArrayUtils;

public class Anagram {
	
	private final String principal;
	private final char[] principalCharArray;
	
	// resource line iterator
	private static LineIterator lnIt;

	static {
		try {
			lnIt = FileUtils.lineIterator(new File(Anagram.class.getClassLoader().getResource("anagram-words.txt").getFile()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Anagram(String principal) {
		this.principal = principal;
		this.principalCharArray = principal.toCharArray();
		Arrays.sort(principalCharArray);
	}
	
	public List<String> findWords() {
		
		List<String> result = new ArrayList<String>();
		
		List<String> words = resourceToWords();
		for (String word1 : words) {
			for (String word2 : words) {
				if(word1.compareTo(word2) > 0) {
					if(isDocumenting(word1, word2)) {
						result.add(word1);
						result.add(word2);
						System.out.println(String.format("Les mots %s et %s sont des anagrammes du mot %s", word1, word2, principal));
					}
				}
			}
		}
		
		return result;
	}
	
	private List<String> resourceToWords() {
		List<String> words = new ArrayList<String>();
		while (lnIt.hasNext()) {
			words.addAll(Arrays.asList(lnIt.next().split("\s+")));
		}
		return words;
	}
	
	/**
	 * check if word1 and word2 are anagram of principal word
	 * @param word1
	 * @param word2
	 * @return
	 */
	public boolean isDocumenting(String word1, String word2) {
		notBlank("word1", word1);
		notBlank("word2", word2);
		
		char[] inputChars = ArrayUtils.addAll(word1.toCharArray(), word2.toCharArray());
		Arrays.sort(inputChars);
		
		return Arrays.equals(principalCharArray, inputChars);
	}

}
