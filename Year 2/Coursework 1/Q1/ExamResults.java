import java.util.*;

class ExamResults{
	public static void main(String[] args){
	System.out.println('\n' + "Please enter Exam Results"); // Tell user how to use program
	System.out.println("Stop by entering a negative number");
	Scanner scan = new Scanner(System.in);	// User input
	ArrayList<Integer> results = new ArrayList<Integer>(); // ArrayList for the results
	int score;
	int highest = 0;
	int lowest = 0;
	int sum = 0;
	int aGrade = 0;
	int bGrade = 0;
	int cGrade = 0;
	int dGrade = 0;
	int fGrade = 0;
	
	do{	// Takes integers from the user input untill a negative number is entered
		score = scan.nextInt();
		if(score >= 0 && score <= 100){ // Checks if the input is a valid mark
			results.add(score);
		}
	} while (score >= 0);

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


