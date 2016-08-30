
import java.util.Arrays;
import java.lang.Math;

public class JavaPracticeAbsoluteDifference {


	public static void main(String[] args) {
		int[] array = testArrays();
		System.out.print(findAbsoluteDifference(array));
	}

	public static int[] testArrays() {
		return new int[]{2,-1,-2,1,-4,2,8};
	}

	public static Integer findAbsoluteDifference(int[] array) {
		Arrays.sort(array);

		int sum = 0;
		for(int i : array) {
			sum += i;
		}
		int reverseSum = 0;
		int difference = -1;
		for(int i = array.length - 1; i >= 0; i--) {
			sum -= array[i];
			reverseSum += array[i];
			if(Math.abs(sum - reverseSum) > difference) {
				difference = Math.abs(sum - reverseSum);
			}
		}
		return difference;
	}
}