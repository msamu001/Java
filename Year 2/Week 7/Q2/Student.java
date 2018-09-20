class Student{
	private String name;
	private long idNumber;
	private int yearOfStudy;
	private int examMarks;
	private String result;

	public Student(String newName, long newID, int newYearOfStudy, int score, String grade){
		name = newName;
		idNumber = newID;
		newYearOfStudy = yearOfStudy;
		examMarks = score;
		result = grade;
	}
	
	public void setName(String n){
		name = n;
	}

	public String getName(){
		return name;
	}

	public void setIdNumber(long id){
		idNumber = id;
	}

	public long getIdNumber(){
		return idNumber;
	}

	public void setYearOfStudy(int y){
		yearOfStudy = y;
	}

	public int getYearOfStudy(){
		return yearOfStudy;
	}

	public void setExamMark(int m){
		examMarks = m;
	}

	public int getExamMark(){
		return examMarks;
	}

	public void setResult(String r){
		result = r;
	}

	public String getResult(){
		return result;
	}

	public String toString(){
		return ("\n" + "Name: " + this.getName() +
				"\n" + "ID Number: " + this.getIdNumber() +
				"\n" + "Year of Study: " + this.getYearOfStudy() +
				"\n" + "Exam Mark: " + this.getExamMark() +
				"\n" + "Result: " + this.getResult());
	}

	public void printDetails(){
		System.out.println(this.toString());
	}
}