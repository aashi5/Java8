package com.tutorial.javaeight.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class TradersTest {
public static void main(String[] args) {
	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario","Milan");
	Trader alan = new Trader("Alan","Cambridge");
	Trader brian = new Trader("Brian","Cambridge");

	List<Transaction> transactions = Arrays.asList(
	    new Transaction(brian, 2011, 300),
	    new Transaction(raoul, 2012, 1000),
	    new Transaction(raoul, 2011, 400),
	    new Transaction(mario, 2012, 710),
	    new Transaction(mario, 2012, 700),
	    new Transaction(alan, 2012, 950)
	);
	
	//1.  Find all transactions in the year 2011 and sort them by value (small to high).
	transactions.stream().filter(num->num.getYear()==2011).sorted(comparing(Transaction::getYear)).forEach(System.out::println);
	
	//2.  What are all the unique cities where the traders work?// you could use toSet() instead of dictinct()
	
	transactions.stream().map(trans->trans.getTrader().getCity()).distinct().forEach(System.out::println);
	
	//3.  Find all traders from Cambridge and sort them by name.
	transactions.stream().map(Transaction::getTrader).filter(trans->"Cambridge".contentEquals(trans.getCity()))
	.sorted(comparing(trans->trans.getName())).forEach(System.out::println);

	
	//4.  Return a string of all traders’ names sorted alphabetically.
	// used the map to only get the names of the traders and distinct to remove duplicates.
	transactions.stream().map(trans->trans.getTrader().getName()).distinct().sorted().forEach(System.out::println);


	//5.  Are any traders based in Milan? 
	//you could use findAny also here but it will return the object that matches instead of boolean.
	System.out.println("Are there traders from Milan: " + transactions.parallelStream().
			anyMatch(trans->"Milan".equals(trans.getTrader().getCity())));

	
	//6.  Print all transactions’ values from the traders living in Cambridge.
	// would use the map  function to return the values instead of printing them. 
	transactions.stream().filter(trans->"Cambridge".contentEquals(trans.getTrader().getCity()))
		.forEach(num->System.out.print(num.getValue() +", "));

	//7.  What’s the highest value of all the transactions?
	System.out.println(transactions.stream().max(comparing(num->num.getValue())));


	//8.  Find the transaction with the smallest value.
	System.out.println(transactions.stream().min(comparing(num->num.getValue())));


}
}
