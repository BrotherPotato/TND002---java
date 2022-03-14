package complete6;

public abstract class Shape implements AlgebraSupport {
	private int pointCounter;
	protected Point[] thePoints;
	protected double area, nX, nY, nZ;
	Shape(){
		pointCounter = 0;
	}
	public Point getPoint() {
		Point dummy = thePoints[pointCounter];
		pointCounter = pointCounter + 1;
		if (pointCounter == thePoints.length) pointCounter = 0;
		return dummy;
	}
	public String setPoint(Point in) {
		boolean equal = false;
		for (int j=0; j < thePoints.length; j++) {
			if (comparePoints(in,thePoints[j])) equal = true;
			if (thePoints[j]==null && !equal) {
				thePoints[j]=in; return "Added";
			}
		}
		return "not added";
	}
	public boolean comparePoints(Point p1, Point p2) {
		if (p1 == null || p2 == null) return false;
		else if (p1.getX()==p2.getX() && p1.getY() == p2.getY() && p1.getZ()==p2.getZ()) return true;
		else return false;
	}
	public String toString() {
		return String.format("has the area %4.2f and normal (%4.2f,%4.2f,%4.2f).", area, nX, nY, nZ);
	}
}
