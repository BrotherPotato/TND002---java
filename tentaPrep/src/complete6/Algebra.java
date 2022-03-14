package complete6;

public class Algebra {
	
	public static void computeNormal(Shape inS) {
		Point p1, p2, p3;		
		double vx1, vx2, vy1, vy2 , vz1, vz2; 
		p1 = inS.getPoint(); p2 = inS.getPoint(); p3 = inS.getPoint();
		if (p1!=null || p2!=null || p3!=null) {	
			vx1 = p2.getX() - p1.getX(); vy1 = p2.getY() - p1.getY(); vz1 = p2.getZ() - p1.getZ();
			vx2 = p3.getX() - p2.getX(); vy2 = p3.getY() - p2.getY(); vz2 = p3.getZ() - p2.getZ();		
			inS.setNormal(vy1*vz2-vz1*vy2, vz1*vx2-vx1*vz2, vx1*vy2-vx2*vy1);
		}
	}
	
	public static Point createPoint(double d1, double d2, double d3) {
		return new Point(d1,d2,d3);
	}
}
