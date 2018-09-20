class main{
	public static void main(String[] args){
		Person testPerson = new Person("Kelly", 22, "F");
		Person testTeacher = new Teacher("Fanyo", 43, "M", "Maths", 48000);
		Person testStudent = new Student("Ben", 18, "M", "026429", 73);
		Person testUGS = new UnderGradStudent("Vanessa", 25, "F", "152399", 59, 1, "Psychology");

		System.out.println("\n" + testPerson.toString());
		System.out.println(testTeacher.toString());
		System.out.println(testStudent.toString());
		System.out.println(testUGS.toString() + "\n");
	}
}