package lab3;

public class Transaction {
	private int theAccount;
	private double theAmount;
	private String tofrom;
	
	public Transaction(String s, int i, double d) {
		this.tofrom = s;
		this.theAccount = i;
		this.theAmount = d;
	}
	public String toString() {
		return String.format("Money transfer %5s  account %4d : %6.2f", this.tofrom, this.theAccount, this.theAmount);
	}
}
