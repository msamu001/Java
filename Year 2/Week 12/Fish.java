public class Fish extends Animal implements Pet {
	protected String name;

	public Fish() {}

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
		System.out.println("Does not walk");
	}

	public void eat() {
		System.out.println("Eats fish food");
	}
}