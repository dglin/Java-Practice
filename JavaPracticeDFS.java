

public class JavaPracticeDFS {


	public static void main (String[] args) {


		int[][] test = new int[3][5];
		test[0][4] = 1;
		test[1][0] = 1;
		test[1][1] = 1;
		test[1][2] = 1;
		test[1][3] = 1;
		test[1][4] = 1;
		test[2][2] = 1;
		for(int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(" " + test[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(findTopRow(test));
	}

	private static boolean findTopRow(int[][] input) {
		boolean result = false;
		for(int i = 0; i < input[0].length; i++) {
			if(input[0][i] == 1) {
				result = checkReachesBottom(input,i,0);
			}
		}
		return result;
	}

	private static boolean checkReachesBottom(int[][] input, int x_index, int y_index) {
		input[y_index][x_index] = 0;
		System.out.println("Made it: " + x_index + "|" + y_index);
		if(y_index == input.length - 1) {
			return true;
		}
		if(y_index + 1 < input.length && input[y_index + 1][x_index] == 1) {
			if(checkReachesBottom(input,x_index, y_index + 1)) {
				return true;
			}
		} else if(input[0].length > x_index + 1 && input[y_index][x_index + 1] == 1) {
			if(checkReachesBottom(input,x_index + 1, y_index)) {
				return true;
			}
		} else if( 0 < x_index - 1 && input[y_index][x_index - 1] == 1) {
			System.out.println("Hello");
			if(checkReachesBottom(input,x_index - 1, y_index))
			{
				return true;
			}
		}
		return false;
	}
}