import java.util.*;
import java.io.*;

class ExamResultsQ2{
	public static void main(String[] args) throws IOException{
		ArrayList<Integer> results = new ArrayList<Integer>(); // ArrayList for the results
		int highest = 0;
		int lowest = 0;
		int sum = 0;
		int aGrade = 0;
		int bGrade = 0;
		int cGrade = 0;
		int dGrade = 0;
		int fGrade = 0;

		System.out.println('\n' + "Please enter File name"); // Tell user how to use program
		Scanner scan = new Scanner(System.in);	// User input
		String fileName = scan.next().trim();	// Gets filename from user, removes blank space
		Scanner file = new Scanner(new File(fileName)); // Scans through the file given by user
		file.nextLine(); // Skips fisrst line

		while(file.hasNext()){
			String[] split = file.nextLine().split("\t"); // Splits line at tab and adds to array
			results.add(Integer.parseInt(split[1])); // Takes marks from left side of space
		}

		for(int i = 0; i < results.size(); i++){ // Goes through results
			if(results.get(i) >= 70){ // Grade boundaries
				aGrade++;
			}
			if(results.get(i) >= 60 && results.get(i) < 70){ // Grade boundaries
				bGrade++;
			}
			if(results.get(i) >= 50 && results.get(i) < 60){ // Grade boundaries
				cGrade++;
			}
			if(results.get(i) >= 40 && results.get(i) < 50){ // Grade boundaries
				dGrade++;
			}
			if(results.get(i) >= 0 && results.get(i) < 40){ // Grade boundaries
				fGrade++;
			}
			if(results.get(i) > highest){ // Finds highest mark
				highest = results.get(i);
			}
			if(results.get(i) < lowest){ // Finds lowest mark
				lowest = results.get(i);
			}
			sum = sum + results.get(i); // Sum of all marks
		}

		// Prints Report
		System.out.println('\n' + "Total number grades " + results.size());
		System.out.println("Highest mark: " + highest);
		System.out.println("Lowest mark: " + lowest);
		System.out.println("Average mark: " + sum/results.size());
		System.out.println("Number of A Grades: " + aGrade);
		System.out.println("Number of B Grades: " + bGrade);
		System.out.println("Number of C Grades: " + cGrade);
		System.out.println("Number of D Grades: " + dGrade);
		System.out.println("Number of F Grades: " + fGrade);
	}
}