package tendaDel2;

public class Customer {

	private String theName;
	private CurrentAccount theCurrentAccount = null;
	
	public Customer(String name) {
		this.theName = name;
	}

	public String getName() {
		return this.theName;
	}
	
	public boolean hasCurrentAccount() {
		return true;
	}
	
	public void addCurrentAccount(CurrentAccount account) {
		this.theCurrentAccount = account;
	}
	
	public CurrentAccount getCurrentAccount() {
		return this.theCurrentAccount;
	}

	public String toString() {
		String output = "Customer : " + this.theName + "\n";
		if(this.theCurrentAccount != null) {
			output = output + "Currentaccount : " + this.theCurrentAccount + "\n";
		}
		return output;
	}
}
