import java.util.Random; // Imports Random utility
import java.util.Scanner; // Imports Scanner utility
import java.util.InputMismatchException; // Imports Exception utility

class RandomTo100{
	public static void main (String[] args){

		System.out.println("Please enter an integer");
		Scanner input = new Scanner(System.in); // Reads user input

		try { // Tries to run the code inside
			int userNum = input.nextInt(); // Saves the value as an interger
			System.out.println();
			int[] numArray = createArray(userNum); // Saves the array created from the function
			printArray(numArray);
		}

		
		catch(InputMismatchException e) { // Does runs if the try fails
			System.out.println("That is not an integer"); // Error for user
		}
	}

	public static int[] createArray (int n){

		// Creates array that is size n
		int[] randomArray = new int [n];
		Random numGenerator = new Random();

		// Fills the array with random int from 0 - 100
		for (int i = 0; i < n; i++) {			
			randomArray[i] = numGenerator.nextInt(101);
		}
		return randomArray;
	}

	public static void printArray (int[] n){

		// Prints every element array n
		for (int i = 0; i < n.length; i++){
			System.out.println(n[i]);
		}
	}
}