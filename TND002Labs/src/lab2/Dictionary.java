package lab2;

import java.util.ArrayList;
import java.util.Collections;

public class Dictionary {
	// You initialize backup to null when you declare it.
	private ArrayList<Word> theList;
	private ArrayList<Word> backUp = null;
	// theList is initialized in the constructor
	public Dictionary() {
		this.theList = new ArrayList<Word>();
	}
	// addString(arg) takes in the string arg.
	// If arg is not yet contained in any element of theList, then addString(arg) creates a new instance of Word and adds it to theList.
	// If there is already an instance of Word with a value of word equal to arg, then it increases its value of count by 1.
	// Use only the methods listed in the class diagram of Word to accomplish that.
	// addString(String) should return the return value of toString() of the added or updated (increased value of count) instance of Word.
	public String addString(String s) {
		boolean found = false;
		int foundIndex = 0;
		// go through list
		for (int index = 0; index < this.theList.size(); index++) { 
			// check if a Word contains the word s
	          if(this.theList.get(index).getWord().equals(s)) {
	        	  // save the current index and that the word was found
	        	  found = true;
	        	  foundIndex = index; 
	        	  break;
	          } 
	    }
		if(found) {
      	  	int count = this.theList.get(foundIndex).getCount();
    	  	count++;
    	  	String word = this.theList.get(foundIndex).getWord();
    	  	Word newWord = new Word(word, count);
    	  	this.theList.set(foundIndex, newWord);
    	    return newWord.toString();
		} else {
			Word newWord = new Word(s, 1);
      	  	this.theList.add(newWord);
      	  	return newWord.toString();
		}
	}
	// sortList(arg) sorts the instances of Word in theList according to the value of arg.
	// If sortList(arg) is called for the first time, then it should copy the address of theList to backup.
	// If arg has the value of one of the other class constants, then you set sortCriterion to arg 
	// and you start off with a loop over all elements of theList.
	// Use the compareTo(arg) of Word to compare the instance of Word at the current position in theList to the instances 
	// in the slots with a higher index
	// Depending on the result of compareTo(arg), you keep both instances of Word unchanged or you swap them.
	// In the end, you get a list that is either sorted by the number of count or alphabetically by the value of word
	public String sortList(int arg) {
		if(backUp == null || backUp.isEmpty()) {
			//backUp = new ArrayList<>(theList);
			// allocate memory to the backUp
			backUp = new ArrayList<>();
			for (int i= 0; i < this.theList.size(); i++) {
				String word = this.theList.get(i).getWord();
				int count = this.theList.get(i).getCount();
				Word newW = new Word(word, count);
				this.backUp.add(newW);
			}
			//backUp.addAll(theList.clone());
			//backUp.addAll(theList);
		}
		if(arg == Word.ORIGINAL) {
			Word.setCriterion(arg);
			// shallow copy
			theList = new ArrayList<Word>(backUp);
			// We clone the backUp and cast the created objects to a ArrayList of type word
			//theList =  (ArrayList<Word>) backUp.clone();
	         
	        //System.out.println(theList);
			
			return "Sorted according to the original";
			
			//System.out.println("backUp loaded");
		} else if(arg == Word.BYNAME || arg == Word.BYCOUNTS) {
			Word.setCriterion(arg);
			for (int i= 0; i < this.theList.size()-1; i++) {
				for (int y = 0; y < this.theList.size()-i-1; y++) {
					Word w1 = this.theList.get(y);
					Word w2 = this.theList.get(y+1);
					
					if(w1.compareTo(w2) == -1) {
						Collections.swap(this.theList, y, y+1);
					}
				}
			}
		}
		if(arg == Word.BYCOUNTS) {
			return "Sorted by counts";
		} else if(arg == Word.BYNAME) {
			return "Sorted alphabetically";
		} else {
			return "Sorting criterion undefined";
		}
		
	}
	// In the end, you get a list that is either sorted by the number of count or alphabetically by the value of word
	// If arg is equal or larger than the size of theList, the method should return ”end”. 
	// Otherwise, it should return the value of word.

	public String returnWord(int arg) {
		if(this.theList.size() <= arg) {
			return "end";
		} else {
			return this.theList.get(arg).getWord();
		}
	}
	// toString() should return a string that starts with ”Content: ” followed by a line break.
	// It should call the toString() methods of all elements of theList and concatenate their return strings to one large string.
	// The method should return the concatenated string.
	public String toString() {
		String output = "Content: \n";
		
		for (int i = 0; i < this.theList.size(); i++) {
			Word indexWord = this.theList.get(i);
			output = output + indexWord.toString() + "\n";
		}
		
		return output;
	}
}
