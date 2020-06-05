package com.tutorial.javaeight.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdasAndFunctions {
	
	
	public static void main(String[] args) {
		
		List<Apple> appleList = new ArrayList<Apple>();
		appleList.add(new Apple("Red", 160));
		appleList.add(new Apple("Green", 110));
		appleList.add(new Apple("Red", 120));
		appleList.add(new Apple("Green", 90));
		appleList.add(new Apple("Red", 115));
		appleList.add(new Apple("Green", 168));
		
		
		// appending multiple predicates.
		Predicate<Apple> redApple = apple->"Red".contentEquals(apple.getColor());
		Predicate<Apple> redHeavyApples = redApple.and(x->x.getWeight()>150);
		System.out.println(" Red Apples with weight >150 g :" + appleList.stream().filter(redHeavyApples).collect(Collectors.toList()));
		
		 // Supplier Method example
		Supplier<Integer> randomIntSupplier =() -> new Random().nextInt(10);
		Stream.generate(randomIntSupplier).limit(5).forEach(System.out::println);

		
		
		
		
	}
	

}
