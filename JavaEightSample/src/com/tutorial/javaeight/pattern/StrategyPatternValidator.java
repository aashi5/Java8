package com.tutorial.javaeight.pattern;

import java.util.function.Predicate;
/**
 * Java 8 solution for the Strategy Design pattern. Allows the strategy rules
 * to be specified dynamically on the client side without the need to 
 * develop seperate instance classes for each rule.
 * 
 * Example used here is handle various validation rules.
 * @author ashwi
 *
 */
public class StrategyPatternValidator {
	
	/**
	 * Client code can specify the rule as a function 
	 * @param args
	 */
		public static void main(String[] args) {
		// TODO Auto-generated method stub

		ValidationStrategy validateNumeric = 
				new Validator((String s)-> s.matches("[a-z]+"));
		
		boolean b1 =  validateNumeric.validate("add");
		System.out.println(b1);
	}

	
}

/**
 * Functional Interface to define the skeleton of the strategy
 * @author ashwi
 *
 */
@FunctionalInterface
interface ValidationStrategy {
	
	public boolean validate(String str);
	
}

/**
 * Implementation class for validator.
 * @author ashwi
 *
 */
class Validator implements ValidationStrategy{
	
	Predicate<String> pattern ;


	public Validator(Predicate<String> object) {
		this.pattern = (Predicate<String>) object;

	}
	
	/**
	 * 
	 */
	public boolean validate(String value){
		return this.pattern.test(value);
	}
}