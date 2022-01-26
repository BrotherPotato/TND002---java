package test;

import java.io.IOException;
import java.io.*;

/**
 * 
 * @author wiklu
 * @version 1.0
 * @since today
 *
 */

import java.util.*;

public class Name {

	public static final int ACONSTANT = 1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("Tsd\n");
		try {
			int number = 1/0;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		/*
		InputStreamReader consoleReader = new InputStreamReader(System.in);
		System.out.print("Input: ");
		int in = consoleReader.read();
		System.out.println(in);
		*/
		
		//InputStreamReader i = new InputStreamReader(System.in);
		//BufferedReader b = new BufferedReader(i);
		String in;
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			System.out.println("Input: ");
			in = b.readLine();
			System.out.println(in);
		} while(!in.equals("end"));
		b.close();
	}
	public void Vector() {}
	/**
	 * Adding two double
	 * <p>
	 * Long description
	 * @param r Input factor
	 * @return Result Vector
	 * </p>
	 */
	public int add(double r) {
		return 0;
	}

}
