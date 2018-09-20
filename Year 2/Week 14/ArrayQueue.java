public class ArrayQueue{
	private Object[] array;
	private int front, back;
	public static final int MAX = 100;

	public ArrayQueue() {
		front = 0;
		back = 0;
		array = new Object[MAX];
	}

	public Object head() {
		return array[front];
	}

	public Object tail() {
		return array[back];
	}

	public void leave() {
		if(back > 0) {
			back--;
		}
		for(int i = 0; i < array.length; i++) {
			array[i] = array[i+1];
			if(array[i+1] == null) {
				break;
			}
		}
	}

	public void join(Object obj) {
		if(this.isEmpty()) {
			array[front] = obj;
		}
		else {
			back++;
			array[back] = obj;
		}
	}

	public boolean isEmpty() {
		return (array[front] == null && array[back] == null);
	}
}