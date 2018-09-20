import java.util.*;

public class ArrayListStack{
	private ArrayList<Object> array;

	public ArrayListStack() {
		array = new ArrayList<>();
	}

	public Object top() { // Returns last element added stack
		// Returns null if stack is empty
		if (this.isEmpty()) {
			return null;
		} else {
			return array.get(array.size()-1);
		}
	}

	public void pop() {
		// Ends function if the stack array is empty
		if (this.isEmpty()) {
			return;
		} else {
			array.remove(array.size()-1);
		}
	}

	public void push(Object o) {
		array.add(o);
	}

	public int size() { // Returns stack size
		return array.size();
	}

	public boolean isEmpty() {
		return array.size() == 0;
	}
}