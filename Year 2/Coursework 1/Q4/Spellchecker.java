import java.util.*;
import java.io.*;

class Spellchecker{
	private ArrayList<String> suggestion; // Used to store suggestions
	private ArrayList<String> dictionary = new ArrayList<String>(); // Used to store dictionary
	private File doc; // Documents to be spellchecked
	private PrintWriter output;

	public Spellchecker(String newFile) throws IOException{ // Takes a file as an argument
		doc = new File(newFile);
		output = new PrintWriter(new FileWriter(this.nameOutput(newFile), false),true);
		this.loadDict();
		this.checkDoc();
	}

	private void loadDict() throws IOException{ // Populates arraylist with a dictionary file
		Scanner scanDict = new Scanner(new File("dictionary.txt"));
		while(scanDict.hasNext()){
			dictionary.add(scanDict.next());
		}
	}

	private void checkDoc() throws IOException{ // Scans document using the checkword function
		Scanner scanDoc = new Scanner(doc);
		while(scanDoc.hasNext()){
			String temp = scanDoc.next().trim();
			if(checkWord(temp) == false){
				this.selectWord(temp);
			}
		}
	}

	private boolean checkWord(String word) { // Checks given word against the dictionary and populates suggestions
		suggestion = new ArrayList<String>(); // Empties arraylist
		for(int i = 0; i < dictionary.size(); i++){ // Checks through dictionary
			int check = this.levenshtein(word, dictionary.get(i)); // Uses levenshtiens to calculate the edit distance
			if(check == 0){ // Word is correct
				return true;
			}
			else{
				if(check == 1 || word.length() > 4 && word.length() <= 10 && check == 2 || word.length() > 10 && check == 3){ // Changes conditions for suggestions depending on the size of the word
					suggestion.add(dictionary.get(i));
				}
			}
		}
		return false;
	}

	private void selectWord(String word){ // Shows suggestions and allows user to select a word or add to dictionary
		if(suggestion.size() == 0){
			System.out.print("\n" + "No Guesses Found");
		}
		else{
			System.out.print("\n" + (char)34 + word + (char)34 + " is incorrect, did you mean:"); // Shows user incorrect word
		}		

		// Gives user options to select from
		System.out.println("\n" + "0: Add to Dictionary");
		for(int i = 0; i < suggestion.size(); i++){
			System.out.println((i + 1) + ": " + suggestion.get(i));
		}
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		switch(input) {
			case 0:
				output.print(word + " ");
				dictionary.add(word);
				break;
			default:
				if(input > suggestion.size() || input < 0){
					System.out.println("\n" + "Please enter a valid number");
					input = scan.nextInt();
				}
				else{
					output.print(suggestion.get(input - 1));
				}
				break;
		}	
	}

	private int levenshtein(String x, String y){
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
		return matrix[wordX.length][wordY.length];
	}

	private String nameOutput(String s){
		char[] temp = s.toCharArray();
		char[] newName = new char[s.length() + 4];
		for(int i = 0; i < temp.length; i++){
			if(temp[i] == '.' && i < newName.length - 1){
				newName[i] = '_';
				newName[i + 1] = 'c';
				newName[i + 2] = 'h';
				newName[i + 3] = 'k';
				for(int j = i + 4; j < newName.length; j++){
					newName[j] = temp[i];
					i++;
				}
				break;
			}
			else{
				newName[i] = temp[i];
			}
		}
		return new String(newName);
	}
}