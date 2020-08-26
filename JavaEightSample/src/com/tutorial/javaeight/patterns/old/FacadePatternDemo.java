package com.tutorial.javaeight.patterns.old;

import com.tutorial.javaeight.pattern.ShapeType;

public class FacadePatternDemo {
	public static void main(String ...args) {
		ShapeFacade facade = new ShapeFacadeImpl();
		facade.drawAllShapes();
	}
}

/**
 * the client accessing the facade need not know about the available shapes or how it is drawn.
 * @author Ashwini
 *
 */
interface ShapeFacade{
	void drawAllShapes();
}

/**
 * 
 * @author Ashwini
 *
 */
class ShapeFacadeImpl implements ShapeFacade{

	/**
	 * 
	 */
	@Override
	public void drawAllShapes() {
		IShapeFactory factory = new ShapeFactory();
		for(ShapeType shape:ShapeType.values()) {
			factory.getShape(shape).draw();	
		}
	
	}
	
}