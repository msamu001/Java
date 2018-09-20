class Star
{
	public static void main (String[] args)
	{	
		// Prints stars in decending order
		for(int i = 7; i > 0; i--){
			printStar(i);
			System.out.println();
		}
	}

	public static void printStar(int n){

		// Recursively prints stars
		if(n > 0){
			System.out.print('*');
			printStar(n-1);
		}
	}
}