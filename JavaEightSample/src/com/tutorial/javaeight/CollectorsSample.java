package com.tutorial.javaeight;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

public class CollectorsSample {

	
	public static void main(String[] args) {
		/*
		 * List<String> names =Arrays.asList("Aashi", "Aarya", "Grace", "Aashi",
		 * "Aarya");
		 * 
		 * Map<String, Long> namesCountMap =
		 * names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.
		 * counting())); System.out.println(namesCountMap);
		 * 
		 * List<Long> numbers = Arrays.asList(10L,300L,400L); LongSummaryStatistics
		 * sum=numbers.parallelStream().collect(Collectors.summarizingLong(s->s+20));
		 * System.out.println(sum);
		 * 
		 * 
		 * int[] numsArr = {10,90,80}; Arrays.parallelSort(numsArr);
		 * Arrays.stream(numsArr).forEach(s->System.out.println(s));
		 */
		
		ConcurrentHashMap<Integer, String> concMap = new ConcurrentHashMap<Integer, String>();
		
		System.out.println("Conc Map size " +concMap.size());
		concMap.put(1, "Aashi");
		
		
	}
}
