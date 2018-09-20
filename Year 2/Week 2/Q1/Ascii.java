class Ascii{

	public static void main(String[] args){
		for(int i = 32; i <= 122; i++){

			// Print Ascii characters
			System.out.print((char)i);

			// Starts a new line every 8 characters
			if((i - 32)%8 == 0){
				System.out.println();
			}			
		}
		System.out.println();
	}
}