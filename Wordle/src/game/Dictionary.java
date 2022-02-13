package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
	public ArrayList<String> listOfWords;
	public String solution;
	
	public Dictionary(int size) throws IOException {
		this.listOfWords = new ArrayList<String>();
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
		
		freader.close();
	}
}
