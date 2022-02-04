package lab3;

public class Savings extends Account{
	
	public Savings(Current c, int i) {
		super(i, c);
		super.balance = 0.0;
	}
	public void changeBalance(double d) {
		super.balance += d;
	}
	public double getBalance() {
		return super.balance;
	}
}
