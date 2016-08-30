// https://www.careercup.com/question?id=16759664

// List 1: [4, 10, 15, 24, 26]
// List 2: [0, 9, 12, 20]
// List 3: [5, 18, 22, 30] 

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class JavaPracticeKListOfSortedIntegers {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1 = new ArrayList<Integer>() {{
			add(4);
			add(10);
			add(15);
			add(24);
			add(26);
		}};

		ArrayList<Integer> list2 = new ArrayList<Integer>() {{
			add(0);
			add(9);
			add(12);
			add(20);
		}};

		ArrayList<Integer> list3 = new ArrayList<Integer>() {{
			add(5);
			add(18);
			add(22);
			add(30);
		}};

		test.add(list1);
		test.add(list2);
		test.add(list3);

		for(int index = 0; index < test.size(); index++) {
			System.out.print("List " + index + ": ");
			for (int i : test.get(index)) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		Result ret = getRange(test);
		System.out.println(ret.min + "," + ret.max + " | " + ret.range);
	}

	public static Result getRange(ArrayList<ArrayList<Integer>> listOfLists) {

		int minRange = 999999;
		int minIndex = 0;
		int min,max,range;
		Result storedResult = null;


		while(true) {
			min = 999999;
			max = -1;
			for(int i = 0; i < listOfLists.size(); i++) {
				if(listOfLists.get(i).get(0) < min) {
					min = listOfLists.get(i).get(0);
					minIndex = i;
				}
				if(listOfLists.get(i).get(0) > max) {
					max = listOfLists.get(i).get(0);
				}
			}
			if(max - min < minRange) {
				storedResult = new Result(min,max,max - min);
			}

			listOfLists.get(minIndex).remove(0);
			if(listOfLists.get(minIndex).size() == 0) {
				return storedResult;
			}
		}
	}

	// public static List<Integer> getRange(List<List<Integer>> listOfLists) {
	// 	int size = listOfLists.size()
	// 	int[] hashMap = new int[listOfLists.size()];

	// 	int counter = 0;
	// 	int firstMin = 0;
	// 	for(List<Integer> list : listOfLists) {
	// 		hashMap[counter] = list.get(0);
	// 		list.remove(0);
	// 		counter++;
	// 	}

	// 	while()


	// }

	// private static Result getResult(List<List<Integer>> listOfLists, int size) {
	// 	int min = 99999999;
	// 	int max = -1;
	// 	int range;
	// 	for (int i = 0; i < size; i++) {
	// 		if(listOfLists.get(0) < min) {
	// 			min = hashMap[i];
	// 		}
	// 		if(listOfLists.get(0) < max) {
	// 			max = hashMap[i];
	// 		}
	// 	}
	// 	return new Result(min,max,max - min);
	// }

	// private class Node {
	// 	public int list;
	// 	public int value;
	// 	public Node(int list, int value) {
	// 		this.list = list;
	// 		this.value = value;
	// 	}
	// }

	private static class Result {
		public int min;
		public int max;
		public int range;
		public Result(int min, int max, int range) {
			this.min = min;
			this.max = max;
			this.range = range;
		}
	}

	// public static List<Integer> getRange(List<List<Integer,Integer>> listOfLists) {
	// 	List<Node> list = combineLists(listOfLists);
	// 	int size = listOfLists.size();

	// 	PriorityQueue<Node> heap = new PriorityQueue<Node>();
	// 	heap.add(list.get(0));
	// 	heap.add(list.get(1));
	// 	heap.add(list.get(2));

	// 	int max = list.get(2);
	// 	int min = list.get(0);
		
	// 	list.remove(0);
	// 	list.remove(0);
	// 	list.remove(0);

	// 	int range = 9999;

	// 	ArrayList<Result> resultList = new ArrayList<Result>();

	// 	while(list.size() > 0) {
	// 		min = PriorityQueue.peek();
	// 		if(max - min < range) {
	// 			range = max - min;
	// 			resultList.add(new Result(min,max,range));
	// 		}


	// 	}
	// }

	// private class nodeComparator implements Comparator<Node> {
	// 	@Override
	// 	public int compare(Node node1, Node node2) {
	// 		return node1.value < node2.value;
	// 	}
	// }

	// private static List<Node> combineLists(List<List<Integer>> listOfLists) {
	// 	List<Node> newList;
	// 	int counter = 0;
	// 	for ( List<Integer> list : listOfLists) {
	// 		for (int i : list) {
	// 			newList.add(new Node(counter, i));
	// 		}
	// 		counter++;
	// 	}

	// 	//Collections.sort(newList, new nodeComparator());

	// 	return newList;
	// }

	// public static List<Integer> getRange(List<List<Integer>> listOfLists) {
	// 	List<Node> newList = combineLists(listOfLists);
	// 	HashMap<Integer, Boolean> valid = new HashMap<Integer, Boolean>();
	// 	int size = listOfLists.size();

	// 	for(int i = 0; i < size; i++) {
	// 		valid.put(i, false);
	// 	}

	// 	int min = 99999999;
	// 	for(Node node : newList) {
	// 		valid.put(node.list, true);


	// 	}
	// }
}








