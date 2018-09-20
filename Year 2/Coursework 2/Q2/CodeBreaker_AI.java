import java.util.*;

public class CodeBreaker_AI{
	public ArrayList<int[]> solutions;
	private ArrayList<int[]> guessLog;
	public ArrayList<int[]> keyLog;
	public int[] hiddenCode;

	public CodeBreaker_AI(){
		solutions = calcCodes();
		hiddenCode = genCode();
		guessLog = new ArrayList<int[]>();
		keyLog = new ArrayList<int[]>();
	}
	
	public void addKey(int black, int white){ // Adds response from user to a log
		keyLog.add(new int[]{black,white});
	}

	private int[] genCode(){
		Random randomCode = new Random();
		return solutions.get(randomCode.nextInt(1296)+ 1);
	}
	
	private ArrayList<int[]> calcCodes(){ // Adds every code combination to the Arraylist
		ArrayList<int[]> temp = new ArrayList<>();
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				for(int k = 0; k < 6; k++){
					for(int l = 0; l < 6; l++){
						temp.add(new int[]{i,j,k,l});
					}
				}
			}
		}
		return temp;
	}

	public int[] calcResponce(int[] userGuess){
		return matchChk(hiddenCode, userGuess);
	}
	
	public int[] calcGuess(int tc, boolean smart){
		int[] guess;
		if(smart){
			guess = knuthGuess(tc);
		} else {
			guess = calcCodes().get(tc);
		}
		return guess;
	}
	
	public int[] knuthGuess(int tc){
		if(tc == 0){ // Initial guess
			guessLog.add(new int[]{0,0,1,1});
		} else {
			calcSolutions(tc);
			guessLog.add(minimax());
		}
		return guessLog.get(tc);
	}
	
	private void calcSolutions(int tc){ // Removes incorrect solutions
		Iterator<int[]> codeIt = solutions.iterator();
		while(codeIt.hasNext()){ // Goes through the potential solutions
			int[] crntCode = codeIt.next(); 
			if(Arrays.equals(matchChk(crntCode, guessLog.get(tc-1)), keyLog.get(tc-1)) == false){ // Removes solutions which cannot be the correct solution
				codeIt.remove();
			}
		}
	}
	
	private int[] matchChk(int[] crntCode, int[] prevGuess){
		int[] keyChk = new int[2]; // Used to check number of black and white pegs
		char[][] match = new char[crntCode.length][crntCode.length];
		for(int i = 0; i < crntCode.length; i++){
			for(int j = 0; j < crntCode.length; j++){					
				if(crntCode[i] == prevGuess[j]){ // When the element from the previous guess matches an element in the solution
					if(i == j){
						match[i][j] = 'B'; // correct colour, correct location
						break;
					} else {
						match[i][j] = 'W'; // correct colour, wrong location
					}
				}
			}
		}
		for(int i = 0; i < crntCode.length; i++){	// Used to calculate number of black and white pegs that have duplicates
			if(match[i][i] == 'B'){ 				// If there is a black peg in the column then skip to next column
				keyChk[0]++;						// Add one to black pegs
			} else{
				for(int j = 0; j < crntCode.length; j++){
					if(match[i][j] == 'W'){ 												// If there is a white peg
						if((match[j][j] == 'B' && crntCode[i] == crntCode[j]) == false){ 	// this will check to see if there is a duplicate in the correct location
							keyChk[1]++; 													// and Adds one to white pegs if there are no duplicates
							break;
						}
					}
				}
			}
		}
		return keyChk;
	}
	
	private int[] minimax(){
		ArrayList<int[]> codes = calcCodes();
		int[] nextGuess = null;
		int[][] responces = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 },
							  { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 },
							  { 2, 0 }, { 2, 1 }, { 2, 2 }, { 3, 0 }, { 4, 0 } };

		int min = Integer.MAX_VALUE;
		for(int[] crntCode : codes){
			int max = 0;
			for(int[] possibleResponce : responces){
				int keyScore = 0;
					for(int[] possibleSolutions : solutions){
					if(Arrays.equals(matchChk(crntCode, possibleSolutions), possibleResponce)){
						keyScore++;
					}
				}
				if(keyScore > max){
					max = keyScore;
				}
			}
			if(max < min){
				min = max;
				nextGuess = crntCode;
			}
		}
		return nextGuess;
	}
}