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
	
	public String addCustomer(String name, double amount) {
		name = name.trim();
		boolean found = false;
		for (int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getName().equals(name)) {
				found = true;
			}
		}
		if(!found) {
			Customer newCusto = new Customer(name);
			customerList.add(newCusto);
			
			Current currenAccount = new Current(newCusto, accountNumber, amount);
			accountNumber++;
			
			Savings savingAccount = new Savings(currenAccount, accountNumber);
			accountNumber++;
			
			accountList.add(currenAccount);
			accountList.add(savingAccount);
			newCusto.addAccounts(currenAccount, savingAccount);

			return "Customer added";
		} else {
			return "Customer already exists";
		}
	}

	public Customer findCustomer(String customerName) {
		customerName = customerName.trim();
		for (int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getName().equals(customerName)) {
				return customerList.get(i);
			}
		}
		System.out.println("Customer does not exist");
		return null;
	}

	public void transfer(String customerName, double amount) {
		Customer transferCustomer = findCustomer(customerName);
		if(transferCustomer != null) {
			transferCustomer.getCurrentAccount().transfer(amount);
		}
	}
	
	public void transfer(String customerName1, String customerName2, double amount) {
		Customer transferFromCustomer = findCustomer(customerName1);
		Customer transferToCustomer = findCustomer(customerName2);
		if(transferFromCustomer != null && transferToCustomer != null) {
			transferFromCustomer.getCurrentAccount().transfer(transferToCustomer.getCurrentAccount(), amount);
		}
	}

	public String checkAccount(int accountNumber) {
		int accNumber = accountNumber - 1000;
		Account specAccount = accountList.get(accNumber);
		
		String accountType = specAccount.getAccountType();
		if (accountType == "Current") {
			return specAccount.toString();
		} else {
			return "Not a currnet account";
		}
	}
	
	public void annualChange() {
		for (int i = 0; i < accountList.size(); i++) {
			accountList.get(i).annualChange();
		}
	}

	public String toString() {		
		double sumDeposits = 0;
		for (int i = 0; i < accountList.size(); i++) {
			sumDeposits = sumDeposits + accountList.get(i).balance;
		}
		
		String output = "Bank statistics \n" + 
						"--------------- \n";
		String line1 = String.format("%10s %12d \n", "Customers:", customerList.size());
		String line2 = String.format("%10s %12.2f \n", "Money:", sumDeposits);
		output = output + line1 + line2;
		return output;
	}
}
