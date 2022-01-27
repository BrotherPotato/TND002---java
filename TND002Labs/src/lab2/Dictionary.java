package lab2;

import java.util.ArrayList;

public class Dictionary {
	// You initialize backup to null when you declare it.
	private ArrayList<Word> theList = new ArrayList<Word>();
	private ArrayList<Word> backUp = null;
	// theList is initialized in the constructor
	public Dictionary() {
		
	}
	// addString(arg) takes in the string arg.
	// If arg is not yet contained in any element of theList, then addString(arg) creates a new instance of Word and adds it to theList.
	// If there is already an instance of Word with a value of word equal to arg, then it increases its value of count by 1.
	//  Use only the methods listed in the class diagram of Word to accomplish that.
	// addString(String) should return the return value of toString() of the added or updated (increased value of count) instance of Word.
	public String addString(String s) {
		return "";
	}
	// sortList(arg) sorts the instances of Word in theList according to the value of arg.
	// If sortList(arg) is called for the first time, then it should copy the address of theList to backup.
	// If sortList(arg) is called for the first time, then it should copy the address of theList to backup.
	// If arg has the value of one of the other class constants, then you set sortCriterion to arg and you start off with a loop over all elements of theList.
	// Use the compareTo(arg) of Word to compare the instance of Word at the current position in theList to the instances in the slots with a higher index
	// Depending on the result of compareTo(arg), you keep both instances of Word unchanged or you swap them.
	// In the end, you get a list that is either sorted by the number of count or alphabetically by the value of word
	public String sortList(int i) {
		return "";
	}
	// In the end, you get a list that is either sorted by the number of count or alphabetically by the value of word
	// If arg is equal or larger than the size of theList, the method should return ”end”. Otherwise, it should return the value of word.

	public String returnWord(int i) {
		return "";
	}
	// toString() should return a string that starts with ”Content: ” followed by a line break.
	// It should call the toString() methods of all elements of theList and concatenate their return strings to one large string.
	// It should call the toString() methods of all elements of theList and concatenate their return strings to one large string.
	// The method should return the concatenated string.
	public String toString() {
		return "";
	}
}
