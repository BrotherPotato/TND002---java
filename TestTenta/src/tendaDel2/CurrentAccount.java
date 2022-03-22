package tendaDel2;

public class CurrentAccount extends Account {
	public CurrentAccount(Customer customer, double balance) {
		super(customer, balance);
	}
	
	public Customer getCustomer() {
		return this.theCustomer;
	}
	public void receive(double payAmount) {
		this.theBalance += payAmount;
	}
	
	public String toString() {
		String output = "via subclass :\n" + super.toString();
		return output;
	}
}
