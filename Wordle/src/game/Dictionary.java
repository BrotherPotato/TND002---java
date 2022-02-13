package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Dictionary {
	public ArrayList<String> listOfWords;
	public String solution;
	public int size = 5;
	
	public Dictionary(int size) throws IOException {
		this.listOfWords = new ArrayList<String>();
		this.size = size;
		File newFile = new File("words_size_" + size + ".txt");
		if(newFile.exists()) {
			System.out.println(newFile.getAbsolutePath());
			System.out.println("Found");
		} else {
			File dicFile = new File("words_alpha.txt");
			
			newFile.createNewFile();
			System.out.println(newFile.getAbsolutePath());
			System.out.println("Created");
			
			String line;
			
			BufferedReader freader = new BufferedReader(new FileReader(dicFile));
			BufferedWriter fwriter = new BufferedWriter(new FileWriter(newFile));
			// read all lines concat to one string
			while ((line = freader.readLine()) != null) {
				if(line.length() == size) {
					line = line.toUpperCase();
					fwriter.write(line);
					fwriter.newLine();
					//listOfWords.add(line);
				}
			}
			
			fwriter.flush();
			fwriter.close();
			freader.close();
			
		}
		 
		String line;
		BufferedReader freader = new BufferedReader(new FileReader(newFile));
		while ((line = freader.readLine()) != null) {
			listOfWords.add(line);
		}
		
		int indexNumOfSolution = ThreadLocalRandom.current().nextInt(0, listOfWords.size());
		
		solution = listOfWords.get(indexNumOfSolution);
		
		System.out.println("Solution is: " + solution);
		
		freader.close();
	}
	
	
	public int[] EnterWord(String word) {
		int[] charHints = new int[this.size];
		for (int i = 0; i < charHints.length; i++) {
			charHints[i] = 0;
		}
		
		String[] solutionLetters = solution.split("");
		String[] wordLetters = word.split("");
		
		for (int i = 0; i < wordLetters.length; i++) {
			for (int j = 0; j < solutionLetters.length; j++) {
				if(solutionLetters[j].equals(wordLetters[i])) {
					if(i == j) {
						charHints[i] = 2;
						//System.out.println("one correct");
					} else {
						if(charHints[i] < 1) {
							charHints[i] = 1;
							//System.out.println("one close");
						}
					}
				}
			}
		}
		
		return charHints;
	}
	
	public boolean CorrectAnswer(String word) {
		if(solution.equals(word)) {
			return true;
		} else {
			return false;
		}
	}
}
