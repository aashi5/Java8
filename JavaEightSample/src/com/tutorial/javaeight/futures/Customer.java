package com.tutorial.javaeight.futures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Client for Completable Future
 * @author Ashwini
 *
 */
public class Customer {

	public static void main(String[] args) {
		Customer customer = new Customer();
		//customer.calculatePrice();
		customer.findPrice();
		System.out.println("No of processors" +Runtime.getRuntime().availableProcessors());
	}
	
	public void calculatePrice() {
		Shop bakershop = new Shop("Bakers Shop");
		System.out.println("Bakers Shop");
		long startTime= System.nanoTime();
		Future<Double> futureCakePrice = bakershop.getPriceAsync("Cake");
		
		long invokeTime = (System.nanoTime() - startTime)/1_000_000;
		System.out.println("Invokation time "  + invokeTime +  " ms");
		
		// do other tasks while the async task is working in another thread.
		Shop clothesShop = new Shop("Clothes Shop");
		Double chothesPrice = clothesShop.getPrice("Gown");
		
		try { 
			// get() will wait indefinitely . get(time,timeunit) waits for the specified time 
			double cakePrice = futureCakePrice.get(10,TimeUnit.MILLISECONDS); // wait for 10 msec for the computation to complete if it hasnt already.
			System.out.printf("Cake price is  %.2f%n" , cakePrice);// retrieve the cake price. 
			System.out.println("Gown price " + chothesPrice);
		}catch(Exception e) {
			throw new RuntimeException();
		}
		long retrievalTime =( System.nanoTime()-startTime)/1_000_000;
		System.out.println("retrieval time:  "+ retrievalTime + " ms");
		
	}
	
	public void findPrice() {
		List<Shop> shopsList = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));
		
		// parallelism using Completable Future.
		// step 1 calculate each price parallely using completable future.
		List<CompletableFuture<String>> futuresList=
		shopsList.stream().map(shop->CompletableFuture.supplyAsync
					(()->shop.getShopName() + "Price is "+ shop.getPrice("egg"))).collect(Collectors.toList());
		
		
		futuresList.stream().map(CompletableFuture::join).forEach(System.out::println);
		
		
		
		
	}
}
