package lab3;

public class Account {
	protected int accountNumber;
	protected String accountType;
	protected double balance;
	protected Account otherAccount;
	public static final double FEE = 10.0;
	public static final double INTEREST = 0.02;
	
	public Account(int i) {
		
	}
	public Account(int i, Current c){
		
	}
	public String getAccountType() {
		return this.accountType;
	}
	public int getNumber() {
		return this.accountNumber;
	}
	public double getBalance() {
		return this.balance;
	}
	public void annualChange() {
		balance = balance - FEE;
//		if() {
//			
//		}
	}
}
