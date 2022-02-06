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
			
			Current currenAccount = new Current(newCusto, accountNumber, d);
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
		transferCustomer.getCurrentAccount().transfer(amount);
		
		
		//Transaction transfer = new Transaction(string, accountNumber, d);
		//transfer.toString();
	}
	public void transfer(String customerName1, String customerName2, double amount) {
		Customer transferFromCustomer = findCustomer(customerName1);
		Customer transferToCustomer = findCustomer(customerName2);
		transferFromCustomer.getCurrentAccount().transfer(transferToCustomer.getCurrentAccount(), amount);
	}

	public String checkAccount(int i) {
		int accNumber = i - 1000;
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
//		String output = "\\033[4;2m" + "Bank statistics";
//		output = "\\e[4mBank statistics\\e[0m";
//		System.out.print("\033[4;30m");
//        System.out.println("Bank statistics");
//        System.out.print("\033[0m");
		//String.format("Customers: %10s %12d", null);
		
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
