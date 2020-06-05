package com.tutorial.javaeight;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StringJoiner {

	public static void main(String[] args) {
long[] prices = {6,0,-1,10};
		//System.out.println(solution(prices));

		List<String>  menuNames = new ArrayList<String>();
		menuNames.add("Cake");
		menuNames.add("IceCream");
		menuNames.add("Burger");
		menuNames.add("Salad");
		menuNames.add("Soup");
		// sorting the list by the length
		menuNames.stream().sorted(comparing(String::length)).forEach(x->System.out.println(x));
		

//ConcurrentHashMap<K, V>;
		ConcurrentHashMap<Integer,String> newMap = 
				new ConcurrentHashMap<Integer,String>();
		newMap.put(1, "tia");
		newMap.put(2, "john");
		newMap.put(3, "aashi");
		newMap.put(4, "aarya");
		newMap.put(5, "elsa");
		newMap.put(6, "lizzie");
		
		
		newMap.forEach(3, (k, v)
				->"length of "+ k+" is "+ v.length() +" by "+Thread.currentThread().getName(),System.out::println); 
		/*
		 * String result =newMap.reduceValues(2, (v1,v2)->{
		 * (v1.length()>v2.length())?v1:v2 });
		 */
	//	System.out.println("Result "+ result);
	}

	public static String solution(String angles) {
		String newAngles = "";
		if (angles.length() > 0 && !angles.startsWith("<")) {
			newAngles = "<".concat(angles);

		} else {
			newAngles = angles;
		}
		if (angles.length() > 0 && !angles.endsWith(">")) {
			newAngles = newAngles.concat(">");
		}
		long openingBraces = newAngles.chars().filter(ch -> ch == '<').count();
		long closingBraces = newAngles.chars().filter(ch -> ch == '>').count();

		if (openingBraces == closingBraces) {
			return newAngles;
		} else if (openingBraces > closingBraces) {
			for (long i = closingBraces; i <= closingBraces; i++) {
				newAngles = newAngles.concat(">");
			}
		} else if (closingBraces < openingBraces) {
			for (long i = openingBraces; i <= closingBraces; i++) {
				newAngles = "<".concat(newAngles);
			}
		}
		
		

		return newAngles;
		// }
	}

	/*
	 * public static long solution(long n) {
	 * 
	 * int[] res = new int[(int) (n + 1)]; res[0] = 1; res[1] = 1; res[2] = 2;
	 * 
	 * for (int i = 3; i <= n; i++) res[i] = res[i - 1] + res[i - 2] + res[i - 3];
	 * 
	 * return Integer.toUnsignedLong(res[(int)n]);
	 * 
	 * for(int i=0;i<=n;i++) {
	 * 
	 * } return 0;
	 * 
	 * }
	 */
	
	
	public static long solution(long[] prices) {
		
		
		OptionalLong maxValue = Arrays.stream(prices,1,prices.length).max();
		List<Long> list = Arrays.stream(prices)		// IntStream
				.boxed()  		// Stream<Integer>
				.collect(Collectors.toList());

		int indexOf = list.lastIndexOf(maxValue.getAsLong());
	OptionalLong minValue = Arrays.stream(prices,0,indexOf).min();
	
Long diff = maxValue.getAsLong()-minValue.getAsLong();
		return diff;
		
	}
}
