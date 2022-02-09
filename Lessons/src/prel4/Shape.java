package prel4;

public class Shape {
	private double xPos, yPos;
	
	public Shape(double a1, double a2) {setPosition(a1, a2);}
	
	public void setPosition(double x1, double x2) {xPos = x1; yPos = x2;}
	
	public String toString() {
		return String.format("Position: (%3.1f,%3.1f)", xPos, yPos);
	}
	
}
