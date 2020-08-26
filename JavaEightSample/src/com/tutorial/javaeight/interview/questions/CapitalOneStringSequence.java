package com.tutorial.javaeight.interview.questions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CapitalOneStringSequence {

	public static void main(String... strings) {
		minSequence();
	}

	/**
	 * since t is the shorter String find all numbers in the range of 1 to t.len/2
	 * such that t.len%n==0 this will give us possible lengths of sequences.
	 * 
	 * The second section of this method iterates through the concatenated result of
	 * both s & t with various lengths retrieved from the above step. The length of
	 * the first seq that has a complete match throughout is our answer.
	 */
	static void minSequence() {
		String s = "bcdbcdbcdbcd";
		String t = "bcdbcd";

		int sLen = s.length();
		int tLen = t.length();
		boolean seqFound = true;
		int finalVal = -1;
		// if String s length is a multiple of t then it may be constructed from t.
		if (sLen % tLen == 0) {
			List<Integer> seqSizeList = IntStream.range(1, tLen + 1 / 2).filter(x -> tLen % x == 0).boxed().sorted()
					.collect(Collectors.toList());
			seqSizeList.add(tLen);

			
			
			
			// find the lowest sequence which is there in both s & t
			String concatenatedString = t.concat(s);
			matchSequence(seqSizeList,concatenatedString);

			
			for (Integer val : seqSizeList) {
				String seq = concatenatedString.substring(0, val);
				for (int j = 0; j < concatenatedString.length(); j += val) {
					String value = concatenatedString.substring(j, j + val);
					if (!value.equals(seq)) {
						seqFound = false;
						finalVal = -1;
						break;
					}
				}
				if (seqFound) {
					finalVal = val;
					break;
				}
				seqFound = true;
			}
		}
		System.out.println(finalVal);
	}

	public static void matchSequence(List<Integer> seqList, String str) {
		boolean seqFound = true;
		int finalVal = -1;
		
		List<String> strList = seqList.parallelStream().map(val -> str.substring(0, val))
					.collect(Collectors.toList());
		int j=0;
		for(String seq: strList) {
			String value = str.substring(j, j + seq.length());
			if (!value.equals(seq)) {
				seqFound=false;
				finalVal=-1;
				continue;
			}
		}
	}

}
