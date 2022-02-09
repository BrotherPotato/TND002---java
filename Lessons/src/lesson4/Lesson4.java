package lesson4;

import lesson4.Geometry.Shape;

public class Lesson4 {

	public static void main(String[] args) {
		
		Geometry.Shape test = new Geometry.Shape(1.0, 1.0);
		System.out.println(test);
		test.setPosition(2.0, 2.0);
		System.out.println(test);
		System.out.println();
		
		Geometry myCircle = new Geometry();
		System.out.println(myCircle.createShape(Shape.CIRCLE, 1.0, 1.0));
		System.out.println(myCircle);
		System.out.println(myCircle.modifyCircle(2.0, 2.0, 2));
		System.out.println(myCircle);
		
		System.out.println();
		
		Geometry myRectangle = new Geometry();
		System.out.println(myRectangle.createShape(Shape.RECTANGLE, 1.0, 1.0));
		System.out.println(myRectangle);
		System.out.println(myRectangle.modifyRectangle(2.0, 2.0, 2.0, 2.0));
		System.out.println(myRectangle);
		
		System.out.println();
		
		Square mySquare = new Square(1.0,1.0);
		System.out.println(mySquare);
		mySquare.setPosition(2.0, 2.0);
		mySquare.setSize(2.0);
		System.out.println(mySquare);
	}

}
