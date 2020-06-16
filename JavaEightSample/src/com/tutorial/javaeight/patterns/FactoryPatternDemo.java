package com.tutorial.javaeight.patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory Pattern sample implementation prior to java 8 
 * @author Ashwini
 *
 */
	enum ShapeType{
		CIRCLE,
		SQUARE,
		TRIANGLE,
		SPECIAL
	}


public class FactoryPatternDemo {
	
	public static void main(String... args) {
		
		IShapeFactory factry = new ShapeFactory();
		Shape circle =factry.getShape(ShapeType.CIRCLE);
		circle.draw();
	}
}

/**
 * Interface for the Shape Factory.
 * @author Ashwini
 *
 */
interface IShapeFactory{
	Shape getShape(ShapeType shapeName);
}

/**
 * Implementing class for the Shape Factory.
 * @author Ashwini
 *
 */
class ShapeFactory implements IShapeFactory{
	
	public static final Map <ShapeType, Shape> shapeMap = new HashMap<ShapeType, Shape>();
	static {
		shapeMap.put(ShapeType.CIRCLE,new Circle() );
		shapeMap.put(ShapeType.SQUARE,new Square());
		shapeMap.put(ShapeType.TRIANGLE,new Triangle());
	}
	
	
	public Shape getShape(ShapeType shapeName){	
		
		
		/*
		 * Shape shape = null; switch(shapeName) { case CIRCLE: shape =new Circle();
		 * break; case SQUARE: shape=new Square(); break;
		 * 
		 * case TRIANGLE: shape=new Triangle(); break; default: break; }
		 */
		
		return shapeMap.get(shapeName);
		
	}
}

/**
 * 
 * @author Ashwini
 *
 */
interface Shape {
	void draw();
	double area(float ...params);
}
class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("This is a Circle Shape");
	}

	@Override
	public double area(float ...radius) {
		
		return radius[0]*3.14;
	}

	
	
}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("This is a Square Shape");
	}

	@Override
	public double area(float ...length) {
		// TODO Auto-generated method stub
		return length[0]*2;
	}
	
}


class Triangle implements Shape {

	@Override
	public void draw() {
		System.out.println("This is a Triangle Shape");
	}

	@Override
	public double area(float... sides) {
		// TODO Auto-generated method stub
		return (sides[0]*sides[0])/2;
	}
	
}


