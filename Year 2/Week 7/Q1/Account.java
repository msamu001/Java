public class Account{
	private String name;		// Class variable
	private int accountNumber;	// Class variable
	private double balance;		// Class variable

	public Account(String owner){
		name = owner;
		accountNumber = 0;
		balance = 0;
	}

	public Account(String owner, int n){ // Overloading constuctor
		name = owner;
		accountNumber = n;
		balance = 0;
	}

	public Account(String owner, double bal){ // Overloading constuctor
		name = owner;
		accountNumber = 0;
		balance = bal;
	}

	public Account(String owner, int n, double bal){ // Overloading constuctor
		name = owner;
		accountNumber = n;
		balance = bal;
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

	public double deposit(double d){
		return balance = balance + d;
	}

	public double withdraw(double w){
		return balance = balance - w;
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