package complete6;

public class Rectangle extends Shape {
	Rectangle(){
		thePoints = new Point[4];
		thePoints[0]=null; 
		thePoints[1]=null; 
		thePoints[2]=null; 
		thePoints[3]=null;
	}
	public void setNormal(double i1, double i2, double i3) {
		area = Math.sqrt(i1*i1+i2*i2+i3*i3);
		nX = i1/area; nY = i2/area; nZ = i3/area;
	}
	public String toString() {
		return "The rectangle " + super.toString();
	}
	
	
}
