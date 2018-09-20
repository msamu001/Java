public class LinkedListStackDemo {
	public static void main(String[] args) {
		LinkedListStack testStack = new LinkedListStack();

		// Tests
		System.out.println("\n"+"isEmpty: "+testStack.isEmpty()+"\n");

		// Test push
		System.out.println("Test push");
		testStack.push(1);
		System.out.println("top: "+testStack.top());
		testStack.push(true);
		System.out.println("top: "+testStack.top());
		testStack.push("three");
		System.out.println("top: "+testStack.top());
		System.out.println("size: "+testStack.size());
		System.out.println("isEmpty: "+testStack.isEmpty()+"\n");

		// Test pop
		System.out.println("Test pop");
		System.out.println("top: "+testStack.top());
		testStack.pop();
		System.out.println("top: "+testStack.top());
		testStack.pop();
		System.out.println("top: "+testStack.top());
		testStack.pop();
		System.out.println("size: "+testStack.size());
		System.out.println("isEmpty: "+testStack.isEmpty()+"\n");	
	}
}