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
	public void transfer(double d) {
		if(d != 0 && (super.otherAccount.getBalance() - d) > 0 && (super.getBalance() - d) > 0) {
			if(d > 0) {
				theTransactions.add(new Transaction("to", super.getNumber(), d));
				theTransactions.add(new Transaction("from", super.otherAccount.getNumber(), d));
			} else {
				theTransactions.add(new Transaction("to", super.otherAccount.getNumber(), d));
				theTransactions.add(new Transaction("from", super.getNumber(), d));
			}
			
		}
	}
	public void deposit(Current c, double d) {
		if(d > 0) {
			theTransactions.add(new Transaction("from", c.getNumber(), d));
		} else {
			System.out.println("Desposit failed");
		}
	}
	public void transfer(Current c, double d) {
		theTransactions.add(new Transaction("to", super.getNumber(), d));
		deposit(c, d);
	}
	public String toString() {
		return String.format("Customer %20s \nAccount number %15d \nBalance %15f \nSavings %15f", 
				this.theCustomer.getName(), super.getNumber(), super.getBalance(), this.getBalance());
	}
}
