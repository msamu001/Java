class testResult{
	public static void main(String[] args){
		int[] result = {30,40,50,60,70,80};	// Int Array
		ExamResultsQ3 test = new ExamResultsQ3("Maths"); // New class
		
		// Testing functions
		System.out.println("\n" + "Subject: " + test.getModuleName());
		test.setMarks(result);
		test.readMarks();
		test.printReport();
	}
}