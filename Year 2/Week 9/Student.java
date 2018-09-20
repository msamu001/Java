class Student extends Person
{
  protected String idNum;    // Student Id Number
  protected double averageMark;      // grade point average

  public Student(String n, int a, String g,  String id, double average)
  {
    super(n,a,g);  // inherite from person

    //initialize the new instance variables for students
    idNum = id;
    averageMark = average;
  }
}