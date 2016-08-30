import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class JavaPracticeBinarySearch {

	public static void main(String[] args) {

		ArrayList<Integer> test = testArray();
		System.out.println("--------Regular Recursive Search-----------");
		for(int i : test) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("Search for 543 is: " + recursiveSearch(test, 543));
		System.out.println("Search for 2 is: " + recursiveSearch(test, 2));
		System.out.println("Search for 8 is: " + recursiveSearch(test, 8));

		ArrayList<Integer> test2 = testArray();
		test2.add(12);

		for(int i : test2) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("Search for 543 is: " + recursiveSearch(test2, 543));
		System.out.println("Search for 2 is: " + recursiveSearch(test2, 2));
		System.out.println("Search for 543 is: " + recursiveSearch(test2, 932));
		System.out.println("Search for 8 is: " + recursiveSearch(test2, 8));
		System.out.println("Search for 12 is: " + recursiveSearch(test2, 12));

		System.out.println("--------Binary Search----------");

		for(int i : test) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("Search for 543 is: " + binarySearch(test, 543));
		System.out.println("Search for 2 is: " + binarySearch(test, 2));
		System.out.println("Search for 8 is: " + binarySearch(test, 8));

		for(int i : test2) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("Search for 543 is: " + binarySearch(test2, 543));
		System.out.println("Search for 2 is: " + binarySearch(test2, 2));
		System.out.println("Search for 543 is: " + binarySearch(test2, 932));
		System.out.println("Search for 8 is: " + binarySearch(test2, 8));
		System.out.println("Search for 12 is: " + binarySearch(test2, 12));
	}

	public static ArrayList<Integer> testArray() {
		return new ArrayList<Integer>() {
			{
				add(9);
				add(1);
				add(2);
				add(4);
				add(543);
				add(543);
				add(21);
				add(932);
			}
		};
	}

	public static boolean binarySearch(List<Integer> list, int target) {
		Collections.sort(list);
		return binarySearchHelper(list,target);
	}

	public static boolean recursiveSearch(List<Integer> list, int target) {
		int index = list.size() / 2;
		// Print stack
		// System.out.println(list.toString());
		if (index == 0) {
			return list.get(0) == target;
		}
		return recursiveSearch(list.subList(0,index), target) || recursiveSearch(list.subList(index, list.size()), target);
	}

	public static boolean binarySearchHelper(List<Integer> list, int target) {
		int index = list.size() / 2;
		//Print stack
		System.out.println(list.toString());
		if (index == 0) {
			return list.get(0) == target;
		}
		if(list.get(index) == target) {
			return true;
		} else if(list.get(index) < target) {
			return binarySearchHelper(list.subList(index,list.size()), target);
		} else {
			return binarySearchHelper(list.subList(0, index), target);
		} 
	}
}