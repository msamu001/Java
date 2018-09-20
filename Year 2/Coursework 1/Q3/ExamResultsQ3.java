import java.util.*;

public class ExamResultsQ3{
	private String moduleName;
	private int size;
	private int[] marks;
	
	public ExamResultsQ3(String subject){ // Constructor takes String and int array
		moduleName = subject;
		size = 0;
		marks = new int[size];
	}

	public void setSize(int s){
		size = s;
		marks = new int[size];
	}

	public void setMarks(int[] m){
		marks = m;
		size = m.length;
	}

	public void readMarks(){ // Prints all marks from array
		for(int i = 0; i < marks.length; i++){
			System.out.print(marks[i] + "\t");
		}
		System.out.println();
	}

	public void setModuleName(String n){ // Setter for moduleName
		moduleName = n;
	}

	public String getModuleName(){ // Getter for module name
		return moduleName;
	}

	public String toString(){ // Prints class variables as String
		return ("\n" + "Total number grades: " + marks.length +
				"\n" + "Highest mark: " + Integer.toString(this.getMax()) +
				"\n" + "Lowest mark: " + Integer.toString(this.getMin()) +
				"\n" + "Number of A Grades: " + Integer.toString(this.numberOfGradeA()) +
				"\n" + "Number of B Grades: " + Integer.toString(this.numberOfGradeB()) +
				"\n" + "Number of C Grades: " + Integer.toString(this.numberOfGradeC()) +
				"\n" + "Number of D Grades: " + Integer.toString(this.numberOfGradeD()) +
				"\n" + "Number of F Grades: " + Integer.toString(this.numberOfGradeF()));
	}

	public int getMin(){ // Returns smallest value from class array
		int min = 101;
		for(int i = 0; i < marks.length; i++){
			if(marks[i] < min){	// Checks if value is smaller
				min = marks[i];
			}
		}
		return min;
	}

	public int getMax(){ // Returns largest value from class array
		int max = 0;
		for(int i = 0; i < marks.length; i++){
			if(marks[i] > max){ // Checks if value is larger
				max = marks[i];
			}
		}
		return max;
	}

	public int numberOfGradeA(){ // Returns number of A grades in class
		int A = 0;
		for(int i = 0; i < marks.length; i++){
			if(marks[i] >= 70 && marks[i] <= 100){ // If inside grade boundary add 1 to count
				A++;
			}
		}
		return A;
	}

	public int numberOfGradeB(){ // Returns number of B grades in class
		int B = 0;
		for(int i = 0; i < marks.length; i++){
			if(marks[i] >= 60 && marks[i] < 70){ // If inside grade boundary add 1 to count
				B++;
			}
		}
		return B;
	}
	
	public int numberOfGradeC(){ // Returns number of C grades in class
		int C = 0;
		for(int i = 0; i < marks.length; i++){
			if(marks[i] >= 50 && marks[i] < 60){ // If inside grade boundary add 1 to count
				C++;
			}
		}
		return C;
	}

	public int numberOfGradeD(){ // Returns number of D grades in class
		int D = 0;
		for(int i = 0; i < marks.length; i++){
			if(marks[i] >= 40 && marks[i] < 50){ // If inside grade boundary add 1 to count
				D++;
			}
		}
		return 	D;
	}

	public int numberOfGradeF(){ // Returns number of F grades in class
		int F = 0;
		for(int i = 0; i < marks.length; i++){
			if(marks[i] >= 0 && marks[i] < 40){ // If inside grade boundary add 1 to count
				F++;
			}
		}
		return 	F;
	}

	public void printReport(){
		System.out.println(this.toString());
	}
}