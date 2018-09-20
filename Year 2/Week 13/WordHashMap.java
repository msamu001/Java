import java.util.*;
import java.io.*;

public class WordHashMap {
	public static void main(String[] args) throws IOException{
		HashMap<String,Integer> words = new HashMap<String,Integer>();

		System.out.println("\n" + "Please enter the filename");

		Scanner userInput = new Scanner(System.in);
		String fileName = userInput.next().trim();
		Scanner file = new Scanner(new File(fileName));
		System.out.println();

		while(file.hasNext()) {
			String keyChk = file.next();
			if(words.containsKey(keyChk)) {
				words.put(keyChk, words.get(keyChk)+1);
			}
			else {
				words.put(keyChk, 1);
			}
		}
		System.out.println(words.keySet());
		System.out.println(words.values());
	}
}