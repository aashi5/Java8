package com.tutorial.javaeight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionalProgramSample {

	public static void main(String[] args) {
	
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(1);
		numList.add(4);
		numList.add(9);
		subSets(numList).stream().forEach(num ->System.out.println(num));;
	}
	
	
	static List<List<Integer>> subSets(List<Integer> numbers){
		FunctionalProgramSample fp = new FunctionalProgramSample();
		if(numbers.isEmpty()) {
			List<List<Integer>> resultList = new ArrayList<List<Integer>>();
			resultList.add(Collections.emptyList());
			return resultList;
		}
		
		Integer first = numbers.get(0); //- get the first number from the list.
		
		List<Integer> restList = numbers.subList(1,numbers.size());
		List<List<Integer>> subans= subSets(restList);
		List<List<Integer>> subList =  fp.insertAll(first, subans); //	
		return fp.concat(subans ,subList);
		
	}
	
	/**
	 * insert first value to all the items of the list.
	 * @param first
	 * @param subans
	 * @return
	 */
	public List<List<Integer>> insertAll(Integer first, List<List<Integer>> subans){
		
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		
		for(List<Integer> list : subans) {
			List<Integer> subList = new ArrayList<Integer>();
			subList.add(first);
			subList.addAll(list);
			resultList.add(subList);
		}
		return resultList;
 	}
	
	/**
	 * Functional programming principle - the input object should not be mutated.
	 * @param firstList
	 * @param secondList
	 * @return result list is a concatenation of the first and second lists. 
	 */
	public List<List<Integer>> concat(List<List<Integer>> firstList, List<List<Integer>> secondList){
		
		List<List<Integer>> resultList = new ArrayList<List<Integer>>(firstList);
		resultList.addAll(secondList);
		
		return resultList;
	}
}
