package model;

public class Account {

	int balance;
	
	Account(int amount) {
		balance = amount;
	}
	
	public synchronized void withdraw(int amount) {
		balance = balance - amount;
	
	}
	
	public void deposit(int amount) {
		// different
		synchronized(this) {
			balance = balance + amount;
		}
	}
	
	public synchronized void transfer(int amount, Account dest) {
		this.withdraw(amount);
		dest.deposit(amount);
	}
}
