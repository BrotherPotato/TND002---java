package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayGame {

	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int size;
		String input;
		
		try {
			System.out.print("Enter a word size: ");
			input = b.readLine();
			size = Integer.valueOf(input);
		} catch (NumberFormatException ignore) {
			size = 5;
		}
		
		System.out.println(size);
		
		Dictionary dict = new Dictionary(size);
		
		String filePath = System.getProperty("user.dir");
		System.out.println(filePath);
		
		
		
		int tries = 0;
		do {
			System.out.print("Input: ");
			try {
				input = b.readLine();

				if(input.length() == size) {
					input = input.toUpperCase();
					String[] letters = input.split("");

					System.out.println(letters[2]);
					
					tries++;
				}

			} catch (IOException ignore) {
				System.out.println("Enter a 5 letter word");
			}
		} while(tries < 6);

	}

}
