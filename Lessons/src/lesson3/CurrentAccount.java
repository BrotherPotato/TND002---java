package lesson3;

public class CurrentAccount extends Account {
	
	public CurrentAccount(Customer arg1, double arg2) {
		super(arg1, arg2);
	}
	
	public Customer getCustomer() {
		return theCustomer;
	}
	
	public void receive(double arg) {
		theBalance = theBalance + arg;
	}
	
	public String toString() {
		String result = "via subclass :";
		result = result + super.toString();
		return result;
	}
}
