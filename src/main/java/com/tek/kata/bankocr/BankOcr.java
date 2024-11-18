package com.tek.kata.bankocr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * https://codingdojo.org/kata/BankOCR/
 * 
 * Global purpose
 * 
 * From an ASCII entry of 4 lines and 27 chars per each line like :
 * 
 *	              "    _  _     _  _  _  _  _ \n"
				+ "  | _| _||_||_ |_   ||_||_|\n"
				+ "  ||_  _|  | _||_|  ||_| _|\n"
				+ "                           
 *
 *	it should returns 123456789
 *
 * @author TEK
 */
public class BankOcr {

	private static final int LINE_LENGH = 27;
	private static final int LINE_NUMBER = 4;
	
	List<CodePoint> codePoints = List.of(
			new CodePoint(0,1,2),
			new CodePoint(3,4,5),
			new CodePoint(6,7,8),
			new CodePoint(9,10,11),
			new CodePoint(12,13,14),
			new CodePoint(15,16,17),
			new CodePoint(18,19,20),
			new CodePoint(21,22,23),
			new CodePoint(24,25,26)
			);

	public BankOcr(String rawCode) {
		if(rawCode == null || rawCode.isEmpty()) 
			throw new IllegalStateException("code cannot be blank");
		String[] lines = rawCode.split("\n");
		if(lines.length != LINE_NUMBER)
			throw new IllegalStateException(String.format("Number of line should be exactly 4 but it is %s", lines.length));
		int i = 0;
		for (String line : lines) {
			if(line.length() != LINE_LENGH) {
				throw new IllegalStateException(String.format("Each line should have exactly 27 chars but the line number %s have %s chars", i, line.length()));
			}
			i++;
		}
		
		String[] linesWithoutLast = Arrays.copyOf(lines, lines.length - 1);
		
		for (String line : linesWithoutLast) {
			fillCodePoints(line);
		}
	}
	
	// iterate over line and fill codePoints with chars according to their inner indexes
	// ex : the first codePoint accept the 3 first chars of each line, the second codePoint the 4, 5 and 6 chars ... and so on
	private void fillCodePoints(String line) {
		for (CodePoint cp : this.codePoints) {
			for (int i = 0; i < LINE_LENGH; i++) {
				char c = line.charAt(i);
				if(cp.belongsTo(i)) {
					cp.addChar(c);
				}
			}
		}
	}

	// resolve global rawCode
	public String resolveCode() {
		StringBuilder sb = new StringBuilder();
		for (CodePoint codePoint : codePoints) {
			sb.append(fromCodePoint(codePoint));
		}
		
		return sb.toString();
	}
	
	// return 
	private String fromCodePoint(CodePoint cp) {
		
		Set<StaticCodepoint> staticCodePoints = EnumSet.allOf(StaticCodepoint.class);
		
		for (StaticCodepoint scp : staticCodePoints) {
			if(Arrays.equals(cp.getChars(), scp.getChars())) {
				return scp.getResult();
			}
		}
		
		throw new IllegalStateException("Code unknown !");
	}

	// representation of an ASCII NUMBER from raw ASCII code, using indexes ... ex : the first ASCII number have index 0, 1, 2
	private static class CodePoint {
		
		private final int index1;
		private final int index2;
		private final int index3;
		
		private List<Character> listChars = new ArrayList<>();
		
		private void addChar(char c) {
			listChars.add(c);
		}
		
		// 3 index to identifiy the codePoint
		public CodePoint(int i, int j, int k) {
			this.index1 = i;
			this.index2 = j;
			this.index3 = k;
		}
		
		// return true if indexZ is from this codePoint
		boolean belongsTo(int indexZ) {
			return indexZ == index1 || indexZ == index2 || indexZ == index3;
		}
		
		public char[] getChars() {
			char[] charss = new char[9];
			for (int i = 0; i < charss.length; i++) {
				charss[i] = this.listChars.get(i);
			}
			return charss;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("%s %s %s", index1, index2, index3);
		}
		
	}
	
	// enum to list char arrays or each ASCII number
	private static enum StaticCodepoint{
		
		NUMBER_1(new char[]{' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', '|'}, "1"),
		NUMBER_2(new char[]{' ', '_', ' ', ' ', '_', '|', '|', '_', ' '}, "2"),
		NUMBER_3(new char[]{' ', '_', ' ', ' ', '_', '|', ' ', '_', '|'}, "3"),
		NUMBER_4(new char[]{' ', ' ', ' ', '|', '_', '|', ' ', ' ', '|'}, "4"),
		NUMBER_5(new char[]{' ', '_', ' ', '|', '_', ' ', ' ', '_', '|'}, "5"),
		NUMBER_6(new char[]{' ', '_', ' ', '|', '_', ' ', '|', '_', '|'}, "6"),
		NUMBER_7(new char[]{' ', '_', ' ', ' ', ' ', '|', ' ', ' ', '|'}, "7"),
		NUMBER_8(new char[]{' ', '_', ' ', '|', '_', '|', '|', '_', '|'}, "8"),
		NUMBER_9(new char[]{' ', '_', ' ', '|', '_', '|', ' ', '_', '|'}, "9");
		
		StaticCodepoint(char[] chars, String result){
			this.chars = chars;
			this.result = result;
		}
		
		private char[] chars;
		private String result;
		
		public char[] getChars() {
			return this.chars;
		}
		
		public String getResult() {
			return this.result;
		}
	}

}
