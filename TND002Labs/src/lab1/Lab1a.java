package lab1;

public class Lab1a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] da1 = new double[] {1.0,2.0,3.0};
		double[] da2 = new double[] {0.0,-0.5,-2.0};
		double[] resultAdd = addition(da1, da2);
		double[] resultSub = subtraction(da1, da2);
		printVector(da1);
		printVector(da2);
		printVector(resultAdd);
		printVector(resultSub);
	}

	
	public static double[] addition(double[] arg1, double[] arg2) {
		double[] result = new double[3];
		for (int i = 0; i < arg1.length; i++) {
			result[i] = arg1[i] + arg2[i];
		}
		
		return result;
	}
	public static double[] subtraction(double[] arg1, double[] arg2) {
		double[] result = new double[3];
		for (int i = 0; i < arg1.length; i++) {
			result[i] = arg1[i] - arg2[i];
		}
		
		return result;
	}
	public static void printVector(double[] arg1) {
		//String formatedArray = "Vector = (" + arg1[0] + ", " + arg1[1] + ", " + arg1[2] + ")";
		String formatedArray = new String("Vector = (" + arg1[0] + ", " + arg1[1] + ", " + arg1[2] + ")\n");
		System.out.println(formatedArray);
	}
}
