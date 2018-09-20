import java.util.*;

public class ArrayListQueue{
	private ArrayList<Object> array;
	private int front, back;

	public ArrayListQueue() {
		array = new ArrayList<>();
		front = 0;
		back = 0;
	}

	public Object head() {
		return array.get(front);
	}

	public Object tail() {
		return array.get(back);
	}

	public void leave() {
		if(back > 0) {
			back--;
		}
		for(int i = 0; i < array.size(); i++) {
			if(i == array.size()-1) {
				array.remove(i);
			} else {
				array.set(i, array.get(i+1));
			}
		}
	}

	public void join(Object obj) {
		if(this.isEmpty()) {
			array.add(obj);
		} else {
			back++;
			array.add(obj);
		}
	}

	public boolean isEmpty() {
		return (array.size() == 0);
	}
}