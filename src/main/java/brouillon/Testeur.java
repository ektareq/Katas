package brouillon;

import java.util.EnumSet;
import java.util.Iterator;

import com.tek.kata.romannumerals.RomanEnum;

public class Testeur {

	public static void main(String[] args) {

//		
		Iterator<RomanEnum> it = EnumSet.allOf(RomanEnum.class).iterator();
//		
		while (it.hasNext()) {
			System.out.println(it.next().getNum());
		}
		
		System.out.println(it);
		
	}

	private static void numbering() {
		String[] numbers = new String[5];
		int i = 1;
		int j = 4;
		
		numbers[++i] = "i";
		numbers[--j] = "j";

		System.out.println(numbers);
	}

}
