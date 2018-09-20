class Teacher extends Person
{
	protected String subject;
	protected double salary;

	public Teacher(String n, int a, String g,  String s, double income)
	{
		super(n,a,g);
		subject = s;
		salary = income;
	}

	public void setSubject(String s)
	{
		subject = s;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSalary(Double s)
	{
		salary = s;
	}

	public double getSalary()
	{
		return salary;
	}

	public String toString()
	{
		return super.toString() + ", subject: " + subject + ", salary: " + String.valueOf(salary);
	}
}