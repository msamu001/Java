import java.lang.Math.*; // Import Maths library
import java.util.Scanner;	// Imports Scanner utility

class Guess{
	public static void main(String[] args){
		System.out.println();
		System.out.println("Think of a number between 0 and 1000");
		System.out.println();
		System.out.println("Enter 0 if correct");
		System.out.println("Enter L if lower");
		System.out.println("Enter H if highter");
		System.out.println();

		int max = 1000;
		int min = 0;
		int guess;
		int doCount = 0; // counts correct inputs
		Scanner input;

		double height = Math.ceil(Math.log(max + 1)/Math.log(2) - 1); // calculates height of the tree

		do{
			guess = (max + min + 1)/2; // calculates guess

			System.out.println("Is your number" + " " + guess + "?"); // Prints guess

			input = new Scanner(System.in); // User input

			if(input.hasNext("0")){ // Prevents input error from 0
			}

			else if(input.hasNext("L") || input.hasNext("l")){ // Changes the max if lower
				max = guess;
				System.out.println();
			}
			else if(input.hasNext("H") || input.hasNext("h")){ // Changes the min if heigher
				min = guess;
				System.out.println();
			}
			else{
				System.out.println();
				System.out.println("Input Error");
				--doCount; // Adds 1 more loop
			}
			doCount++;
		} while (input.hasNext("0") == false && doCount != height + 1);

		// Checks if user is cheating
		if (doCount == height + 1 && input.hasNext("0") == false){
			System.out.println();
			System.out.println("You Cheater!!!");
		}

		else{
			System.out.println();
			System.out.println("Good game, I win");
			System.out.println();
		}
	}
}