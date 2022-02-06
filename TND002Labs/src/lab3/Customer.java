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
	public void addAccounts(Current c, Savings s) {
		this.currentAccount = c;
		this.savingsAccount = s;
	}
	public String toString() {
		// change %15d to another path?
		if(currentAccount != null && savingsAccount != null) {
			return String.format("Name of customer %16s \nCurrent account %15d \nSavings account %15d", 
					this.name, this.currentAccount, this.savingsAccount);
		} else {
			return String.format("Name of customer %16s \n", this.name);
		}
	}
}
