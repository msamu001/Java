import java.util.*;
import java.io.*;

class TestSpellchecker{
	public static void main(String[] args) throws IOException{
		System.out.println("\n" + "Please enter the file name"); // Ask for user input
		Scanner scan = new Scanner(System.in);
		Spellchecker testSC = new Spellchecker(scan.next());
	}
}