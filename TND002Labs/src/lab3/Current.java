package lab3;

import java.util.ArrayList;

public class Current extends Account{
	private Customer theCustomer;
	private ArrayList<Transaction> theTransactions;
	
	public Current(Customer cust, int i, double d) {
		super(i);
		theCustomer = cust;
		super.balance = d;
		theTransactions = new ArrayList<Transaction>();
		
	}
	public Customer getCustomer() {
		return this.theCustomer;
	}
	// current account super.getNumber()
	// savings account super.otherAccount.getNumber()
	public void transfer(double amount) {
		if(amount != 0) {
			Account currentAccount = this;
			Account savingsAccount = super.otherAccount;
			
			if(amount > 0) {		// to savings account
				if((currentAccount.getBalance() - amount) >= 0) {
					this.theTransactions.add(new Transaction("to", savingsAccount.getNumber(), amount));
					savingsAccount.balance = savingsAccount.balance + amount;
					//this.theTransactions.add(new Transaction("from", currentAccount.getNumber(), amount));
					currentAccount.balance = currentAccount.balance - amount;
				} else {	// move as much money as possible
					this.theTransactions.add(new Transaction("to", savingsAccount.getNumber(), currentAccount.getBalance()));
					savingsAccount.balance = savingsAccount.balance + currentAccount.getBalance();
					//this.theTransactions.add(new Transaction("from", currentAccount.getNumber(), currentAccount.getBalance()));
					currentAccount.balance = currentAccount.balance - currentAccount.getBalance();
				}
				
			} else {		// from savings account
				amount = Math.abs(amount);
				if((savingsAccount.getBalance() - amount) >= 0) {
					//this.theTransactions.add(new Transaction("to", currentAccount.getNumber(), amount));
					currentAccount.balance = currentAccount.balance + amount;
					this.theTransactions.add(new Transaction("from", savingsAccount.getNumber(), amount));
					savingsAccount.balance = savingsAccount.balance - amount;
				} else {	// move as much money as possible
					//this.theTransactions.add(new Transaction("to", currentAccount.getNumber(), savingsAccount.getBalance()));
					currentAccount.balance = currentAccount.balance + savingsAccount.getBalance();
					this.theTransactions.add(new Transaction("from", savingsAccount.getNumber(), savingsAccount.getBalance()));
					savingsAccount.balance = savingsAccount.balance - savingsAccount.getBalance();
				}
			}
		}
	}
	public void deposit(Current currentAccount, double amount) {
		this.theTransactions.add(new Transaction("to", currentAccount.getNumber(), amount));
		currentAccount.balance = currentAccount.balance + amount;
	}
	public void transfer(Current currentAccount, double amount) {
		currentAccount.theTransactions.add(new Transaction("from", super.getNumber(), amount));
		super.balance = super.balance - amount;
		deposit(currentAccount, amount);
	}
	public String toString() {
		//String output = String.format("Customer %20s \nAccount number %15d \nBalance %15f \nSavings %15f \nList of transactions\n", 
		//		this.theCustomer.getName(), super.getNumber(), super.getBalance(), super.otherAccount.getBalance());
		
		
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
