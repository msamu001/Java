import java.util.Scanner;

class TestSoundex{
	public static void main(String[] args){
		System.out.println("\n" + "Please enter a word"); // User interaction
		Scanner scan = new Scanner(System.in);	// User input
		System.out.println("Soundex code: " + soundex(scan.next()) + "\n"); // Prints result of soundex method
	}

	public static String soundex(String code){
		char[] codeArr = code.toUpperCase().toCharArray(); // Changes all characters from string to upper case and add them to a char array
		String result = "" + codeArr[0]; // Adds the first letter of the String to the soundex code

		// Changes the letters to thier soundex values (does not include vowls, this allows duplicates to occur if a vowl is inbetween)
		for(int i = 0; i < codeArr.length; i++){
			if(codeArr[i] == 'B' || codeArr[i] ==  'F' || codeArr[i] == 'P' || codeArr[i] == 'V'){
				codeArr[i] = '1';
			}
			else if(codeArr[i] == 'C' || codeArr[i] == 'G' || codeArr[i] == 'J' || codeArr[i] == 'K' || codeArr[i] == 'Q' || codeArr[i] == 'S' || codeArr[i] == 'X' || codeArr[i] == 'Z'){
				codeArr[i] = '2';
			}
			else if(codeArr[i] == 'D' || codeArr[i] == 'T'){
				codeArr[i] = '3';
			}
			else if(codeArr[i] == 'L'){
				codeArr[i] = '4';
			}
			else if(codeArr[i] == 'M' || codeArr[i] == 'N'){
				codeArr[i] = '5';
			}
			else if(codeArr[i] == 'R'){
				codeArr[i] = '6';
			}
			else if(codeArr[i] == 'Y' || codeArr[i] == 'H' || codeArr[i] == 'W'){
				codeArr[i] = '0';
			}
		}

		for(int i = 0; i < codeArr.length; i++){
			if(i != codeArr.length - 1){ // Stops out of bound exeption
				if(codeArr[i] != '0'){
					// Checks for duplicate values and changes them to 0
					for(int j = i + 1; j < codeArr.length; j++){
						if(codeArr[i] == codeArr[j] || codeArr[j] == '0'){ // checks if the following char(s) are the same or 0
							codeArr[j] = '0';
						}
						else{
							break;
						}
					}
				}
			}
			// Changes vowls to 0
			if(codeArr[i] == 'A' || codeArr[i] == 'E'|| codeArr[i] == 'I' || codeArr[i] == 'O' || codeArr[i] == 'U'){
				codeArr[i] = '0';
			}
		}

		// Adds characters from the char array to the Soundex code
		for(int i = 0; i < codeArr.length; i++){
			if(codeArr[i] != '0' && result.length() < 4 && i != 0){
				result += codeArr[i];
			}	
		}

		// Adds 0s if the end result is less then 4 characters
		for(int i = 0; i < 4; i++){
			if(result.length() < 4){
				result += '0';
			}
		}
		return result;
	}
}