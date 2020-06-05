package com.tutorial.javaeight.futures;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Example for Asynchronous method call
 * @author Ashwini
 *
 */
public class Shop {
	
	
	String shopName;
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Shop(String shopName) {
		this.shopName=shopName;
	}
	/**
	 * Synchronous call will cause the calling thread to be blocked until this method finishes its computation
	 * @param product
	 * @return
	 */
	//Synchronous call  - causes the calling function to be blocked.  
	public double getPrice(String product) {
		// to be implemented.
		return calculatePrice(product);
		
	}
	
	/**
	 * The return type being a Future obj the method call returns immediately without waiting for the completion of computation 
	 * giving a chance to the caller thread to carry on with other task if needed.	
	 * @param product
	 * @return
	 */
	public Future<Double> getPriceAsync(String product) {
		// to be implemented.
		CompletableFuture<Double> compFuturePrice = new CompletableFuture<Double>(); // will contain the result of the computation.
		// supplyAsync is the alternative to creating new thread and invoking complete.
		//return CompletableFuture<Double>.supplyAsync(()->calculatePrice(product));
		new Thread(() ->{
			try {
			double price = calculatePrice(product); // long running method.
			// sets the result of the long computation on the future object when it completes.
			compFuturePrice.complete(price); 
			
			
		
			}catch(Exception ex) {
				compFuturePrice.completeExceptionally(ex);
			}
		}).start(); // invoke a separate thread to complete the long running operation in parallel.
		return compFuturePrice; // returns the future price without waiting for the computation to complete.
		
	}


	
	/**
	 * sample method to simulate a long running api call using the delay call. 
	 * @param product
	 * @return
	 */
	private double calculatePrice(String product) {
		Shop.delay();
		Random random = new Random();
		
		return  (random.nextDouble() * product.charAt(0)) + this.getShopName().charAt(0);
		
	}
	
	public static void delay() {
	    try {
	        Thread.sleep(1000L);
	    } catch (InterruptedException e) {
	        throw new RuntimeException(e);
	    }
	}
}
