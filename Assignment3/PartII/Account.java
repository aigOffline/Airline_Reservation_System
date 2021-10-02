 
public class Account {
	private static int account_count;
	private double balance;
	private int id;
	
	public Account() {
		this(0);
	}
	
	public Account(double startingBalance) {
		balance = startingBalance;
		id = account_count;
		account_count++;
	}
	
	public boolean withdraw(double amount) {
		if(balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}

	
	public int getId() {
		return id;
	}

	
	
	
}
