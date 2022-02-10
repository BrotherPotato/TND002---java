package lab3;

import java.util.ArrayList;

public class Current extends Account{
	private Customer theCustomer;
	private ArrayList<Transaction> theTransactions;
	
	public Current(Customer customer, int accountNumber, double amount) {
		super(accountNumber);
		super.balance = amount;
		theCustomer = customer;
		theTransactions = new ArrayList<Transaction>();
		
	}
	public Customer getCustomer() {
		return this.theCustomer;
	}

	public void transfer(double amount) {
		if(amount != 0) {
			Account currentAccount = this;
			Account savingsAccount = super.otherAccount;
			
			if(amount > 0) {		// to savings account
				if((currentAccount.getBalance() - amount) >= 0) {
					this.theTransactions.add(new Transaction("to", savingsAccount.getNumber(), amount));
					savingsAccount.balance = savingsAccount.getBalance() + amount;
					currentAccount.balance = currentAccount.getBalance() - amount;
				} else {	// move as much money as possible
					this.theTransactions.add(new Transaction("to", savingsAccount.getNumber(), currentAccount.getBalance()));
					savingsAccount.balance = savingsAccount.getBalance() + currentAccount.getBalance();
					currentAccount.balance = currentAccount.getBalance() - currentAccount.getBalance();
				}
				
			} else {		// from savings account
				amount = Math.abs(amount);
				if((savingsAccount.getBalance() - amount) >= 0) {
					this.theTransactions.add(new Transaction("from", savingsAccount.getNumber(), amount));
					currentAccount.balance = currentAccount.getBalance() + amount;
					savingsAccount.balance = savingsAccount.getBalance() - amount;
				} else {	// move as much money as possible
					this.theTransactions.add(new Transaction("from", savingsAccount.getNumber(), savingsAccount.getBalance()));
					currentAccount.balance = currentAccount.getBalance() + savingsAccount.getBalance();
					savingsAccount.balance = savingsAccount.getBalance() - savingsAccount.getBalance();
				}
			}
		}
	}
	public void deposit(Current currentAccount, double amount) {
		currentAccount.theTransactions.add(new Transaction("from", this.getNumber(), amount));
		currentAccount.balance = currentAccount.getBalance() + amount;
	}
	public void transfer(Current currentAccount, double amount) {
		this.theTransactions.add(new Transaction("to", currentAccount.getNumber(), amount));
		this.balance = this.getBalance() - amount;
		deposit(currentAccount, amount);
	}
	public String toString() {
		String line1 = String.format("%20s %15s \n", "Customer", this.theCustomer.getName());
		String line2 = String.format("%20s %15s \n", "Account number", this.getNumber());
		String line3 = String.format("%20s %15s \n", "Balance", this.getBalance());
		String line4 = String.format("%20s %15s \n", "Savings", this.otherAccount.getBalance());
		String output = line1 + line2 + line3 + line4 + "List of transactions\n";
		for (int i = 0; i < theTransactions.size(); i++) {
			output = output + theTransactions.get(i).toString();
		}
		
		return output;
	}
}
