package com.tutorial.javaeight.patterns.old;

import com.tutorial.javaeight.pattern.Shape;
import com.tutorial.javaeight.pattern.ShapeType;
import com.tutorial.javaeight.patterns.old.ShapeArea.ShapeAreaBuilder;

public class BuilderPatternDemo {

	
	public static void main(String ...args) {
		System.out.println("Building a square");
		ShapeAreaBuilder builder=
				new ShapeAreaBuilder(ShapeType.SQUARE).withSide(4);
		Shape square= builder.createShape();
		square.draw();
		System.out.println("Area of this square :"+square.area());
		
		builder= new ShapeAreaBuilder(ShapeType.CIRCLE).withHeight(9);
		Shape circle= builder.createShape();
		circle.draw();
		circle.area();
	
	}
}

/**
 * To demonstrate the Bulder pattern
 * 
 * The original object will only have private constructors.
 * The object will only have getter methods. 
 * 
 * @author Ashwini
 *
 */
class ShapeArea implements Shape {

	private long radius=0L;
	private long side=0L;
	private long height=0L;
	
	private boolean isTriangle;
	private boolean isSquare;
	private boolean isCircle;
	
	
	private ShapeArea(ShapeAreaBuilder builder) {
		super();
		this.radius = builder.radius;
		this.side = builder.side;
		this.height = builder.height;
		this.isTriangle = builder.isTriangle;
		this.isSquare = builder.isSquare;
		this.isCircle =builder.isCircle;
	}

	public long getRadius() {
		return radius;
	}

	public long getSide() {
		return side;
	}

	public long getHeight() {
		return height;
	}

	@Override
	public void draw() {
		System.out.println("This class is to calculate the area of a given shape.");
	}

	/**
	 * Calculate area based on type of shape and if the appropriate parameters are specified.
	 */
	@Override
	public double area() {
		if(isCircle && getRadius()>0) {
			return 3.14*getRadius();
		}else if(isSquare && getSide()>0) {
			return side*side;
		}else if(isTriangle && getSide()>0 && getHeight()>0) {
			return (getSide()*getHeight())/2;
		}
		System.out.println("Not enough paramters specified");
		// TODO Auto-generated method stub
		return 0;
	}

	


	 public static class ShapeAreaBuilder {
		
		private long radius=0L;
		private long side=0L;
		private long height=0L;
		
		private boolean isTriangle;
		private boolean isSquare;
		private boolean isCircle;
		
		/**
		 * Determine the type of Shape.
		 * @param shapeType
		 */
		public ShapeAreaBuilder(ShapeType shapeType) {
			if(ShapeType.CIRCLE.equals(shapeType)){
				isCircle=true;
			}else if(ShapeType.SQUARE.equals(shapeType)){
				isSquare=true;
			}else if(ShapeType.TRIANGLE.equals(shapeType)) {
				isTriangle=true;
			}
		}

		// set the other properties based on the type of shape to calculate the area.
		public ShapeAreaBuilder withRadius(int radius) {
			this.radius=radius;
			return this;
		}
		
		public ShapeAreaBuilder withHeight(long height) {
			this.height=height;
			return this;
		}
		
		public ShapeAreaBuilder withSide(long side) {
			this.side =side;
			return this;
					
		}
		
			public ShapeArea createShape() {
			return new ShapeArea(this);
		}
			

	}

}
