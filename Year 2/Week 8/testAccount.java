class testAccount{
	public static void main(String[] args){
		Account test = new Account("test", 57919856, 100000.00); // Creates test class
		Account test2 = new Account("test2"); // Creates test class

		// Tests functions
		test.printAccount();
		test.setName("newTest");
		test.withdraw(5000);
		test.printAccount();
		test.setAccountNumber(12345678);
		test.deposit(5000);
		test.printAccount();

		test2.printAccount();

		System.out.println("Number of accounts: " + Account.getNumAccounts());
		test2.close();
		test2.printAccount();
		System.out.println("Number of accounts: " + Account.getNumAccounts());
	}
}