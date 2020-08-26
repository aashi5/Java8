package com.tutorial.javaeight.pattern.java8;

import java.util.ArrayList;
import java.util.List;

public class StrategyPatternDemo {
	/**
	 * Use lambdas to define the logic of the Strategy implementation. Possible only if the logic is simple and short.
	 * @param args
	 */
	public static void main(String ...args) {
		List<Double> priceList= new ArrayList<Double>(); 
		priceList.add(23.00);
		priceList.add(5.00);	
		priceList.add(8.00);
		priceList.add(9.00);
	
		
		CalculatePrice normalPrice = new CalculatePrice((List<Double> prices)->prices.stream().mapToDouble(d->d).sum());
		System.out.println(normalPrice.calculatePrice(priceList));
		
		
		CalculatePrice happyHourPrice = new CalculatePrice((List<Double> prices)->prices.stream().mapToDouble(d->d/2).sum());
		System.out.println(happyHourPrice.calculatePrice(priceList));
		
		
		
	}
}


/**
 * The Strategy interface may be a functional interface if there is only one method being exposed. 
 * @author Ashwini
 *
 */
@FunctionalInterface
interface PricingStrategy{
	public double calculatePrice(List<Double> pricesList);
}


class CalculatePrice {
	public PricingStrategy pricing;
	
	public CalculatePrice(PricingStrategy pricingStrategy) {
		this.pricing =pricingStrategy;
	}
	

	double calculatePrice(List<Double> pricesList) {
		return pricing.calculatePrice(pricesList);
	}
}