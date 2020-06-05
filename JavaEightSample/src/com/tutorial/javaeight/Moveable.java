package com.tutorial.javaeight;

@FunctionalInterface
public interface Moveable {

	public abstract String act();
	public default String move(){
		return "i am moving";
	}
}
