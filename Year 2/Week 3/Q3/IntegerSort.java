import java.util.Scanner; // Imports Scanner utility

class IntegerSort{

	public static void main(String[] args){
		System.out.println();
		System.out.println("Please enter positive integers"); // Asks user for input
		System.out.println("Stop by entering 0");

		Scanner input;
		int doCount = 0; // Used for the error message

		// Checks if the input is an integer and give an error message if it is not
		do{
			input = new Scanner(System.in);
			if(doCount != 0){ // Stops error message being printed before first input
				System.out.println();
				System.out.println("Invalid Input: Not an integer");
				System.out.println("Please enter positive intergers");
				System.out.println("Stop by entering 0");
			}
			doCount++;
		} while(input.hasNextInt() == false);

		int num = input.nextInt();// Stores integer input
		int largest = num;
		int smallest = num;
		double sum = 0;
		double count = 0;

		while(num != 0){
			sum = sum + num; // Sums up numbers entered
			doCount = 0;
			if(num > 0){
				// Checks if input is largest number entered
				if(num > largest){
					largest = num;
				}
				// Checks if input is smallest number entered
				if(num < smallest){
					smallest = num;
				}
			}
			// Prints error message when input is less then 0
			else if(num < 0){
				System.out.println();
				System.out.println("Invalid Input: Negative Integer");
				System.out.println("Please enter positive intergers");
				System.out.println("Stop by entering 0");
			}
			count ++; // Counts the number of successful inputs by the user

			// Checks if the input is an integer and give an error message if it is not
			do{
				input = new Scanner(System.in);
				if(doCount != 0){ // Stops error message being printed before first input
					System.out.println();
					System.out.println("Invalid Input: Not an integer");
					System.out.println("Please enter positive intergers");
					System.out.println("Stop by entering 0");
				}
				doCount++;
			} while(input.hasNextInt() == false); 
			num = input.nextInt(); // Stores user input
		}
		System.out.println();z
		System.out.println("The largest interger is" + " " + largest);
		System.out.println("The smallest interger is" + " " + smallest);
		System.out.println("The average is" + " " + sum/count);
		System.out.println();
	}
}