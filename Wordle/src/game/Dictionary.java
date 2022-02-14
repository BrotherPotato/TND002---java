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
	//public ArrayList<String> listOfWords;
	public ArrayList<Word> listOfWords;
	public String solution;
	public int size = 5;
	
	public Dictionary(int size) throws IOException {
		//this.listOfWords = new ArrayList<String>();
		this.listOfWords = new ArrayList<Word>();
		this.size = size;
		File newFile = new File("words_size_" + size + ".txt");
		if(newFile.exists()) {
			System.out.println(newFile.getAbsolutePath());
			System.out.println("Found");
		} else {
			//File dicFile = new File("words_alpha.txt");
			File dicFile = new File("lemmas_60k.txt");
			
			newFile.createNewFile();
			System.out.println(newFile.getAbsolutePath());
			System.out.println("Created");
			
			String line;
			String lineData[] = new String[25];
			String word;
			String freq;
			
			BufferedReader freader = new BufferedReader(new FileReader(dicFile));
			BufferedWriter fwriter = new BufferedWriter(new FileWriter(newFile));
			// read all lines concat to one string
			freader.readLine();
			while ((line = freader.readLine()) != null) {
				lineData = line.split(" +");
				word = lineData[1];
				//System.out.println(word);
				//freq = lineData[3];
				
				if(word.length() == size) {
					word = word.toUpperCase();
					//System.out.println(word);
					fwriter.write(word);
					fwriter.write("    ");
					freq = lineData[3];
//					try {
//						System.out.println(lineData[3]);
//						freq = Integer.parseInt(lineData[3]);
//						System.out.println(freq);
//					} catch (NumberFormatException ignore) {
//						System.out.println("Error reading file");
//						freq = 0;
//					}
					
					fwriter.write(freq);
					fwriter.newLine();
					//listOfWords.add(line);
				}
			}
			
			fwriter.flush();
			fwriter.close();
			freader.close();
			
		}
		 
		String lineRead;
		String[] lineReadData = new String[2];
		int readFreq;
		BufferedReader freader = new BufferedReader(new FileReader(newFile));
		while ((lineRead = freader.readLine()) != null) {
			//System.out.println(lineRead);
			lineReadData = lineRead.split(" +");
			try {
				readFreq = Integer.valueOf(lineReadData[1]);
			} catch (NumberFormatException ignore) {
				System.out.println("Error reading file");
				readFreq = 0;
			}
			Word newWord = new Word(lineReadData[0], readFreq);
			this.listOfWords.add(newWord); 
		}
		
		int indexNumOfSolution = ThreadLocalRandom.current().nextInt(0, this.listOfWords.size());
		//int indexNumOfSolution = 0;
		
		solution = this.listOfWords.get(indexNumOfSolution).getWord();
		
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
						break;
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
