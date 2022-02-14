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
			int freq;
			
			BufferedReader freader = new BufferedReader(new FileReader(dicFile));
			BufferedWriter fwriter = new BufferedWriter(new FileWriter(newFile));
			// read all lines concat to one string
			freader.readLine();
			while ((line = freader.readLine()) != null) {
				lineData = line.split(" +");
				word = lineData[1];
				//freq = lineData[3];
				try {
					freq = Integer.valueOf(lineData[3]);
				} catch (NumberFormatException ignore) {
					System.out.println("Error reading file");
					freq = 0;
				}
				
				if(line.length() == size) {
					line = line.toUpperCase();
					fwriter.write(word);
					fwriter.write("\t");
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
		
		int indexNumOfSolution = ThreadLocalRandom.current().nextInt(0, listOfWords.size());
		
		solution = listOfWords.get(indexNumOfSolution).getWord();
		
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
