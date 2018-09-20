public class ArrayListQueueDemo {
	public static void main(String[] args) {
		ArrayListQueue testQueue = new ArrayListQueue();

		// Tests
		System.out.println("\n"+"isEmpty: "+testQueue.isEmpty()+"\n");

		// Test join
		System.out.println("Test join");
		testQueue.join("human");
		testQueue.join("centipede");
		System.out.println("front: "+testQueue.head());
		System.out.println("back: "+testQueue.tail());
		System.out.println("isEmpty: "+testQueue.isEmpty() + "\n");

		// Test leave
		System.out.println("Test leave");
		System.out.println("front: "+testQueue.head());
		testQueue.leave();
		System.out.println("front: "+testQueue.head());
		testQueue.leave();
		System.out.println("isEmpty: "+testQueue.isEmpty() + "\n");	
	}
}