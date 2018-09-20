class NumStar
{
	public static void main (String[] args)
	{
		for (int i = 1; i <= 7; i++) {

			// Prints numbers for each row
			for (int j = 1; j <= i ; j++) {
				System.out.print(j);			
			}

			// Prints stars after the numbers
			printStar(7 - i);
			System.out.println();
		}
	}


	public static void printStar(int n){

		// Recursively prints stars
		if (n > 0){
			System.out.print('*');
			printStar(n-1);
		}
	}
}