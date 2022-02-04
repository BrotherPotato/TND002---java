package lab3;

public class Lab3 {

	public static void main(String[] args) {
		
		Bank theBank = new Bank();

		System.out.println(theBank.addCustomer("Joel Svensson",2000.0));
		System.out.println(theBank.addCustomer("Joel Svensson",2000.0));	
		theBank.findCustomer("Mark Svensson");
		System.out.println();
		System.out.println(theBank.findCustomer("Joel Svensson"));
		
		System.out.println(theBank.checkAccount(1000));
		theBank.transfer("Joel Svensson",500.0);
		theBank.transfer("Joel Svensson",-250.0);
		System.out.println(theBank.checkAccount(1000));
		
		System.out.println(theBank.addCustomer("Anneli Sund",3000.0));
		System.out.println();
		System.out.println(theBank.findCustomer("Anneli Sund"));
		
		theBank.transfer("Joel Svensson", "Anneli Sund", 250);
		
		System.out.println(theBank.checkAccount(1000));
		System.out.println(theBank.checkAccount(1002));
		
		System.out.println(theBank.addCustomer("Crazy Guy",25));
		System.out.println(theBank.checkAccount(1004));
		theBank.transfer("Crazy Guy", 100000.0);
		System.out.println(theBank.checkAccount(1004));	
		theBank.transfer("Crazy Guy", -100000.0);
		System.out.println(theBank.checkAccount(1004));
		
		
		
		
		System.out.println(theBank);
	}

}
