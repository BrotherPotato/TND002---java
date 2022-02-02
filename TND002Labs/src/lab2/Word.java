package lab2;

public class Word {
	public static int ORIGINAL = 0;
	public static int BYNAME = 1;
	public static int BYCOUNTS = 2;
	
	private String theWord;
	private int count;
	
	public static int sortCriterion = BYCOUNTS;
	
	public Word(String s, int i) {
		this.theWord = s;
		this.count = i;
	}
	public int getCount() {
		return this.count;
	}
	
	public String getWord() {
		return this.theWord;
	}
	// setCriterion(arg) changes the value of sortCriterion to one of the three possible ones (set by the class constants).
	public static void setCriterion(int i) {
		sortCriterion = i;
	}
	// getCriterion() returns the value of sortCriterion
	public static int getCriterion() {
		return sortCriterion;
	}
	// compareTo(arg) either compares the values of word (alphabetically) or count of two instances of Word.
	// Which one, depends on the value of sortCriterion. compareTo(arg)should send back values -1, 0, or 1.
	// If sortCriterion equals the value of ORIGINAL then the method should always return 0
	// If sortCriterion equals BYNAME, it should compare the values of word alphabetically
	// If sortCriterion equals BYCOUNTS, then it should compare the values of count numerically
	// In the second and third case, the method should return 0 if both values are equal
	// It should return a value -1 if the value of the instance variable of the calling instance of Word is smaller than that of arg in the argument list of compareTo(arg).
	// Otherwise, compareTo(arg) should return 1.
	public int compareTo(Word w) {
		if(sortCriterion == ORIGINAL) {
			return 0;
		} else if(sortCriterion == BYNAME) {
			//System.out.println(Integer.signum(this.word.compareTo(w.word)));
			return Integer.signum(w.theWord.compareTo(this.theWord));
		} else if(sortCriterion == BYCOUNTS) {
			if(this.count == w.count) {
				return 0;
			} else if(this.count < w.count) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
		
		
	}
	// toString() returns a formatted string.
	// It starts with �Word:� followed by the value of word in a column 10 characters wide and aligned to the right.
	// You leave 3 empty spaces and write �Count:� followed by the value of count in a column 3 characters wide.
	public String toString() {
		return String.format("Word: %10s   Count: %3d", this.theWord, this.count);
	}
}
