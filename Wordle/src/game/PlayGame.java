package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayGame {

	public static void main(String[] args) throws IOException {
		
		Dictionary dict = new Dictionary(5);
		
		String filePath = System.getProperty("user.dir");
		System.out.println(filePath);
		String input;
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		String targetWord = "";
		
		int tries = 0;
		do {
			System.out.print("Input: ");
			try {
				input = b.readLine();

				if(input.length() == 5) {
					input = input.toUpperCase();
					String[] letters = input.split("");

					
					
					tries++;
				}

			} catch (IOException ignore) {
				System.out.println("Enter a 5 letter word");
			}
		} while(tries < 6);

	}

}
