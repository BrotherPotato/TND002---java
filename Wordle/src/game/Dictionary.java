package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		} else {
			File dicFile = new File("words_alpha.txt");
			//newFile = new File("words_size_" + size + ".txt");
			newFile.createNewFile();
			System.out.println(newFile.getAbsolutePath());
		}
		 
		String line;
		BufferedReader freader = new BufferedReader(new FileReader(newFile));
		while ((line = freader.readLine()) != null) {
			
			
			
			
			
		}
	}
}
