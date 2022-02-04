package lab3;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Customer> customerList;
	private ArrayList<Account> accountList;
	private int accountNumber;
	
	public Bank() {
		customerList = new ArrayList<Customer>();
		accountList = new ArrayList<Account>();
		accountNumber = 1000;
	}
	
	public String addCustomer(String string, double d) {
		string = string.trim();
		boolean found = false;
		for (int i = 0; i < customerList.size(); i++) {
			//customerList.get(i).getName();
			if(customerList.get(i).getName().equals(string)) {
				found = true;
			}
		}
		if(!found) {
			Customer newCusto = new Customer(string);
			customerList.add(newCusto);
			
			Current newCurrent = new Current(newCusto, accountNumber, d);
			
			Account newAcou = new Account(accountNumber, newCurrent);
			accountNumber++;
			accountList.add(newAcou);
			return "Customer added";
		} else {
			return "Customer already exists";
		}
	}

	public Customer findCustomer(String string) {
		string = string.trim();
		for (int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getName().equals(string)) {
				return customerList.get(i);
			}
		}
		System.out.println("Customer does not exist");
		return null;
	}

	public void transfer(String string, double d) {
		Transaction transfer = new Transaction(string, accountNumber, d);
		transfer.toString();
	}
	public void transfer(String string, String string2, double i) {
		
	}

	public String checkAccount(int i) {
		try {
			Account specAccount = accountList.get(i);
			return specAccount.toString();
		} catch (Exception ignored) {
			return "Not a current account";
		}
	}
	
	public void annualChange() {
		for (int i = 0; i < accountList.size(); i++) {
			accountList.get(i).annualChange();
		}
	}

	public String toString() {
		String output = "\\033[4;2m" + "Bank statistics";
//		System.out.print("\033[4;30m");
//        System.out.println("Bank statistics");
//        System.out.print("\033[0m");
		//String.format("Customers: %10s %12d", null);
		return output;
	}
}
