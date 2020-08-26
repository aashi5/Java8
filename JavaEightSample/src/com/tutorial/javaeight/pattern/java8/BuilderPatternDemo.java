package com.tutorial.javaeight.pattern.java8;

import java.util.function.Consumer;

import com.tutorial.javaeight.pattern.Shape;
import com.tutorial.javaeight.pattern.ShapeType;
import com.tutorial.javaeight.pattern.java8.ShapeArea.ShapeAreaBuilder;

public class BuilderPatternDemo {
	
	public static void main(String ...args) {
	
		ShapeAreaBuilder builder = new ShapeAreaBuilder(ShapeType.CIRCLE);
		ShapeArea shapeArea = (ShapeArea) builder.with(shapeBuilder->{
			shapeBuilder.radius=2;
		}).createShape();
		
		
		System.out.println("Area of " + shapeArea.getShapeType() + " is " + shapeArea.area());
		
	}
	
	
	
}

class ShapeArea implements Shape{

	private String shapeType;
	
	private long radius=0L;
	private long side=0L;
	private long height=0L;
	
	private ShapeArea(ShapeAreaBuilder builder) {
		this.shapeType=builder.shapeType;
		this.radius=builder.radius;
		this.side=builder.side;
		this.height=builder.height;
	}
	
	@Override
	public double area() {
		double area=0;
	switch(shapeType.toUpperCase()) {
	case "CIRCLE":
		area=3.14*radius;
		break;
	case "SQUARE":
		area=side*side;
		break;
	case "TRIANGLE":
		area=side*height;
		break;
	default:
		area=0;
	}
	return area;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("We are building a shape here ");
	}
	
	public String getShapeType() {
		return shapeType;
	}

		

	public static class ShapeAreaBuilder {

		
	private String shapeType;
	public  long radius=0L;
	public long side=0L;
	public long height=0L;
	
	
	/**
	 * Determine the type of Shape.
	 * @param shapeType
	 */
	public ShapeAreaBuilder(ShapeType shapeType) {
		this.shapeType = shapeType.toString();
	}
	
	//set the raduis/side /height parameters using this with method
	public ShapeAreaBuilder with(Consumer<ShapeAreaBuilder> builderFunction) {
		builderFunction.accept(this);
		return this;
	}

	public Shape createShape() {
		return new ShapeArea(this);
	}
	
	}
}

