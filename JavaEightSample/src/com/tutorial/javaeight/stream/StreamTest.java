package com.tutorial.javaeight.stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
		//filteringCheck();
		//mappingCheck();
		//findingTest();
		iterateStream();
		//numericStream();
		
	}

	
	public static void filteringCheck() {
		List<Dish> menu = Arrays.asList(
			    new Dish("pork", false, 800, Dish.Type.MEAT),
			    new Dish("beef", false, 700, Dish.Type.MEAT),
			    new Dish("chicken", false, 400, Dish.Type.MEAT),
			    new Dish("french fries", true, 530, Dish.Type.OTHER),
			    new Dish("rice", true, 350, Dish.Type.OTHER),
			    new Dish("season fruit", true, 120, Dish.Type.OTHER),
			    new Dish("pizza", true, 550, Dish.Type.OTHER),
			    new Dish("prawns", false, 300, Dish.Type.FISH),
			    new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		// print the names of 3 dishes with calories >300
		List<String> names = menu.stream().filter(d->{
			System.out.println(" filtering"+d.getName());
			return d.getCalories()>300;			
		}).map(d->{
			System.out.println("Mapping"+d.getName());
			return d.getName();		
		}).limit(3).collect(toList());		
		System.out.println(names);
		
		
		//filter the first 2 meat dishes
		menu.stream().filter(m->Dish.Type.MEAT.equals(m.getType()) || Dish.Type.FISH.equals(m.getType())).
				sorted(comparing(m->m.getName())).limit(2).forEach(x->System.out.println(x));
		
		// return the length of each dish name
		menu.parallelStream().map(m->m.getName()+ " " +m.getName().length()).forEach(x->System.out.println(x));
	
	}
	
	
	public static void mappingCheck() {
		
		List<String> charactersList = new ArrayList<String>();
		charactersList.add("Hello World");
		charactersList.add("Yes");
		
		// print distinct characters of a list.
	//	charactersList.stream().map(w->w.split("")).flatMap(Arrays::stream).distinct().forEach(x->System.out.println(x));
	
		
		// for a list of numbers return the square of each.
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(6);
		numbers.stream().map(num->num*num).forEach(System.out::println);
		
		List<Integer> numbers2 = new ArrayList<Integer>();
		numbers2.add(1);
		numbers2.add(2);
		numbers2.add(3);
		
		
		// for the given 2 integer lists. print the combination of each item.
		List<int[]> pairs = numbers.stream().flatMap(num->numbers2.stream().filter(j->(num+j)%3==0).map(j->new int[] {num,j}))
				.collect(Collectors.toList());
				
		pairs.stream().forEach(i->System.out.println("["+i[0]+","+i[1]+"]"));
	}
	
	
	public static void findingTest() {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(6);
		numbers.add(10);
		numbers.add(9);
		
		
		Optional<Integer> result =numbers.stream().filter(num->num>3).findAny();//.orElse(0);
		System.out.println(result.isPresent());
		result.ifPresent(System.out::println);
		
		// can be done using count method as well. numbers.stream().count();
		System.out.println("number of elements "+numbers.stream().map(num->1).reduce(0,(a,b)->a+b));
		System.out.println("Printing the last element ");
		numbers.stream().sorted().skip(numbers.size()-1).forEach(System.out::println);
	}
	
	public static void numericStream() {
		Stream<int[]> pythagoreanTriples =
				IntStream.rangeClosed(1, 100).boxed().flatMap(a->IntStream.rangeClosed(a,100)
        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
        .boxed()
        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
		
		pythagoreanTriples.forEach(num->System.out.println(num[0]+ " "+ num[1] + " "+ num[2]));
	}
	
	public static void iterateStream() {
		
			Stream.iterate(new int[] {0,1},(n->new int[] {n[1],n[0]+n[1]}))
					.limit(10).forEach(t -> System.out.print( t[0] + "," ));
	}
}
