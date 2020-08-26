package com.tutorial.javaeight.pattern;

public class Circle implements Shape {
	
	

	@Override
	public void draw() {
		System.out.println("This is a Circle Shape");
	}

	@Override
	public double area() {
		return 0;
		//return radius[0]*3.14;
	}

}
