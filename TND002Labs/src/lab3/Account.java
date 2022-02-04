package lab3;

public class Account {
	protected int accountNumber;
	protected String accountType;
	protected double balance;
	protected Account otherAccount;
	public static final double FEE = 10.0;
	public static final double INTEREST = 0.02;
	
	public Account(int i) {
		accountNumber = i;
		accountType = "Current";
	}
	public Account(int i, Current c){
		accountNumber = i;
		otherAccount = c;
		accountType = "Savings";
		//c.getCustomer().addAccounts(c, c);
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
		if(accountType == "Current"){
			balance = balance - FEE;
		}
		if(accountType == "Savings") {
			balance = balance + balance * INTEREST;
		}
	}
}
