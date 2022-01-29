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
		// TODO Auto-generated method stub
		/*
		File file = new File("TextSource.txt");
		System.out.println(file.getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
		*/
		String filePath = System.getProperty("user.dir");
		System.out.println(filePath);
		String input;
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Input: ");
		//input = b.readLine();
		//filePath = filePath + "\\" + input + ".txt";
		//System.out.println(filePath);
		File newFile;
		//newFile.createNewFile();
		int tries = 0;
		do {
			if(tries >= 3) {
				System.exit(0);
			}
			System.out.print("Input: ");
			input = b.readLine();
			input = filePath + "\\src\\" + input;
			newFile = new File(input);
			tries++;
		} while(!newFile.exists());
		System.out.println(newFile.getAbsolutePath());
		String allLines = new String();
		String line;
		BufferedReader freader = new BufferedReader(new FileReader(newFile));
		
		
		
		while ((line = freader.readLine())!= null) {
			//String line = freader.readLine();
			if(allLines.length() == 0) {
				allLines = line;
			} else {
				allLines = allLines + " " + line;
			}
		}
		
		if(allLines.isEmpty()) {
			System.out.println("Could not read text in file");
		} else {
			Dictionary theDictionary = new Dictionary();
			String[] splitted = allLines.split(" +");
			/*
			for (int i = 0; i < splitted.length; i++) {
				System.out.println(splitted[i]);
			}
			*/
			System.out.print("Input: ");
			input = b.readLine();
			int count = 0;
			for (int i = 0; i < splitted.length; i++) {
				if(input.equals(splitted[i])) {
					count++;
				}
				
			}
			System.out.println(count);
			for (int j = 0; j < splitted.length; j++) {
				try {
					Integer.valueOf(splitted[j]);
				} catch (NumberFormatException ierr) {
					//System.out.println(theDictionary.addString(splitted[j]));
					theDictionary.addString(splitted[j]);
				}
			}
			System.out.println("Original");
			System.out.println(theDictionary.toString());
			/*
			System.out.println("Original");
			theDictionary.sortList(Word.ORIGINAL);
			System.out.println(theDictionary.toString());
			*/

			System.out.println("Sort BYCOUNTS");
			theDictionary.sortList(Word.BYCOUNTS);
			System.out.println(theDictionary.toString());
			/*
			System.out.println("Original");
			theDictionary.sortList(Word.ORIGINAL);
			System.out.println(theDictionary.toString());
			*/
			System.out.println("Sort BYNAME");
			theDictionary.sortList(Word.BYNAME);
			System.out.println(theDictionary.toString());
			System.out.println("Original");
			theDictionary.sortList(Word.ORIGINAL);
			System.out.println(theDictionary.toString());
			
			File resultFile = new File("result.txt");
			BufferedWriter fwriter = new BufferedWriter(new FileWriter(resultFile)); ;
			int index = 0;
			String word = theDictionary.returnWord(index);
			while(word != "end") {
				//System.out.println(word.toString());
				fwriter.write(word.toString());
				fwriter.newLine();
				index++;
				word = theDictionary.returnWord(index);
			}
			//fwriter.write(theDictionary.toString());
			fwriter.flush();
			fwriter.close();
		}
		b.close();
		freader.close();
	}

}
