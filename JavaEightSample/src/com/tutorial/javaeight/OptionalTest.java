package com.tutorial.javaeight;

import java.util.Optional;

public class OptionalTest{

	
	
	public static void main(String... args) {
	
		String myName=null;
		
		Optional<String> nameCheck = Optional.ofNullable(myName);// ofNullable used if the wrapped value can be null. \\
		//Optional<String> nameCheckNull = Optional.of(myName);// will throw null pointer exception
		
		/*
		 * if(nameCheckNull.isPresent()) { System.out.println("Name is null"); }
		 */
		if(!nameCheck.isPresent()) {
			System.out.println("nameCheck is null");
		}
		
		String orElseCheck=Optional.ofNullable(nameCheck).orElse(getDefaultValue()).toString();
		System.out.println("OR Else Check "+orElseCheck);
		
		//String orElseGetCheck =Optional.ofNullable(nameCheck).orElseGet(OptionalTest.getDefaultValue()).get();
		//System.out.println("Or Else Get Check"+ orElseGetCheck);
	}
	
	private static  Optional<String> getDefaultValue() {
		System.out.println("Getting default value");
		return Optional.of("Default value");
	}
}
