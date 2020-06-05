package com.tutorial.javaeight.collectorsFunction;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Function;
import java.util.stream.LongStream;

public class ForkJoinTest {
	
	public static void main(String[] args) {
		long[] numbers = LongStream.rangeClosed(1, 20).toArray();
		ForkJoinTask<Long> forkSumCalc = new ForkJoinSumCalculator(numbers);
		//java 7
		System.out.println("New Task "+ new ForkJoinPool(2).invoke(forkSumCalc));
		
		//java 8
		ForkJoinPool pool =  ForkJoinPool.commonPool();
		
		pool.shutdown();
		
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


}

class ForkJoinSumCalculator extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final long THRESH_HOLD=10;
	private final long start;
	private final long end;
	private final long numbers[];
	
	// public constructor to create the main task . 
	public ForkJoinSumCalculator(long[] numbers){
		this(numbers,0,numbers.length);
	}
	
	/**
	 * Constructor to create forks
	 * @param numbers
	 * @param start
	 * @param end
	 */
	private ForkJoinSumCalculator(long[] numbers , long start, long end){
		this.start =start;
		this.end=end;
		this.numbers=numbers;
		
	}
	
	/**
	 * will have the logic to breakdown the tasks into subtasks and invoke the compute method.
	 */
	@Override
	protected Long compute() {
		
		long length = end-start;
		// there can be no more sub tasks if the length of the array is less than threshhold limit.
		if(length<THRESH_HOLD) {
			return this.calcuteSum();
		}
			// fork the task to subtasks.
			ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers,start,(start + length/2)); 
			leftTask.fork(); // fork out the task to be executed by a new thread;
			
			ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, (start+length/2)+1, end);//create a second subtask
			Long rightResult = rightTask.compute(); // execute the 2nd subtask.uses the same existing thread while the fork uses the new thread .
			long leftResult =leftTask.join();	// 	read the result of the first subtask or wait for it to finish.
			
		// add the result of the 2 subtasks to compute the total sum.
		return leftResult+rightResult;
	}
	
	
	private  long calcuteSum() {
		long sum=0;
		for(long i =this.start;i<=this.end;i++) {
			sum+=i;
		}
		return sum;
	}

}
