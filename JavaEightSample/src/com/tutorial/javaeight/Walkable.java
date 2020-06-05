package com.tutorial.javaeight;

public interface Walkable extends Moveable{

	public default String move(String animal ){
		return "i am a walking " + animal;
	}
	
	public static void sampleMessage() {
		System.out.println("I am a sample message");
	}
}
