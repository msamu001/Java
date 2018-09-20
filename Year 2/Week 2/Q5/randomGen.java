import java.lang.Math.*; // Imports Math library

class randomGen {
	public static void main (String[] args){
		double n = 0;
		double temp;

		// Creates random numbers between 0 - 1
		for (int i = 0; i < 1000000; i++) {
			temp = Math.random();

			// Saves larger numbers
			if (n < temp)
				n = temp;
		}
		// Prints the result
		System.out.println(n);
	}
}