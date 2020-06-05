package com.tutorial.javaeight.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharactersStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countWords("THis is the word count test");
	}

	public static void countWords(String words) {
		boolean lastSpace = true;
		int counter = 0;
		for (Character c : words.toCharArray()) {
			if (Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if (lastSpace)
					counter++;
				lastSpace = false;
			}
		}
		System.out.println(counter);
	}

	public static void streamCountWords(String str) {
		Stream<Character> charStream = IntStream.range(0, str.length())
									.mapToObj(str::charAt);
		
		
		
	}
}
