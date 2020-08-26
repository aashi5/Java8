package com.tutorial.javaeight.pattern.java8;

import java.util.Arrays;

import com.tutorial.javaeight.pattern.ShapeType;

public class FacadePatternDemo {

	public static void main(String ...args) {
		ShapeFacade facadeDemo = new ShapeFacadeImpl();
		facadeDemo.drawAllShapes();
	}
}


interface ShapeFacade{
	void drawAllShapes();
}

class ShapeFacadeImpl implements ShapeFacade{

	
	@Override
	public void drawAllShapes() {
		ShapeFactory8 factory = new ShapeFactory8();
		try {
		Arrays.asList(ShapeType.values()).forEach(shapetype->
		{
			if(factory.getShape(shapetype).isPresent()) {
				factory.getShape(shapetype).get().draw();
			}
		});
		}catch(IllegalArgumentException ex) {
			System.out.println("There is shape of such type. ");
		}
				
	}
	
}