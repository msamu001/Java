import java.util.Scanner;

class testConsolidate{
	public static void main(String[] args){
		System.out.println("Enter 3 account names");
		Scanner scan = new Scanner(System.in);

		Account acc1 = new Account(scan.next().trim(), 100.0);
		Account acc2 = new Account(scan.next().trim(), 100.0);
		Account acc3 = new Account(scan.next().trim(), 100.0);
		acc1.printAccount();
		acc2.printAccount();
		acc3.printAccount();

		acc1.close();
		Account acc4 = Account.consolidate(acc2,acc3);
		acc1.printAccount();
		acc2.printAccount();
		acc3.printAccount();
		if(acc4 != null){
			acc4.printAccount();
		}
	}
}