package course;

import java.util.Scanner;

import java.util.Random;

public class Matte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* input
		double x;
		double y;
		double z;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter side x: ");
		x = scanner.nextDouble();
		System.out.println("Enter side y: ");
		y = scanner.nextDouble();
		
		//z = Math.sqrt((x*x)+(y*y));
		z = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		System.out.println("The hypotenuse is: "+ z);
		scanner.close();
		
		*/
		
		Random random = new Random();
		// no cap on the random
		//int x = random.nextInt();
		// random number between 0 and (input-1)
		//int x = random.nextInt(6);
		// random number between 1 and input
		//int x = random.nextInt(6)+1;
		// random value between 0 and 1
		//double y = random.nextDouble();
		// true or false
		boolean y = random.nextBoolean();
		
		System.out.println(y);

		/* Math.
		Math.max(x, y);
		Math.min(x, y);
		Math.abs(x);
		Math.sqrt(x + y);
		Math.round(x);
		Math.ceil(x);
		Math.floor(x);
		Math.max(x, y);
		Math.signum(x);
		Math.exp(x);
		Math.getExponent(x);
		Math.getExponent(x);
		Math.log(x);
		// returns the next value of x in the direction y
		Math.nextAfter(x, y);
		double p = Math.PI;
		*/
		
		/* String
		boolean same = name1.equals(name2);
		int result = name1.length();
		char result = name1.charAt(0);
		int result = name1.indexOf("B");
		boolean result = name1.isEmpty();
		String result = name1.toUpperCase();
		String result = name1.toLowerCase();
		String result = name1.trim();
		String result = name1.replace(oldChar, newChar);
		*/
		
		// wrapper class - provides a way to use primitive data types as reference data types, useful methods, can be used with collections (ex. ArrayList)
		
		/*
		primitive		wrapper
		------------------------
		boolean			Boolean
		char			Character
		int				Integer
		double			Double
		*/
		
		Boolean a = true;
		Character b = '@';
		Integer c = 123;
		Double d = 3.14;
		String e = "Fish";
		
		//a.
		
		if(a == true) {
			
		}
		
		// cant change pi
		final double PI = 3.14159;
		System.out.println(PI);
		
	}

}
