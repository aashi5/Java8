package com.tutorial.javaeight;

public class AnimalDefaultMethodSample implements Walkable {

	@Override
	public String act() {
		return "i am an animal ";
	}
	
	
	 public String move() { return "This is an animal moving"; }
	
	public static void main(String[] args) {
		
		AnimalDefaultMethodSample tiger = new AnimalDefaultMethodSample();
		System.out.println(tiger.move());
		// will not have access to the sampleMessage in Walkable.
		AnimalDefaultMethodSample.sampleMessage();// only valid because this class has a static method with the same signature. 
		
		// to access sample message of Walkable.
		Walkable.sampleMessage();
		
	}

	public static void sampleMessage() {
		System.out.println("i am in animal default");
	}
}
