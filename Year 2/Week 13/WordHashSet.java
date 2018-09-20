import java.util.*;
import java.io.*;

public class WordHashSet {
	public static void main(String[] args) throws IOException{
		HashSet<String> words = new HashSet<String>();

		System.out.println("\n" + "Please enter the filename");

		Scanner userInput = new Scanner(System.in);
		String fileName = userInput.next().trim();
		Scanner file = new Scanner(new File(fileName));

		while(file.hasNext()) {
			words.add(file.next());
		}

		System.out.println(words.size());
	}
}