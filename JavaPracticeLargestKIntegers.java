import java.util.Random;
import java.util.PriorityQueue;


/**
*	When K is large relative to N. The optimal solutiom for small K is to use a hashMap (for small N) or just use 10 temp variables for O(k * n)
*   Time complexity. However with large K, it is better to use this solution, with a time complexity of O(n log k), with average case of
*   O(n/k log k)
*/
public class JavaPracticeLargestKIntegers {
	public static void main(String[] args) {
		int[] randInts = randInts(1000);
		int[] largestKints = largestKIntegers(randInts, 10);
		for(int j = 0; j < largestKints.length; j++) {
			System.out.print(largestKints[j] + " ");
		}
	}
	private static int[] largestKIntegers(int[] array, int k) {
		PriorityQueue<Integer> minOfMaxes = new PriorityQueue();
		for (int i = 0; i < k; i++) {
			minOfMaxes.add(array[i]);
		}
		for(int i = k; i < array.length; i++) {
			if(minOfMaxes.peek() <  array[i]) {
				minOfMaxes.poll();
				minOfMaxes.add(array[i]);
			}
		}
		// Gotta be a better way to do this
		int[] retArray = new int[k];
		for (int i = 0; i < k; i++) {
			retArray[i] = minOfMaxes.poll();
		}
		return retArray;
	}
	private static int[] randInts( int size) {
		Random rand = new Random();
		int[] ret = new int[size];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = rand.nextInt(2147483647);
		}
		return ret;
	}
}