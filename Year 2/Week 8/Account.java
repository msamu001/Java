import java.util.Random; // Imports random utility
import java.lang.Math.*; // Imports maths

public class Account{
	private String name;		// Class variable
	private long accountNumber;	// Class variable
	private double balance;		// Class variable
	private static int numAccounts = 0;	// Q1 iv

	public Account(String owner){
		name = owner;
		accountNumber = this.genAccountNumber();
		balance = 0;
		Account.numAccounts++;
	}

	public Account(String owner, long n){ // Overloading constuctor
		name = owner;
		accountNumber = n;
		balance = 0;
		Account.numAccounts++;
	}

	public Account(String owner, double bal){ // Overloading constuctor
		name = owner;
		accountNumber = this.genAccountNumber();
		balance = bal;
		Account.numAccounts++;
	}

	public Account(String owner, long n, double bal){ // Overloading constuctor
		name = owner;
		accountNumber = n;
		balance = bal;
		Account.numAccounts++;
	}

	private long genAccountNumber(){ // Randomly generates an 8 digit account number
		Random gen = new Random(); // Creates new random class
		long accNum = 0;
		for(int i = 0; i < 8; i++){ // Runs 8 times as account number has 8 digits
			accNum = accNum + gen.nextInt(10) * (long)Math.pow(10, i); // Generates random number from 0 - 9 them mulitplies by i to the power of 10
		}
		return accNum; // Returns the generated account number
	}

	public void setName(String s){
		name = s;
	}

	public void setAccountNumber(int n){
		accountNumber = n;
	}

	public void setBalance(double b){
		balance = b;
	}

	public String getName(){
		return name;
	}
	
	public String getAccountNumber(){
		return String.valueOf(accountNumber);
	}

	public String getBalance(){
		return String.valueOf(balance);
	}
	
	public static long getNumAccounts(){ // Q1 iv
		return numAccounts;
	}

	public double deposit(double d){
		return balance = balance + d;
	}

	public double withdraw(double w){
		return balance = balance - w;
	}

	public void close(){ // Q1 v
		this.setName("CLOSED");
		this.setBalance(0);
		--Account.numAccounts;
	}

	public static Account consolidate(Account a, Account b){ // Q1 vi
		if(a.getAccountNumber() == b.getAccountNumber()){ // Stops the same account from being consolidated
			System.out.println("ERROR CANNOT CONSOLIDATE THE SAME ACCOUNT");
			return null;
		}
		if(a.getName().equals(b.getName()) == false){ // Stops accounts with different owners being consolidated
			System.out.println("ERROR BOTH ACCOUNTS MUST HAVE THE SAME OWNER");
			return null;
		}
		Account newAccount = new Account(a.getName(), (Double.parseDouble(a.getBalance()) + Double.parseDouble(b.getBalance()))); // Creates new account by adding the balance of the previous accounts
		a.close();
		b.close();
		return newAccount;
	}

	public String toString(){
		return ("\n" + "Name: " + name +
				"\n" + "Account Number: " + this.getAccountNumber() +
				"\n" + "Balance: "+ this.getBalance());
	}

	public void printAccount(){
		System.out.println(this.toString());
	}
}