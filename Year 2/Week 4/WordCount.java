import java.util.Scanner;
import java.io.*;

public class WordCount {
	public static void main(String[] args) throws IOException{
		int wordCount = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter file name");

		String fileName = scan.next().trim();
		Scanner file = new Scanner(new File(fileName));
		while(file.hasNext()){
			String temp = file.next();
			wordCount++;
		}
		System.out.println("Total words = " + wordCount);
	}
}