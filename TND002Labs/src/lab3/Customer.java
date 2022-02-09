package lab3;

public class Customer {
	private String name;
	private Current currentAccount;
	private Savings savingsAccount;
	
	public Customer(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public Current getCurrentAccount() {
		return this.currentAccount;
	}
	public void addAccounts(Current currentAccount, Savings savingsAccount) {
		this.currentAccount = currentAccount;
		this.savingsAccount = savingsAccount;
	}
	public String toString() {
		String output;
		String line1 = String.format("%16s %15s \n", "Name of customer", this.name);
		String line2 = String.format("%16s %15s \n", "Current account", this.currentAccount.getNumber());
		String line3 = String.format("%16s %15s \n", "Savings account", this.savingsAccount.getNumber());
		
		if(currentAccount != null && savingsAccount != null) {
			output = line1 + line2 + line3;
		} else {
			output = line1;
		}
		return output;
	}
}
