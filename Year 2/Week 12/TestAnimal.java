public class TestAnimal {
	public static void main(String[] args) {
		Cat testCat = new Cat();
		Cat testCat2 = new Cat("Red");
		Fish testFish = new Fish();
		Animal testSpider = new Spider();

		// Test Cat
		testCat.setName("Blue");
		System.out.println("\n" + testCat.getName() + " the cat");
		testCat.play();
		testCat.eat();
		testCat.walk();
		System.out.println();

		// Test Spider
		testSpider.walk();
		testSpider.eat();
		System.out.println();

		// Test Fish
		testFish.setName("Magik");
		System.out.println(testFish.getName() + " the fish");
		testFish.walk();
		testFish.eat();
	}
}