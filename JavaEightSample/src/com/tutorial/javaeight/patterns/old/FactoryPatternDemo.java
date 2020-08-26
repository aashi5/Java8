package com.tutorial.javaeight.patterns.old;

import java.util.HashMap;
import java.util.Map;

import com.tutorial.javaeight.pattern.Circle;
import com.tutorial.javaeight.pattern.Shape;
import com.tutorial.javaeight.pattern.ShapeType;
import com.tutorial.javaeight.pattern.Square;
import com.tutorial.javaeight.pattern.Triangle;

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
	

	/**
	 * get the shape object based on the shape type passed.
	 */
	public Shape getShape(ShapeType shapeName){	
	
		/*
		 * Shape shape = null; switch(shapeName) { case CIRCLE: shape =new Circle();
		 * break; case SQUARE: shape=new Square(); break;
		 * 
		 * case TRIANGLE: shape=new Triangle(); break; default: break; }
		 */
		Shape shape=shapeMap.get(shapeName);
		if(shape!=null) {
			return shape;
		}
		throw new  IllegalArgumentException("No such shape exists");
		
	}
}

	



