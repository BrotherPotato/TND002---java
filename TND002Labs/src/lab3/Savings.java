package lab3;

public class Savings extends Account{
	
	public Savings(Current c, int i) {
		super(i, c);
		//super.balance = 0.0;
		this.balance = 0.0;
	}
	public void changeBalance(double d) {
		//super.otherAccount.balance += d;
		this.balance += d;
	}
	public double getBalance() {
		return this.balance;
	}
}
