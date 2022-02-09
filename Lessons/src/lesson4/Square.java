package lesson4;

//import lesson4.Geometry.Shape;

public class Square extends Geometry.Shape {

	private double length, area;
	public Square(double d1, double d2) {
		super(d1,d2); name = "Square"; length = 1.0; computeArea();
	}
	
	public void computeArea() {area = length*length;}
	public void setSize(double d) {length = d;}
	public String toString() {computeArea();
	return name + ": " + super.toString() + String.format(", area : %3.1f", area);}
}

