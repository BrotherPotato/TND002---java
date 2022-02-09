package lesson4;

public class Start4 {

	public static void main(String[] args) {
				
		Rectangle myRectangle = new Rectangle(3.0,4.0);
		System.out.println(myRectangle);
		myRectangle.setSize(2.0, 1.0);
		System.out.println(myRectangle);
		
		System.out.println();
		
		Circle myCircle = new Circle(1.0,1.0);
		System.out.println(myCircle);
		myCircle.setSize(2.0);
		System.out.println(myCircle);
	}

}
