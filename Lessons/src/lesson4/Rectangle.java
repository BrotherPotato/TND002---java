package lesson4;

public class Rectangle extends Shape {

	private double xLen, yLen, area;
	public Rectangle(double a1, double a2) {super(a1,a2);xLen=1.0;yLen=1.0; computeArea();}
	public void setSize(double d1, double d2) {xLen = d1; yLen = d2;computeArea();}
	public void computeArea() {area = xLen*yLen;}
	public String toString() {
		return "Rectangle: " + super.toString() + String.format(", area = %3.1f", area);
	}	
}
