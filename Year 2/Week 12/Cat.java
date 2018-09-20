public class Cat extends Animal implements Pet {
	protected String name;
	
	public Cat(String n) {
		name = n;
		super.legs = 4;
	}

	public Cat() {
		this(null);	
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public void play() {
		System.out.println("Plays with yarn");
	}

	public void walk() {
		System.out.println("Walks on fence");
	}

	public void eat() {
		System.out.println("Eats fish");
	}
}