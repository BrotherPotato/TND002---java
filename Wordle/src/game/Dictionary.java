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
	public String[] boardState;
	public String[][] evaluations; 
	public int rowIndex;
	
	public Dictionary(int size) throws IOException {
		//this.listOfWords = new ArrayList<String>();
		this.listOfWords = new ArrayList<Word>();
		this.size = size;
		this.boardState = new String[6];
		this.evaluations = new String[6][size]; 
		this.rowIndex = 0;
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
		int maxIndex = (int) Math.floor(this.listOfWords.size() * 0.70);
		int indexNumOfSolution = ThreadLocalRandom.current().nextInt(0, maxIndex);
		//int indexNumOfSolution = 0;
		
		//solution = this.listOfWords.get(indexNumOfSolution).getWord();
		solution = "CONDO";
		System.out.println("Solution is: " + solution);
		
		freader.close();
	}
	
	
	public int[] EnterWord(String word) {
		int[] charHints = new int[this.size];
		for (int i = 0; i < charHints.length; i++) {
			charHints[i] = 0;
		}
//		
//		String[] solutionLetters = solution.split("");
//		//int[] solutionLettersAmount = charCounter(solutionLetters);
		String[] wordLetters = word.split("");
//		//int[] wordLettersAmount = charCounter(wordLetters);
//		boolean[] oneAssigned = new boolean[wordLetters.length];
//		
//		for (int i = 0; i < wordLetters.length; i++) {
//			for (int j = 0; j < solutionLetters.length; j++) {
//				if(solutionLetters[j].equals(wordLetters[i])) {
//					if(i == j) {
//						charHints[i] = 2;
//						break;
//						//System.out.println("one correct");
//					} else if(charHints[i] < 1) {
//						
//						
//						
//						charHints[i] = 1;
//						//System.out.println("one close");
//						break;
//					}
//				}	
//			}
//		}
		//////////////////////////////////////////
		this.boardState[this.rowIndex] = word;
//		
//		for (int i = 0; i < wordLetters.length; i++) {
//			this.evaluations[this.rowIndex][i] = evaluation(wordLetters[i], i);
//		}
//		
		
		evaluations[this.rowIndex] = evaluation(word);
		
		for (int i = 0; i < evaluations[this.rowIndex].length; i++) {
			if(evaluations[this.rowIndex][i] == "correct") {
				charHints[i] = 2;
			} else if(evaluations[this.rowIndex][i] == "present") {
				charHints[i] = 1;
			}
		}
		
		
		
		
		
		this.rowIndex++;
		return charHints;
	}
	
//	public String evaluation(String letter, int location) {
//		String[] solutionLetters = solution.split("");
//		for (int i = 0; i < solutionLetters.length; i++) {
//			if(letter.equals(solutionLetters[i])) {
//				if(i == location) {
//					return "correct";
//				} else {
//					return "present";
//				}
//			}
//		}
//		return "absent";
//	}
	
	public String[] evaluation(String word) {
		String[] solutionLetters = solution.split("");
		String[] solution = new String[solutionLetters.length];
		String[] testLetters = word.split("");
		
		//int[] amountSolutionLetters = charCounter(solutionLetters);
		//int[] amountTestLetters = charCounter(solutionLetters);
		
		boolean[] letterDone = new boolean[solutionLetters.length];
		boolean[] solutionLetterDone = new boolean[solutionLetters.length];
		
		//ArrayList <String> addedLetters = new ArrayList<String>();
		for (int i = 0; i < testLetters.length; i++) {
				if(testLetters[i].equals(solutionLetters[i])) {
						solution[i] = "correct";
						letterDone[i] = true;
						solutionLetterDone[i] = true;
				}
		}
		for (int i = 0; i < testLetters.length; i++) {
			if(letterDone[i] == false) {
				for (int j = 0; j < solutionLetters.length; j++) {
					if(testLetters[i].equals(solutionLetters[j]) && solutionLetterDone[j] == false) {
						solution[i] = "present";
						letterDone[i] = true;
						solutionLetterDone[j] = true;
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < testLetters.length; i++) {
			if(letterDone[i] == false) {
				solution[i] = "absent";
			}
		}
		
		
		return solution;
	}
	
	public boolean CorrectAnswer(String word) {
		if(solution.equals(word)) {
			for (int i = 0; i < boardState.length; i++) {
				System.out.println(this.boardState[i]);
			}
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public int[] charCounter(String[] letters) {
		int[] solutionLetterAmount = new int[letters.length];
		int counter;
		
		for (int i = 0; i < letters.length; i++) {
			counter = 0;
			for (int j = 0; j < letters.length; j++) {
				if(letters[i].equals(letters[j]) && i != j) {
					counter++;
				}
			}
			solutionLetterAmount[i] = counter;
		}
		
		return solutionLetterAmount;
	}
}
