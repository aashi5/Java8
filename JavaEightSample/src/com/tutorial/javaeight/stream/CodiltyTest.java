package com.tutorial.javaeight.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class CodiltyTest {

	public static void main(String[] args) {
		int[] numarr= new int[] {-1, -3};
		//sort the array.
		Arrays.parallelSort(numarr);
		//System.out.println(solution(numarr));
		//System.out.println(solution(numarr,0));
		solution(1232);
		//solution("011100");
	}
		
	
	
	 public static  int solution(String S) {
	        // write your code in Java SE 8
		 long decimal=Long.parseLong(S,2);
		// int value =0;
		 int counter =0;
		 
		 while(decimal>0) {
			 if(decimal%2==0) {
				 decimal =decimal/2;
			 }else {
				 decimal = decimal -1;				 
			 }
			 counter++;
			 System.out.println(decimal);
		 }
		 System.out.println(counter);
		 return counter;
	 }
	
	
	 public static int solutionJava8(int num) {
		 
		 IntStream numStream = IntStream.of(num);
		// numStream.flatMap(val->val/5).forEach(System.out::println);
		 return 0;
	 }
	 
	 public static int solution(int num) {
		 
		 String str= Integer.toString(num);
		 String tempString = "";
		 
	
		 for(int i=0,position=0;i<str.length();i++) {
			 if(num>=0) {
			 if(Integer.parseInt(String.valueOf(str.charAt(i)))>5) {
				 position++;
				
			 }else {
				 tempString=str.substring(0, position) 
						 + "5" + str.substring(position++,str.length());
				 break;
			 }
			 }else {
				 tempString = "-5"+str.substring(1, str.length());
			 }
		 }
		 
		
		 return Integer.parseInt(tempString);
	 }
	
	
	
	/*
	 * public static int solution(int N) {
	 * 
	 * int[]digits = Integer.toString(N).chars().map(c -> c-'0').toArray();
	 * List<Integer> numList = new ArrayList<Integer>(); for(int i
	 * =0;i<digits.length;i++) { if(digits[i]>=5) { numList.add(digits[i]); }else {
	 * numList.add(5); //s digits[i] //numList.addAll(Arrays.asList(a) } }
	 * 
	 * return 0; }
	 */
	static int solution(int[] A) {
	        int ans = 0;
	        for (int i = 0; i < A.length; i++) {
	            if (ans > A[i]) {
	                ans = A[i];
	            }
	        }
	        return ans;
	    }
	
	
	/**
	 * 
	 * @param numArray
	 * @param prev
	 * @return
	 */
	 public static int solution(int[] numArray, int prev) {
		 	
		 	int result = -1;
		 
		 	if(numArray.length==0) {
		 		return prev+1;	
	        }else {
	        // sorts the positive integers in the list and gets the minimum 
	        int num = Arrays.stream(numArray).filter(n->n>prev).min().orElse(1);
	        
			/*
			 * // if there is a number less than the minimum number if(num<=prev ) { return
			 * num; }
			 */        	
	        
	        if(num-1>prev){
	        	 return prev+1;
	        }else {
	        	result =solution(Arrays.stream(numArray).distinct()
	        			.skip(1).toArray(),num);
	        }
	        
	        }
	        return result;
	    }
	 
	 
	}
