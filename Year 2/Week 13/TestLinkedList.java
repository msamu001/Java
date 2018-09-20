import java.util.*;

public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> testList = new LinkedList<Integer>();

		// (a) i.
		for (int i = 1; i <= 20; i++) {
			testList.add(i);
		}

		// (a) ii.
		System.out.print("\n" + "LinkedList"); // Label
		printLinkedList(testList);

		// (a) iii.
		testList.add(0, 21);
		testList.add(0);

		// (a) iv.
		System.out.print("\n" + "LinkedList"); // Label
		printLinkedList(testList);

		// (a) v.
		System.out.println("\n" + "\n" + "First Element" + "\n" + testList.get(0));
		System.out.println("\n" + "Last Element" + "\n" + testList.get(21));

		// (a) vi.
		testList.remove(21);

		// (a) vii.
		System.out.print("\n" + "LinkedList"); // Label
		printLinkedList(testList);

	}

	public static void printLinkedList(LinkedList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			if(i % 5 == 0) {
				System.out.println();
			}
			System.out.print(a.get(i) + "\t");
		}
		System.out.println();
	}
}