class Person
{
  protected String name ;   // name of the person
  protected int age;        // person's age
  protected String gender;  // "M" for male, "F" for female
 
  public Person(String n, int a, String g) // constructor
  {
    name = n; age = a ; gender = g;
  }

  public void setName(String n)
  {
    name = n;
  }

  public String getName()
  {
    return name;
  }

  public void setAge(int a)
  {
    age = a;
  }

  public int getAge()
  {
    return age;
  }

  public void setGender(String g)
  {
    gender = g;
  }

  public String getGender()
  {
    return gender;
  }
 
  public String toString()
  {  
    return name + ", age: " + age + ", gender: " + gender;
  }
}