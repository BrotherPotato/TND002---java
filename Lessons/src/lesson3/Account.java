package lesson3;

public class Account {

	protected Customer theCustomer;
	protected int accountNumber;
	protected double theBalance;
	private static int availableNumbers = 0;
	
	public Account(Customer arg1, double arg2) {
		theCustomer = arg1;
		theBalance = arg2;
		availableNumbers = availableNumbers + 1;
		accountNumber = availableNumbers;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return theBalance;
	}
	
	public String toString() {
		String result = "\n******************************";
		result = result + "\nAccount number : " + accountNumber;
		result = result + "\nCustomer : " + theCustomer.getName();
		result = result + "\n*******************************";
		return result;
	}
}
