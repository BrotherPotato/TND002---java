package complete1;

public class DataBase {
	private ListItem start;
	private int thePosition;
	
	public DataBase() {
		start = null; thePosition = 1;
	}
	
	public void add(String arg) {
		if (start == null) {
			start = new ListItem(arg, thePosition); 
			thePosition = thePosition + 1;
		} else {			 
			if (start.getWord().equals(arg)) {
				start.increaseCount(); 
			}
			else {
				ListItem dummy = start; 
				boolean anotherOne = false;
				while (dummy.hasNext()) {
					dummy = dummy.getNext();
					if (dummy.getWord().equals(arg)) {
						anotherOne = true;
						dummy.increaseCount();
					}					
				}
				if (!anotherOne) {ListItem newElement = new ListItem(arg, thePosition); 
					thePosition = thePosition + 1; 
					dummy.attachItem(newElement); 
				}
			}
		}
	}
	
	public boolean delete(String arg) {
		if (start==null) {return false;}
		else {
			// Case : only one element in the list.
			if (!start.hasNext() && start.getWord().equals(arg)) {
				start = null;
			}							
			if (start.hasNext()) {
				// Case : two elements in the list and start is removed.
				if (start.getWord().equals(arg)) {
					start = start.getNext();
				}
				// Case : two or more elements in the list and the last one is removed.
				else {
					ListItem dummy1 = start;
					ListItem dummy2 = dummy1.getNext();
					while (dummy2.hasNext()) {
						dummy1 = dummy2; 
						dummy2=dummy1.getNext();
					}
					if (dummy2.getWord().equals(arg)) {
						dummy1.attachItem(null);
					}
				}
			}			
			// Case : an element between two others is removed
			if (start.hasNext() && start.getNext().hasNext()) {
				ListItem first = start, second, third;

				do {
					second = first.getNext(); 
					third = second.getNext();
					if (second.getWord().equals(arg)) {
						first.attachItem(third);
					}
					first = first.getNext();
				}while(third.hasNext());

			}			
			if (start==null) return false;
			else return true;
		}
	}
	
	public String toString() {
		String result = "Words in our data base" + "\n";
		if (start == null) result = result + "none";
		else {
			ListItem dummy = start;
			while (dummy.hasNext()) {
				result = result + dummy + "\n";
				dummy = dummy.getNext();
			}
			result = result + dummy;
		}		
		return result;
	}
}
