package lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab2 {
	public static void main(String[] args) throws IOException {
		String filePath = System.getProperty("user.dir");
		System.out.println(filePath);
		String input;
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		File newFile;
		
		int tries = 0;
		do {
			if(tries >= 3) {
				System.exit(0);
			}
			System.out.print("Input: ");
			input = b.readLine();
			input = filePath + "\\src\\\\" + input;
			newFile = new File(input);
			tries++;
		} while(!newFile.exists());
		
		System.out.println(newFile.getAbsolutePath());
		String allLines = new String();
		String line;
		BufferedReader freader = new BufferedReader(new FileReader(newFile));
		// read all lines concat to one string
		while ((line = freader.readLine()) != null) {
			if(allLines.length() == 0) {
				allLines = line;
			} else {
				allLines = allLines + " " + line;
			}
		}
		// check if allLLines exist
		if(allLines.isEmpty()) {
			System.out.println("Could not read text in file");
		} else {	// if they do split string to array
			Dictionary theDictionary = new Dictionary();
			String[] splitted = allLines.split(" +");
			// check a word in the array
			System.out.print("Input: ");
			input = b.readLine();
			int count = 0;
			for (int i = 0; i < splitted.length; i++) {
				if(input.equals(splitted[i])) {
					count++;
				}	
			}
			System.out.println(count);
			// use a try catch to only add strings to the Dictionary instance
			for (int j = 0; j < splitted.length; j++) {
				try {
					Integer.valueOf(splitted[j]);
				} catch (NumberFormatException ignore) {
					System.out.println(theDictionary.addString(splitted[j]));
				}
			}
			// check the code
			System.out.println("\nOriginal");
			System.out.println(theDictionary.toString());

			System.out.println(theDictionary.sortList(Word.BYCOUNTS));
			System.out.println(theDictionary.toString());
			
			System.out.println(theDictionary.sortList(Word.BYNAME));
			System.out.println(theDictionary.toString());
			
			System.out.println(theDictionary.sortList(Word.ORIGINAL));
			System.out.println(theDictionary.toString());
			// 
			File resultFile = new File("result.txt");
			BufferedWriter fwriter = new BufferedWriter(new FileWriter(resultFile));
			int index = 0;
			String wordString = theDictionary.returnWord(index);
			while(wordString != "end") {				
				fwriter.write(wordString);
				fwriter.newLine();
				index++;
				wordString = theDictionary.returnWord(index);
				/*
				fwriter.write(theDictionary.addString(wordString));
				fwriter.newLine();
				index++;
				wordString = theDictionary.returnWord(index);
				*/
			}
			fwriter.flush();
			fwriter.close();
		}
		b.close();
		freader.close();
	}
}
