public abstract class Animal {
	protected int legs;

	protected Animal() {
		legs = 0;
	}

	abstract public void walk();
	abstract public void eat();
}