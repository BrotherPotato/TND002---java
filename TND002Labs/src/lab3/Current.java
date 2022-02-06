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
	public void transfer(double d) {
		if(d != 0 && (super.otherAccount.getBalance() - d) > 0 && (super.getBalance() - d) > 0) {
			this.theTransactions.add(new Transaction("to", super.otherAccount.getNumber(), d));
			this.theTransactions.add(new Transaction("from", super.getNumber(), d));
		} else {
			this.theTransactions.add(new Transaction("to", super.otherAccount.getNumber(), super.getBalance()));
			this.theTransactions.add(new Transaction("from", super.getNumber(), super.getBalance()));
		}
	}
	public void deposit(Current c, double d) {
		this.theTransactions.add(new Transaction("from", c.getNumber(), d));
	}
	public void transfer(Current c, double d) {
		this.theTransactions.add(new Transaction("to", super.getNumber(), d));
		deposit(c, d);
	}
	public String toString() {
		//String.format("Customer %20s \nAccount number %15d \nBalance %15f \nSavings %15f \nList of transactions " + theTransactions.toString(), 
		//		this.theCustomer.getName(), super.getNumber(), super.getBalance(), this.getBalance());
		String output = String.format("Customer %20s \nAccount number %15d \nBalance %15f \nSavings %15f \nList of transactions ", this.theCustomer.getName(), super.getNumber(), super.getBalance(), this.getBalance());
		for (int i = 0; i < theTransactions.size(); i++) {
			output = output + theTransactions.get(i).toString();
		}
		return output;
	}
}
