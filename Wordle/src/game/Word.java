package game;

public class Word {
	private String wordString;
	private int freq;
	
	public Word(String word, int freq) {
		this.wordString = word;
		this.freq = freq;
	}
	public String getWord() {
		return this.wordString;
	}
	public int getFreq() {
		return this.freq;
	}
}
