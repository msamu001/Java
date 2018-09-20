import java.util.Scanner; // Imports Scanner utility
import java.util.InputMismatchException; // Imports Exception utility

class Intergers{
	public static void main (String[] args){
		System.out.println("Please enter 10 integers"); // Asks user for input
		System.out.println();
		numInput(10);
	}

	public static void numInput(int n){
		if (n == 0){
			return;
		}
		else{
			try{
				Scanner input = new Scanner(System.in); 
				int num = input.nextInt();
				numInput(n - 1);
			}
			catch(InputMismatchException e){
				System.out.println();
				System.out.println("Please enter an integer");
				numInput(n);
			}
		}
	}
}	