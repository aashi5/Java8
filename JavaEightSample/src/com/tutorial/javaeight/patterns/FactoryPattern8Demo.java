package com.tutorial.javaeight.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


/**
 * Factory Pattern sample implementation prior to java 8 
 * @author Ashwini
 *
 */
	

public class FactoryPattern8Demo {

	public static void main(String...args) {
		ShapeFactory8 factory = new ShapeFactory8();
		Shape square= factory.getShape("square");
		square.draw();
		
		
		// adding a new Shape type 
		ShapeFactory8.registerSupplier("special",SpecialSupplier::new);
		Shape shapeDemo =  ((ShapeFactory8) factory).getShape("special");
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
	final static Map<String, Supplier<Shape>> shapeMap =
				new  HashMap<>();
	static {
		
		shapeMap.put("circle",Circle::new);
		shapeMap.put("square",Square::new);
		shapeMap.put("triangle",Triangle::new);
	}
	
	/**
	 * dynamically add new shape implementations to the map.
	 * @param type
	 * @param shapeClass
	 */
	public static void registerSupplier(String type , Supplier<Shape> shapeClass) {
		shapeMap.put(type, shapeClass);
	}
	
	/**
	 * The getShape method returns the object reference of the factory for the given Shape type.
	 * @param shapeType
	 * @return
	 */
	public Shape getShape(String shapeType) {
		Supplier<Shape> shapeObj =shapeMap.get(shapeType);
		
		if(shapeObj!=null) {
			return shapeObj.get();
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
	public double area(float... params) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}


