package lesson4;

public class Geometry {
	
	private Shape theShape;
	
	public Geometry() {theShape = null;}
	
	public String createShape(int a, double d1, double d2) {
		
		if (a==Shape.RECTANGLE) {theShape = new Rectangle(d1,d2); return theShape.getName();}
		else if (a==Shape.CIRCLE) {theShape = new Circle(d1,d2); return theShape.getName();} 	
		return "No shape created";
	}

	public String modifyCircle(double xp, double yp, double r) {
		if (theShape instanceof Circle) {
			Circle theCircle = (Circle) theShape;
			theCircle.setSize(r); theCircle.setPosition(xp, yp);
			return "Worked";
		}
		else return "Did not work";
	}
	
	public String modifyRectangle(double xp, double yp, double xl, double yl) {
		if (theShape instanceof Rectangle) {
			Rectangle theRectangle = (Rectangle) theShape;
			theRectangle.setSize(xl,yl); theRectangle.setPosition(xp, yp);
			return "Worked";
		}
		else return "Did not work";
	}
	
	public Shape getShape() {
		return theShape;
	}
	public String otherShape(Shape arg) {
		theShape = arg; return arg.getName();
	}
	
	public String toString() {
		if (theShape == null) return "No shape attached";
		else return theShape.getName() + ": " + theShape.toString();		
	}
	
	protected static class Shape{ // making it static allows us to extend it by other classes
		private double xPos, yPos;
		protected String name;
		public static final int RECTANGLE = 1, CIRCLE = 2;
		
		public Shape(double a1, double a2) {setPosition(a1, a2);}
		
		private String getName() {return name;}
		
		public void setPosition(double x1, double x2) {xPos = x1; yPos = x2;}
		
		public String toString() {
			return String.format("Position: (%3.1f,%3.1f)", xPos, yPos);
		}		
	}
	
	private class Rectangle extends Shape {
		private double xLen, yLen, area;
		public Rectangle(double d1, double d2) {super(d1,d2); name = "Rectangle"; xLen = 1.0; yLen = 1.0; computeArea();}
		public void setSize(double d1, double d2) {xLen = d1; yLen = d2;}
		public void computeArea() {area = xLen*yLen;}
		public String toString() {computeArea();
			return super.toString() + String.format(", area : %3.1f", area);}
	}
	
	private class Circle extends Shape {
		private double radius, area;
		public Circle(double d1, double d2) {super(d1,d2); name = "Circle"; radius = 1.0; computeArea();}
		public void setSize(double d) {radius = d;}
		public void computeArea() {area = Math.PI*radius*radius;}
		public String toString() {computeArea();
		return super.toString() + String.format(", area : %3.1f", area);}
	}
}
