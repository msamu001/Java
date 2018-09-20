import java.util.*;

public class LinkedListQueue{
	private LinkedList<Object> list;
	private int front, back;

	public LinkedListQueue() {
		list = new LinkedList<>();
		front = 0;
		back = 0;
	}

	public Object head() {
		return list.get(front);
	}

	public Object tail() {
		return list.get(back);
	}

	public void leave() {
		if(back > 0) {
			back--;
		}
		for(int i = 0; i < list.size(); i++) {
			if(i == list.size()-1) {
				list.remove(i);
			} else {
				list.set(i, list.get(i+1));
			}
		}
	}

	public void join(Object obj) {
		if(this.isEmpty()) {
			list.add(obj);
		} else {
			back++;
			list.add(obj);
		}
	}

	public boolean isEmpty() {
		return (list.size() == 0);
	}
}