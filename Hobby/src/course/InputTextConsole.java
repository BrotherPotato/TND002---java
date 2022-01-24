package course;

import java.util.Scanner;

public class InputTextConsole {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What is you name? ");
		String name = scanner.nextLine();
		
		System.out.println("Hello "+name);
	}
	
}
