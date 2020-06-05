package com.tutorial.javaeight.collectorsFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelismTest {

	public static void main(String[] args) {
		ParallelismTest test = new ParallelismTest();
		System.out.println("Using traditional loop : " + measureTime(test::traditionalCalc, 20) + "msec");

		System.out.println("Using sequential stream : " + measureTime(test::sequenctialCalc, 10_000) + "msec");
		
		System.out.println("Using parallel stream : " + measureTime(test::parallelCalc, 10_000) + "msec");
		
		
		System.out.println("Using range closed stream : " + measureTime(test::rangeClosedCalc, 10_000) + "msec");
		
	}
	
	/**
	 * Method to measure the time taken to calculate sum by different approaches 
	 * testing -sequential, parallel and traditional for loop approach
	 * @param adder - function to calculate sum
	 * @param n - the upper limit of sum.
	 * @return - fastest time in millisec after 5 trials.
	 */
	private  static long measureTime(Function<Long, Long> adder ,long n) {
		long fastest = Long.MAX_VALUE;
		long sum =0;
			long start = System.nanoTime();
			sum = adder.apply(n);
			long duration = (System.nanoTime() - start)/1_000_000;
			if(duration<fastest) fastest = duration;
			
		System.out.println("Result sum : " + sum);
		return fastest;
	}
	
	
	/**
	 * Function using parallel stream execution.
	 * @param n
	 * @return
	 */
	private Long parallelCalc(long n) {
		
		
		return Stream.iterate(1L,num->num+ 1)
		.limit(n)
		.parallel().
		reduce(0L,Long::sum);	
		
	}
	
	/**
	 * Calculating the sum in sequential order.
	 * @param n
	 * @return
	 */
	private Long sequenctialCalc(long n) {
		
		return Stream.iterate(1L,num->num+ 1)
				.limit(n)
				.reduce(0L,Long::sum);	
				
	}
	
	/**
	 * Traditional method of calculating sum using loops
	 */
	private Long traditionalCalc(long n) {
		long sum =0;
		for(long i =1;i<=n;i++) {
			sum += i;
		}
		return sum;
	}
	
	
	private Long rangeClosedCalc(long n) {
		return LongStream.rangeClosed(1, n).parallel().reduce(0L,Long::sum);
	}
}



