package com.tutorial.javaeight.patterns.old;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StrategyPatternDemo {

	public static void main(String ...args) {
		List<Double> itemPrices = new ArrayList<Double>(); 
		itemPrices.add(23.00);
		itemPrices.add(5.00);
		itemPrices.add(8.00);
		itemPrices.add(9.00);
		PricingStrategy pricingStrategy =null;
		// the different stategy implementation is chosen based on time of day. 
		Calendar cal = Calendar.getInstance();
		if(cal.get(Calendar.HOUR_OF_DAY)==16) {
			pricingStrategy =  new HappyHourPricing();			
		}else {
			pricingStrategy = new NormalPricing();
		}
		System.out.println("Sum total " + pricingStrategy.calculatePrice(itemPrices));
	}
}


interface PricingStrategy{
	public double calculatePrice(List<Double> priceList);
}

class NormalPricing implements PricingStrategy{

	@Override
	public double calculatePrice(List<Double> pricesList) {
		double sum =0;
		for(Double itemPrice :pricesList) {
			sum +=itemPrice;
		}
		return sum;
	}
	
}

class HappyHourPricing implements PricingStrategy{

	@Override
	public double calculatePrice(List<Double> priceList) {
		// happy pricing is 50% discount over normal pricing. 
		NormalPricing normalPricing = new NormalPricing();
		return normalPricing.calculatePrice(priceList)/2;
	}
	
}


