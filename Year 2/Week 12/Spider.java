public class Spider extends Animal {
	public Spider() {
		super.legs = 8;
	}

	public void walk() {
		System.out.println("Walks on web");
	}

	public void eat() {
		System.out.println("Eats insects");
	}
}