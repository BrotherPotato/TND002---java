package complete6;

public class Exercise extends Algebra {

	public static void main(String[] args) {
		
		Rectangle theRectangle = new Rectangle();
		System.out.println(theRectangle.setPoint(createPoint(0.0,0.0,0.0)));
		System.out.println(theRectangle.setPoint(createPoint(0.0,0.0,0.0)));
		System.out.println(theRectangle.setPoint(createPoint(2.0,0.0,0.0)));
		System.out.println(theRectangle.setPoint(createPoint(2.0,2.0,0.0)));
		System.out.println(theRectangle.setPoint(createPoint(0.0,2.0,0.0)));
		computeNormal(theRectangle);
		System.out.println(theRectangle);
		
		Triangle theTriangle = new Triangle();
		System.out.println(theTriangle.setPoint(theRectangle.getPoint()));
		System.out.println(theTriangle.setPoint(theRectangle.getPoint()));
		System.out.println(theTriangle.setPoint(theRectangle.getPoint()));
		computeNormal(theTriangle);
		System.out.println(theTriangle);
	}

}
