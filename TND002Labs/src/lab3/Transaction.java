package lab3;

public class Transaction {
	private int theAccount;
	private double theAmount;
	private String tofrom;
	
	public Transaction(String tofrom, int accountNumber, double amount) {
		this.tofrom = tofrom;
		this.theAccount = accountNumber;
		this.theAmount = amount;
	}
	public String toString() {
		return String.format("Money transfer %5s account %4d : %6.2f \n", this.tofrom, this.theAccount, this.theAmount);
	}
}
