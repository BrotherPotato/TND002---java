package complete6;

public class Point {

	private double x, y, z;
	public Point(double ix, double iy, double iz) {
		setX(ix); setY(iy); setZ(iz);
	}
	
	public double getX() {return x;}
	public double getY() {return y;}
	public double getZ() {return z;}
	
	public void setX(double ix) {x = ix;}
	public void setY(double iy) {y = iy;}
	public void setZ(double iz) {z = iz;}	
	
	public String toString() {
		return "Point = ( " + x + ", " + y + ", " + z + " )"; 
	}
}
