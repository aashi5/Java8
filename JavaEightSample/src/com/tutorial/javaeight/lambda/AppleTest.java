package com.tutorial.javaeight.lambda;

import java.util.ArrayList;
import java.util.List;

public class AppleTest {

	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<Apple>();
		appleList.add(new Apple("Red", 160));
		appleList.add(new Apple("Green", 110));
		
		
		//prettyPrintApple(appleList, new AppleFancyFormatter() );
		//prettyPrintApple(appleList, new AppleSimpleFormatter());
		
		
		// anonymous class variant
		prettyPrintApple(appleList, new ApplePredicate<Apple>() {

			@Override
			public String printAppleCriteria(Apple a) {
				String description = a.getWeight()>150?"Heavy":"Light";
				return description;
			}
			
		});
		
		
		
		
	}
	
	public static void prettyPrintApple(List<Apple> inventory, ApplePredicate<Apple> pred){
	    for(Apple apple: inventory) {
	        String output = pred.printAppleCriteria(apple);
	        System.out.println(output);
	    }
	}
}


interface ApplePredicate<T> {
	
	public String printAppleCriteria(Apple a);

}

class Apple{
	String color;
	int weight;
	
	Apple(String color,int weight){
		this.color= color;
		this.weight=weight;
		
		
	}
	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}

class AppleFancyFormatter implements ApplePredicate<Apple>{

	@Override
	public String printAppleCriteria(Apple a) {
		String description = (a.getWeight()>150)?"Heavy":"Light";
		return "The " + a.getColor()+" Apple is " + description;
	}
	
}


class AppleSimpleFormatter implements ApplePredicate<Apple>{

	@Override
	public String printAppleCriteria(Apple a) {
		
		return "The Apple weight is  " + a.getWeight() + "g.";
	}
	
}
