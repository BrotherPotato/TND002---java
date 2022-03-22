package tendaDel2;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> theAccounts;
	private ArrayList<Customer> theCustomers;
	
	public Bank() {
		this.theAccounts = new ArrayList<Account>();
		this.theCustomers = new ArrayList<Customer>();
	}
	
	public boolean hasCustomer(String name) {
		for (Customer customer : theCustomers) {
			if(customer.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public void addCustomer(String name) {
		if(hasCustomer(name)) {
			System.out.println("The customer already exists.\n");
		} else {
			theCustomers.add(new Customer(name));
			System.out.println("Customer added.");
		}
	}
	
	public Customer getCustomer(String name) {
		for (Customer customer : theCustomers) {
			if(customer.getName().equals(name)) {
				return customer;
			}
		}
		return null;
	}
	
	public void addCurrentAccount(String name, double balance) {
		boolean found = false;
		if(!hasCustomer(name)) {
			System.out.println("There is no customer with that name.");
		} else {
			for (Account account : theAccounts) {
				if(account.theCustomer.equals(getCustomer(name))) {
					found = true;
				}
			}
			
			if(found) {
				System.out.println("The customer already has a current account.");
			} else {
				CurrentAccount newAccount = new CurrentAccount(getCustomer(name), balance);
				theAccounts.add(newAccount);
				System.out.println("Added an account for " + name + "\n");
			}
		}
	}
	
	public String toString() {
		int totalBalance = 0;
		String output = "Bank information :\n" +
						"Amount of customers: " + theCustomers.size() + "\n" + 
						"Amount of accounts: " + theAccounts.size() + "\n" + 
						"It controls a total of ";
		for (Account account : theAccounts) {
			totalBalance += account.getBalance();
		}
		output = output + totalBalance + "\n";
		return output ;
	}
}
