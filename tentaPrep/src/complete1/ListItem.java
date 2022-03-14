package complete1;
public class ListItem {
	private ListItem nextItem;
	private String theWord;
	private int counts, position;
	public ListItem(String inWord, int arg) {
		theWord = inWord; 
		nextItem = null;
		counts = 1; 
		position = arg;
	}
	public void attachItem(ListItem newItem) {
		nextItem = newItem;
	}
	public String getWord() {
		return theWord;
	}
	public void increaseCount() {
		counts = counts + 1;
	}
	public boolean hasNext() {
		if (nextItem == null) return false;
		else return true;
	}
	public ListItem getNext() {
		return nextItem;
	}
	public String toString() {
		return String.format("The word %6s is placed at the position %2d and has occured %2d times.", theWord, position, counts);
	}
}
