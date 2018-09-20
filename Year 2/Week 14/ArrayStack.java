public class ArrayStack{
	private Object[] array;
	private int count;
	public static final int MAX = 100;

	public ArrayStack() {
		array = new Object[MAX];
		count = 0;
	}

	public Object top() { // Returns last element added stack
		// Returns null if stack is empty
		if (this.isEmpty()) {
			return null;
		} else {
			return array[count-1];
		}
	}

	public void pop() {
		// Ends function if the stack array is empty
		if (this.isEmpty()) {
			return;
		} else {
			array[count-1] = null;
			count--;
		}
	}

	public void push(Object o) {
		array[count] = o;
		count++;
	}

	public int size() { // Returns stack size
		return count;
	}

	public boolean isEmpty() {
		return array[0] == null;
	}
}