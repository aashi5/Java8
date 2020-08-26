package com.tutorial.javaeight.pattern.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.tutorial.javaeight.pattern.Circle;
import com.tutorial.javaeight.pattern.Shape;
import com.tutorial.javaeight.pattern.ShapeType;
import com.tutorial.javaeight.pattern.Square;
import com.tutorial.javaeight.pattern.Triangle;

/**
 * Factory Pattern sample implementation prior to java 8 
 * @author Ashwini
 *
 */
	

public class FactoryPatternDemo {

	public static void main(String...args) {
		ShapeFactory8 factory = new ShapeFactory8();
		Shape square= factory.getShape(ShapeType.SQUARE).get();
		square.draw();
		
		
		// adding a new Shape type 
		ShapeFactory8.registerSupplier(ShapeType.SPECIAL,SpecialSupplier::new);
		Shape shapeDemo =  ((ShapeFactory8) factory).getShape(ShapeType.SPECIAL).get();
		shapeDemo.draw();
	}
}


/**
 * The factory will have a map with all the possible
 *  implementations of the factory interface with the Supplier 
 *  object using the new reference of java 8
 * @author Ashwini
 *
 */
class ShapeFactory8{
	final static Map<ShapeType, Supplier<Shape>> shapeMap =
				new  HashMap<>();
	static {
		
		shapeMap.put(ShapeType.CIRCLE,Circle::new);
		shapeMap.put(ShapeType.SQUARE,Square::new);
		shapeMap.put(ShapeType.TRIANGLE,Triangle::new);
		
	}
	
	/**
	 * dynamically add new shape implementations to the map.
	 * @param type
	 * @param shapeClass
	 */
	public static void registerSupplier(ShapeType type , Supplier<Shape> shapeClass) {
		shapeMap.put(type, shapeClass);
	}
	
	/**
	 * The getShape method returns the object reference of the factory for the given Shape type.
	 * @param shapeType
	 * @return
	 */
	public Optional<Shape> getShape(ShapeType shapeType) {
		Supplier<Shape> shapeObj =shapeMap.get(shapeType);
		
		if(shapeObj!=null) {
			return Optional.ofNullable(shapeObj.get());
		}
		throw new  IllegalArgumentException("No such shape exits");
		
	}
}


class SpecialSupplier implements Shape{

	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("This is a special shape");
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}


}


