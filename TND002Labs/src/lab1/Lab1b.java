package lab1;

public class Lab1b {

	public static void main(String[] args) {
		/*
		Vector v1 = new Vector();
		System.out.println(v.toString());
		Vector v2 = new Vector(1.0, 0.5, -2.0);
		System.out.println(v2.toString());
		Vector v3 = new Vector(-3.7, 5.5, 10);
		System.out.println(v3.toString());
		Vector v4 = Vector.plus(v3,v2);
		System.out.println(v4.toString());
		System.out.println(Vector.vdef.toString());
		Vector.setDefault(v3);
		*/
		
		System.out.println(Vector.vdef.toString());
		Vector v1 = new Vector();
		System.out.println(v1.toString());
		Vector.setDefault(new Vector(1.0, 2.0, 3.0));
		System.out.println(Vector.vdef.toString());
		v1.setToDefault();
		System.out.println(v1.toString());
		Vector v2 = new Vector(1.0, 1.0, 2.0);
		System.out.println(v2.toString());
		System.out.println("Length: " + v1.length());
		double[][] matrix1 = {{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}};
		System.out.println(v1.matrixMult(matrix1));
		double[][] matrix2 = {{1.0, 0.0},{0.0, 1.0}};
		System.out.println(v2.matrixMult(matrix2));
		double[][] matrix3 = {{0.0, 1.0, 0.0},{1.0, 0.0, 0.0}, {0.0, 0.0, 1.0}};
		System.out.println(v1.matrixMult(matrix3));
		System.out.println(Vector.plus(v1, v2));
		System.out.println(v1.minus(v2));
		System.out.println(v1.mult(2));
		System.out.println(v1.mult(v2));
		System.out.println(v1.compareTo(v2));
		v1.norm();
		v2.norm();
		System.out.println(v1.toString());
		System.out.println(v2.toString());
		System.out.println(v1.mult(v2));
		System.out.println(v2.mult(v2));
		// ehllo
	}

}