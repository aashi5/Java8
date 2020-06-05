package com.tutorial.javaeight;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsSample {

	
	public static void main(String[] args) {
		List<String> names =Arrays.asList("Aashi", "Aarya", "Grace", "Aashi", "Aarya");
		
		Map<String, Long> namesCountMap = names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(namesCountMap);
		
		List<Long> numbers = Arrays.asList(10L,300L,400L);
		LongSummaryStatistics sum=numbers.parallelStream().collect(Collectors.summarizingLong(s->s+20));
		System.out.println(sum);
		
		
		int[] numsArr = {10,90,80};
		Arrays.parallelSort(numsArr);
		Arrays.stream(numsArr).forEach(s->System.out.println(s));
		
	}
}
