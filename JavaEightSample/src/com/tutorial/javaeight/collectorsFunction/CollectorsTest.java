package com.tutorial.javaeight.collectorsFunction;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.tutorial.javaeight.stream.Dish;
public class CollectorsTest {

	public enum CaloricLevel { DIET, NORMAL, FAT }
	
	public static void main(String[] args) {
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
	
	
		//reducingfunctions(menu);
	//groupingFunctions(menu);
	//partitioningFunction(menu);
	}	
	
	
	public static void reducingfunctions(List<Dish> menu) {
		// most calories dish
		Optional<Dish> mostHeavyDish = menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
		System.out.println(mostHeavyDish.get());
		
		// total calories of all dishes. 
		IntSummaryStatistics sumOfCalories = menu.parallelStream().collect(Collectors.summarizingInt(Dish::getCalories));
		
		System.out.println(sumOfCalories.getSum());
		
		// All dish names
		System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(",")));
		
		System.out.println(menu.stream().collect(Collectors.reducing(0,Dish::getCalories,Integer::sum)));
		
	}
	
	
	public static void groupingFunctions(List<Dish> menu) {

		
		
		Map<Dish.Type, List<Dish>> dishTypes = menu.stream().collect(Collectors.groupingBy(Dish::getType));
		dishTypes.values().stream().forEach(System.out::println);
		
		
		
		//custom other than by method reference. 
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevelMap = menu.stream().collect(
		         Collectors.groupingBy(dish -> {
		                if (dish.getCalories() <= 400) return CaloricLevel.DIET;
		                else if (dish.getCalories() <= 700) return
		    CaloricLevel.NORMAL;
		        else return CaloricLevel.FAT;
		         } ));
		for(CaloricLevel cal: dishesByCaloricLevelMap.keySet()) {
			System.out.println(cal + "[" + dishesByCaloricLevelMap.get(cal) + "]");
		}
		
		
		//multi level grouping
		Map<Dish.Type,Map<CaloricLevel, List<Dish>>> multilevelgroup = menu.stream().collect(
				Collectors.groupingBy(Dish::getType,
						Collectors.groupingBy(dish -> {
							if (dish.getCalories() <= 400) return CaloricLevel.DIET;
							else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
							else return CaloricLevel.FAT;
						})
		         )
				);
		System.out.println("--------Multi level Grouping -----------");
		for(Dish.Type t: multilevelgroup.keySet()) {
			System.out.println(t +"[" + multilevelgroup.get(t) + "]");
		}
		
		
		// grouping and 
		Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, Collectors.counting()));
		for(Dish.Type t: typesCount.keySet()) {
			System.out.println(t +"[" + typesCount.get(t) + "]");
		}
		
	}

	public static void partitioningFunction(List<Dish> menu) {
		
		Map<Boolean, List<Dish>> dishTypes =menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
		//dishTypes.values().stream().forEach(System.out::println);
		System.out.println(dishTypes.get(true));
		
		Stream<Integer> numbersList =Stream.iterate(0,n->n+1).limit(20);
		//partition odd and even numbers and getting the numbers >10
		//numbersList.collect(Collectors.partitioningBy(n->n%2==0),Collectors.collectingAndThen(Collectors.summingInt(n)));
		Map<Boolean,Map<Boolean,List<Integer>>> numbersMap = numbersList.collect(Collectors.partitioningBy(n->n%2==0,
				Collectors.partitioningBy(d->d%5==0)));
		
		numbersMap.get(true).get(true).forEach(System.out::println);
		
		numbersMap.get(false).get(true).forEach(System.out::print);
		
	}
}

