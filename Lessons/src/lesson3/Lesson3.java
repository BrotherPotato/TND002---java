package lesson3;

public class Lesson3 {

	public static void main(String[] args) {
		
		System.out.println("Testing customer");
		System.out.println("----------------");
		
		Customer theCustomer = new Customer("Mark");
		System.out.println("Name : " + theCustomer.getName());
		System.out.println("Has a current account : " + theCustomer.hasCurrentAccount());
		System.out.println("Reference to current account : " + theCustomer.getCurrentAccount());
		System.out.println("toString : " + theCustomer.toString());
		System.out.println();System.out.println();
		
		System.out.println("Testing Account");
		System.out.println("---------------");
		
		Account theAccount1 = new Account(theCustomer,100.0);
		System.out.println("Customer's toString : " + theAccount1.theCustomer.toString());
		System.out.println();
		System.out.println("Account number : " + theAccount1.accountNumber);
		System.out.println("Account balance : " + theAccount1.theBalance);
		System.out.println("toString : " + theAccount1.toString());
		System.out.println();
		
		Account theAccount2 = new Account(theCustomer,200.0);
		System.out.println("Account number : " + theAccount2.accountNumber);
		System.out.println("Account balance : " + theAccount2.theBalance);
		System.out.println("toString : " + theAccount2.toString());
		System.out.println();
		System.out.println();
		
		System.out.println("Testing CurrentAccount");
		System.out.println("----------------------");

		CurrentAccount theAccount3 = new CurrentAccount(theCustomer,300.0);
		theCustomer.addCurrentAccount(theAccount3);
		System.out.println("Account number : " + theAccount3.accountNumber);
		System.out.println("Account balance : " + theAccount3.theBalance);
		System.out.println("toString : " + theAccount3.toString());
		System.out.println();
		System.out.println("Customer in current account : " + theAccount3.theCustomer);
		System.out.println();
		System.out.println("Current account in customer : " + theCustomer.getCurrentAccount());
		
		// Deleting existing objects
		theCustomer = null;
		theAccount3 = null;
		theAccount1 = null; 
		theAccount2 = null;
		
		System.out.println();
		System.out.println("Testing Bank");
		System.out.println("------------");
		
		Bank theBank = new Bank();
		System.out.println("Does it have the customer : " + theBank.hasCustomer("Agnes"));
		System.out.println("Customer info : " + theBank.getCustomer("Harry"));
		theBank.addCustomer("Harry");
		theBank.addCustomer("Harry");
		theBank.addCustomer("Agnes");
		System.out.println("Does it have the customer : " + theBank.hasCustomer("Agnes"));
		System.out.println("Customer info : " + theBank.getCustomer("Agnes"));
		
		theBank.addCurrentAccount("Mark",200);
		theBank.addCurrentAccount("Harry",300);
		theBank.addCurrentAccount("Harry",400);
		theBank.addCurrentAccount("Agnes",300);
		
		System.out.println();
		System.out.println(theBank);
	}

}
