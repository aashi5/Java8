package com.tutorial.javaeight;

@FunctionalInterface
public interface FunctionalInterfaceSample {
	// abstract keyword is not mandatory.
	public abstract void testMe();
	
	//results in  compilation error since toString is already defined in Object. so to avoid diamond problem.
	/*
	 * public default String toString() { System.out.println(""); }
	 */
	
	//valid since it is abstract and not having a body
	public abstract String toString();
	
	public default void logMe(String statement) {
		System.out.println(statement);
	}
	
	public default void logDefault() {
		System.out.println("This is the default log");
	}
	
}
