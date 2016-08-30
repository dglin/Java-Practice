import java.util.ArrayList;

public class JavaPracticeMergeSort {

	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<>();
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(2);
		test.add(6);
		test.add(9);
		test.add(2);
		test.add(8);
		test.add(4);
		test.add(7);
		test.add(10);
		System.out.println(test);
        test = mergesort(test);
        System.out.println(test);
	}

	private static ArrayList<Integer> mergesort(ArrayList<Integer> input) {
		if(input.size() == 1) {
         	return input;
		} else {
			return merge(mergesort(new ArrayList<>(input.subList(0,input.size() / 2))),mergesort(new ArrayList<>(input.subList(input.size() / 2, input.size()))));
		}
	}

	private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
		ArrayList<Integer> returnList = new ArrayList<>();
		while(left.size() > 0 && right.size() > 0) {
			if(left.get(0) <= right.get(0)) {
				returnList.add(left.remove(0));
			} else {
				returnList.add(right.remove(0));
			}
		}
		if (left.size() > 0) {
			returnList.addAll(left);
		} else {
			returnList.addAll(right);
		}
		return returnList;
	}

}