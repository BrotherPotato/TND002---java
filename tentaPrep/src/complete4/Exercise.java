package complete4;
import java.io.*;
public class Exercise {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
		Complex result, newNumber; 
		String input, mathSymbol; 
		boolean test;
		
		do {
			result = getComplexNumber(myReader.readLine());
		} while(result==null);
		System.out.println("The number is : " + result);
		
		while (true) {			
			do {
				test = true;
				input = myReader.readLine();
				
				if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("=")) {
					test = false;
				}
			}
			while(test);
			
			if (input.equals("=")) break; 
			mathSymbol = input;
			
			do {newNumber = getComplexNumber(myReader.readLine());}
			while(newNumber==null);
			System.out.println("The number is : " + newNumber);
			
			if (mathSymbol.equals("*")) result = result.mult(newNumber);
			else if (mathSymbol.equals("/")) result = result.div(newNumber);
			else if (mathSymbol.equals("+")) result = result.add(newNumber);
			else result = result.subtract(newNumber);	
			System.out.println("The result is : " + result);
		}			
		myReader.close();
		
		System.out.println("The result is : " + result);
	}
		
	public static Complex getComplexNumber(String arg) {
		Complex theNumber=null; String[] inputField; double dummyR, dummyI; String[] dummyS;
		
		inputField = arg.split(" +");
		try {
			if (inputField[0].equals("+")) dummyR = Double.valueOf(inputField[1]);
			else dummyR = -Double.valueOf(inputField[1]);
			
			if (inputField[2].equals("+")) dummyI = Double.valueOf(inputField[4]);
			else dummyI = -Double.valueOf(inputField[4]);
			theNumber = new Complex(dummyR, dummyI);
		}catch (NumberFormatException iee) {}
		
		return theNumber;
	}
	
}
