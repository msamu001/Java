class UnderGradStudent extends Student
{
	protected int year;
	protected String major;

	public UnderGradStudent(String n, int a, String g,  String id, double average, int y, String m)
	{
		super(n,a,g,id,average);
		year = y;
		major = m;
	}

	public void setYear(int y)
	{
		year = y;
	}

	public int getYear()
	{
		return year;
	}

	public void setMajor(String m)
	{
		major = m;
	}

	public String getMajor()
	{
		return major;
	}

	public String toString()
	{
		return super.toString() + ", ID: " + super.idNum + ", average mark: " + String.valueOf(super.averageMark) + ", year: " + String.valueOf(year) + ", major: " + major;
	}
}