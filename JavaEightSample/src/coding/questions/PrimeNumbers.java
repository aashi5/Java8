package coding.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbers {

	public static void main(String...strings) {
		int n =50;
		sieveApproach(n);
		
		System.out.println( "Brute Force");
		bruteForce(n);
	}
	
	
	private static  void bruteForce(int n) {
		IntStream numRange = IntStream.range(2, n);
		List<Integer> primeList= new ArrayList<Integer>();
		primeList.add(1);
		numRange.forEach(num->{
				boolean isPrime =true;
				for(int j =2; j<num;j++) {
					if(num%j==0) {
						isPrime=false;
						break;
					}
				}
				if(isPrime) {
					primeList.add(num);
				}
		});
		
		primeList.stream().forEach(val->System.out.print(val+" ,"));		
	
	}
	
	/**
	 * 
	 * @param n
	 */
	private static void sieveApproach(int n ) {
		Object[]  primeArr = new Object[n]; 
		primeArr=(Object[]) Arrays.stream(primeArr).
					map(val->val=true).collect(Collectors.toList()).toArray();
		for(int j=2;j*j<=n;j++) {
			for(int i=j;i<n;i+=j) {
				if(primeArr[i].equals(true) && i>j) {
					if(i%j==0) {
						primeArr[i]=false;
					}
				}
			}
		}
		
		
		for(int num =1; num<n;num++) {
			if(primeArr[num].equals(true)) {
				System.out.print(num + " ,");
			}
		}
		
	}
}
