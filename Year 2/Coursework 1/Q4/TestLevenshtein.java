import java.util.Scanner;
import java.lang.Math;

class TestLevenshtein{
	public static void main(String[] args){
		System.out.println("\n" + "Please enter 2 words"); // User interaction
		Scanner scan = new Scanner(System.in);	// User input
		int dist = levenshtein(scan.next().trim(), scan.next().trim()); // Runs levenshtein method using user input
		System.out.println("\n" + "The distance is: " + dist + "\n"); // Print the distance between the words
	}

	public static int levenshtein(String x, String y){
		char[] wordX = x.toLowerCase().toCharArray(); // Changes string to lower case the put into char array
		char[] wordY = y.toLowerCase().toCharArray(); // Changes string to lower case the put into char array
		int[][] matrix = new int[wordX.length + 1][wordY.length + 1]; // Initialize the matrix


		// Fill matrix with initial ditances
		for(int i = 0; i < wordY.length + 1; i++){ // 
			for(int j = 0; j < wordX.length + 1; j++){
				if(i == 0){
					matrix[j][i] = j; // 0 to char array length
				}
			}
			matrix[0][i] = i; // 0 to char array length
		}


		// Runs edit distance and uses levenshtein's algorithm to fill the matrix
		for(int i = 0; i < wordY.length; i++){
			for(int j = 0; j < wordX.length; j++){
				if(wordX[j] == wordY[i]){ // If the letters are the same
					matrix[j + 1][i + 1] = matrix[j][i]; // Add the value diagonally
				}
				else{
					int replace = matrix[j][i] + 1;
					int insert = matrix[j][i + 1] + 1;
					int delete = matrix[j + 1][i] + 1;
					matrix[j + 1][i + 1] = Math.min(replace, Math.min(insert, delete)); // Finds the minimum value and adds it to the matrix
				}
			}
		}

		// Formatting for the first word
		for(int i = 0; i <= wordX.length; i++){
			if(i == 0){
				System.out.print("\n" + "     "); // More space as the first area is blank
			}
			else{
				System.out.print("   " + wordX[i - 1]); // Writes the letters one by one
			}
		}
		System.out.println("\n"); // Spacing

		for(int i = 0; i <= wordY.length; i++){
			if(i == 0){
				System.out.print("    ");
			}
			else{
				System.out.print(wordY[i-1] + "   ");
			}

			for(int j = 0; j < wordX.length + 1; j++){			
				System.out.print(matrix[j][i] + "   ");
			}
			System.out.println("\n");
		}
		return matrix[wordX.length][wordY.length];
	}
}