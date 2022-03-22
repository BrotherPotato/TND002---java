package tendaDel2;

public abstract class Account {
	protected Customer theCustomer;
	protected int accountNumber;
	protected double theBalance;
	private static int availableNumbers = 0;
	
	public Account(Customer customer, double balance) {
		this.theCustomer = customer;
		this.theBalance = balance;
		availableNumbers++;
	}
	public int getAccountNumber() {
		return this.accountNumber;
	}
	public double getBalance() {
		return this.theBalance;
	}
	public String toString() {
		String output = "Account number : " + this.accountNumber + "\n" +
						"Customer : " + this.theCustomer.getName() + "\n" +
						"Balance : " + this.theBalance + "\n";
		return output;
	}
}
