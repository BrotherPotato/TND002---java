package prel4;

public class Circle extends Shape {

	private double radius, area;
	public Circle(double d1, double d2) {super(d1,d2);radius = 1.0; computeArea();}
	public void setSize(double r) {radius = r;computeArea();}
	public void computeArea() {area = Math.PI*radius*radius;}
	public String toString() {
		return "Circle: " + super.toString() + String.format(", area = %3.1f", area);
	}
}
