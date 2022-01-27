package lab1;

public class Lab1b {

	public static void main(String[] args) {
		System.out.println("Write out the content ofvdef");
		System.out.println(Vector.vdef.toString());
		System.out.println("Create the vectorv1 using the default constructor and write out its content.");
		Vector v1 = new Vector();
		System.out.println(v1.toString());
		System.out.println("hange the coordinates of the default vectorvdefto (1.0,2.0,3.0), use the methodsetToDefault()ofv1and write out the content ofv1.");
		Vector.setDefault(new Vector(1.0, 2.0, 3.0));
		System.out.println(Vector.vdef.toString());
		v1.setToDefault();
		System.out.println(v1.toString());
		System.out.println("Create the vectorv2with the coordinates (1.0,1.0,2.0) and write out its content.");
		Vector v2 = new Vector(1.0, 1.0, 2.0);
		System.out.println(v2.toString());
		System.out.println("Write out the string ”Length:  ” followed by the length ofv1");
		System.out.println("Length: " + v1.length());
		System.out.println("Initialize the matrix m1 with the elements ((1.0,0.0,0.0), (0.0,1.0,0.0), (0.0,0.0,1.0)),and write out the result of calling the method matrixMult(m1) ofv1.");
		double[][] matrix1 = {{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}};
		System.out.println(v1.matrixMult(matrix1));
		System.out.println("Initialize the matrix m2 with the elements ((1.0,0.0),  (0.0,1.0)),  and write out theresult of calling the method matrixMult(m2) ofv1.");
		double[][] matrix2 = {{1.0, 0.0},{0.0, 1.0}};
		System.out.println(v1.matrixMult(matrix2));
		System.out.println("Initialize the matrix m3 with the elements ((0.0,1.0,0.0), (1.0,0.0,0.0), (0.0,0.0,1.0)),and write out the result of calling the method matrixMult(m3) ofv1.");
		double[][] matrix3 = {{0.0, 1.0, 0.0},{1.0, 0.0, 0.0}, {0.0, 0.0, 1.0}};
		System.out.println(v1.matrixMult(matrix3));
		System.out.println("Write the result of addingv1andv2to the console.");
		System.out.println(Vector.plus(v1, v2));
		System.out.println("Write the result of subtractingv2fromv1to the console.");
		System.out.println(v1.minus(v2));
		System.out.println("Write the result of 2*v1to the console.");
		System.out.println(v1.mult(2));
		System.out.println("Write the result of the scalar product betweenv1andv2to the console.");
		System.out.println(v1.mult(v2));
		System.out.println("Write the result of the length comparison ofv1andv2to the console.");
		System.out.println(v1.compareTo(v2));
		System.out.println("Normalizev1andv2and write the scalar products of (a)v1andv2and (b)v2withitself to the console.");
		v1.norm();
		v2.norm();
		System.out.println(v1.toString());
		System.out.println(v2.toString());
		System.out.println(v1.mult(v2));
		System.out.println(v2.mult(v2));
		
	}
}