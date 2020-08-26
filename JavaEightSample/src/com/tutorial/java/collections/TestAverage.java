package com.tutorial.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class TestAverage {
public static void main(String...args) {
	
	List<Integer> num = new ArrayList<Integer>(Arrays.asList(500000,
				100000,
				1167,
				9044,
				9829,
				9235,
				9726,
				7910,
				9886,
				5267,
				9093,
				9303,
				5,6,18,90,
				6214,
				7388));
		
	int average = (int)num
            .stream()
            .mapToInt(a -> a)
            .average().getAsDouble();
	
	System.out.println(average);
}
}
