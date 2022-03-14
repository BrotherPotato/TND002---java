package complete6;

public class Triangle extends Shape {
	Triangle(){
		thePoints = new Point[3];
		thePoints[0]=null; thePoints[1]=null; thePoints[2]=null;
	}
	public void setNormal(double i1, double i2, double i3) {
		area = Math.sqrt(i1*i1+i2*i2+i3*i3)/2;
		nX = i1/(2.0*area); nY = i2/(2.0*area); nZ = i3/(2.0*area);
	}
	public String toString() {
		return "The triangle " + super.toString();
	}
}
