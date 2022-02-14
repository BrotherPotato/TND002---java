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
			size = Integer.parseInt(input);
		} catch (NumberFormatException ignore) {
			size = 5;
		}
		
		System.out.println(size);
		
		Dictionary dict = new Dictionary(size);
		
		//String filePath = System.getProperty("user.dir");
		//System.out.println(filePath);
		
		//System.out.println(dict.listOfWords.get(dict.listOfWords.size() - 1));
		
		
		int tries = 0;
		do {
			System.out.print("Row nr:" + tries + " input: ");
			try {
				input = b.readLine();

				if(input.length() == size) {
					input = input.toUpperCase();
					
					int[] results = dict.EnterWord(input);
					for (int i = 0; i < results.length - 1; i++) {
						System.out.print(results[i] + " : ");
					}
					System.out.println(results[results.length - 1]);

					if(dict.CorrectAnswer(input)) {
						System.out.println("Congratulations, you did it in " + (tries + 1) + " tries!!");
						break;
					}
					tries++;
				} else {
					System.out.println("Enter a 5 letter word");
				}

			} catch (IOException ignore) {
				System.out.println("Failed to read input");
			}
		} while(tries < 6);

	}

}
