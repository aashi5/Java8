package com.tutorial.javaeight.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.xml.stream.events.Characters;

public class CapitalOneInterview {

	public static void main(String... args) {
		/*
		 * practice(); commonElementsinArrays();
		 */
		// sum();
		minSum();
		// strConcat();
	}

	private static void practice() {
		int k = 3;
		List<Integer> numList = new ArrayList<>();
		numList.add(8);
		numList.add(9);
		numList.add(5);
		numList.add(3);
		boolean num = numList.stream().anyMatch(n -> n == k);
		System.out.println(num);

		IntStream numRange = IntStream.range(1, 10);

		List<Integer> intList = numRange.filter(n -> n % 2 != 0).boxed().collect(Collectors.toList());

	}

	/**
	 * Problem statement : find the common elements between 2 arrays which are
	 * sorted and contains distinct elements
	 */
	private static void commonElementsinArrays() {
		Integer[] a = { 3, 5, 6, 7 };
		Integer[] b = { 5, 8, 9, 10, 18, 19, 34 };
		List<Integer> resultList = new ArrayList<Integer>();
		Set<Integer> numSet = new TreeSet<Integer>();

		// add whichever is the bigger array to the Set to increate speed.
		if (b.length > a.length) {
			Collections.addAll(numSet, b);
			resultList = findDuplicate(numSet, a, b[b.length - 1]);
		} else {
			Collections.addAll(numSet, a);
			resultList = findDuplicate(numSet, b, a[a.length - 1]);
		}
		resultList.stream().forEach(System.out::println);
	}

	/**
	 * try to add the elements of the second array to the set will return false if
	 * the element already exists.
	 * 
	 * @param numSet
	 * @param otherArray
	 * @param max
	 */
	private static List<Integer> findDuplicate(Set<Integer> numSet, Integer[] otherArray, int max) {
		List<Integer> resultList = new ArrayList<Integer>();

		for (int i = 0; i < otherArray.length; i++) {
			if (otherArray[i] > max)// since the arrays are sorted and distinct we can break out of the loop if the
									// element in this array
				// exceeds the max of the first array
				break;
			if (!numSet.add(otherArray[i])) {
				resultList.add(otherArray[i]);
			}

		}
		return resultList;

	}

	private static void sum() {

		List<Integer> aList = new ArrayList<Integer>(Arrays.asList(5, 10, 20));
		int k = 13;

		List<Integer> tempList = aList.stream().limit(k).map(n -> (int) Math.ceil((float) n / 2))
				.collect(Collectors.toList());
		tempList.addAll(aList.subList(tempList.size(), aList.size()));
		aList = tempList;
		/*
		 * for(int i=0;i<k;i++) { aList.stream().max(null).ifPresent(x->{
		 * aList.remove(aList.indexOf(x)); aList.add((int)Math.ceil((float)x/2)); });
		 */

		/*
		 * Stream.iterate(0 , i->i+1).limit(k).forEach(x->{ Integer maxNum
		 * =Collections.max(aList); aList.remove(aList.indexOf(maxNum));
		 * aList.add((int)Math.ceil((float)maxNum/2));
		 * 
		 * });
		 */

		/*
		 * for (int i = 0; i < k; i++) {
		 * 
		 * 
		 * int max=Collections.max(aList); if(max==2) { break; }
		 * aList.remove(aList.indexOf(max)); aList.add((int)Math.ceil((float)max/2)); }
		 */
		// System.out.println(aList.stream().reduce(0, Integer::sum));

	}

	public static void minSum() {

		List<Integer> num = new ArrayList<Integer>(Arrays.asList(7, 10, 20000));
		int k = 6;
		int len = num.size();
		boolean minFound = false;
		int iterateFull = 0; // iterate through the list this many times.
		int iteratePartial = k; // iterate through the list partially.

		int average = (int)num
	            .stream()
	            .mapToInt(a -> a)
	            .average().getAsDouble();
		
		if (k > len) {
			iterateFull = k / len;
			iteratePartial = k % len;	
	
		}
		for (int i = 0; i < iterateFull; i++) {
			num = num.stream().sorted().filter(val->val>average).
					map(val -> (int) Math.ceil((float) val / 2))
					.collect(Collectors.toList());
			
			if (Collections.max(num) <= 1) {
				minFound = true;
				break;
			}

		}
		if (!minFound) {
			// iterate through the list iteratePartial number of times to divide the max
			// element/2 .
			for (int i = 0; i < iteratePartial; i++) {
				int max = Collections.max(num);
				num.remove(num.indexOf(max));
				num.add((int) Math.ceil((float) max / 2));
			}
		}
		System.out.println(num.stream().reduce(0, Integer::sum));
	}

	private static void strConcat() {
		String s = "lrbb";
		String t = "lrbb";
		int tlen = t.length();
		int slen = s.length();
		String seq = "";
		String prev = "";
		boolean seqFound = true;
		int finalVal = -1;
		if (slen % tlen == 0) {
			// find the smallest sequence.
			for (Character c : t.toCharArray()) {
				prev = prev.concat(c.toString());
				if (seq.indexOf(prev) == -1) {
					seq = seq.concat(prev);
					prev = "";
				}
				if (prev.contentEquals(seq)) {
					prev = "";
				}

			}
			seq = seq.concat(prev);
			if (seqFound) {
				finalVal = seq.length();
				// concat both S and T and find if the substing seq is repeated.
				String concatenatedString = s.concat(t);
				if (concatenatedString.length() % finalVal == 0) {

					for (int i = 0; i < concatenatedString.length(); i += finalVal) {
						String value = concatenatedString.substring(i, i + finalVal);
						if (!value.equals(seq)) {
							seqFound = false;
							finalVal = -1;
							break;
						}

					}

				}
			}

		}
		System.out.println(finalVal + seq);

	}

	private static void strSeqeuence() {
		String s = "bcdbcdbcdbcdd";
		String t = "bcdbcd";
		boolean seqFound = true;
		int sLen = s.length();
		int tLen = t.length();
		int finalValue = -1;
		;
		List<Integer> seqSizeList = new ArrayList<Integer>();
		// if String s length is a multiple of t then it may be constructed from t.
		if (sLen / tLen == 0) {
			// find all numbers into which the String t can be equally divided
			for (int i = 0; i < tLen / 2; i++) {
				if (tLen / i == 0)
					seqSizeList.add(i);
			}

			finalValue = findSmallestSubSequence(t, seqSizeList);
			System.out.println("Final value " + seqFound);

		}
	}

	private static int findSmallestSubSequence(String str, List<Integer> seqSizeList) {
		int finalValue = -1;
		boolean seqFound = true;
		if (seqSizeList.size() > 0) {
			for (Integer seqLen : seqSizeList) {
				finalValue = seqLen;
				String seq = str.substring(0, seqLen);
				for (int i = 0; i < str.length(); i += seqLen) {
					String value = str.substring(i, i + seqLen);
					if (!value.equals(seq)) {
						seqFound = false;
						break;
					}

				}
				// if all the substrings match
				if (finalValue > -1 && seqFound) {
					break;
				}
			}
		}
		return finalValue;
	}

}
