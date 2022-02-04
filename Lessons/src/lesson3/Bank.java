package lesson3;

import java.util.*;
public class Bank {

	ArrayList<Customer> theCustomers;
	ArrayList<Account> theAccounts;
	
	public Bank() {
		theCustomers = new ArrayList<Customer>();
		theAccounts = new ArrayList<Account>();
	}
	
	public boolean hasCustomer(String arg) {
		boolean dummy = false;
		for (int j=0; j < theCustomers.size();j++) {
			if (theCustomers.get(j).getName().equals(arg.trim())) {
				dummy = true;
			}
		}		
		return dummy;
	}
	
	public void addCustomer(String arg) {
		String dummy = arg.trim();
		if (hasCustomer(dummy)) System.out.println("The customer already exists");
		else {
			System.out.println("Added customer.");
			theCustomers.add(new Customer(dummy));
		}
	}
	
	public Customer getCustomer(String arg) {
		String dummy = arg.trim();
		Customer result = null;
		for (int j=0; j < theCustomers.size(); j++) {
			if (dummy.equals(theCustomers.get(j).getName())) {
				result = theCustomers.get(j);
			}
		}
		
		return result;
	}
	
	public void addCurrentAccount(String arg1, double arg2) {
		String dummy = arg1.trim();
		Customer dummy2 = getCustomer(dummy);
		if (dummy2 == null) System.out.println("This customer does not exists.");
		else {
			if (dummy2.hasCurrentAccount()) System.out.println("The customer already has a current account");
			else {
				CurrentAccount dummy3 = new CurrentAccount(dummy2,arg2);
				dummy2.addCurrentAccount(dummy3);
				theAccounts.add(dummy3);
			}
		}
	}
	
	public String toString() {
		String result = "Bank information\n";
		result = result + "The bank has " + theCustomers.size() + " customers" + "\n";
		result = result + "The bank has " + theAccounts.size() + " accounts" + "\n";
		
		double dummy = 0.0;
		for (int j=0; j < theAccounts.size(); j++) {
			dummy = dummy + theAccounts.get(j).getBalance();
		}
		result = result + "The bank controls the total amount of : " + dummy;
		
		return result;
	}
	
}
