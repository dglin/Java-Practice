

public class JavaPracticeBinarySearchTreeArray {


	private static int ceilingPower2(int num) {
		if (num < 0) return -1;
		int ptr = 1;
		while( (ptr = ptr << 1) < num );
		return ptr;
	}

	public static void main(String[] args) {
		ArrayBinarySearchTree myTree = new ArrayBinarySearchTree(10, 11);

		myTree.insert(12);
		myTree.insert(8);
		myTree.insert(15);
		myTree.insert(9);
		myTree.insert(7);
		myTree.print();
	}

	private static class ArrayBinarySearchTree {
		int[] array;
		public ArrayBinarySearchTree(int size) {
			this.array = new int[ceilingPower2(size) - 1];
		}

		public ArrayBinarySearchTree(int size, int head) {
			this.array = new int[ceilingPower2(size) - 1];
			this.array[0] = head;
		}

		public void insert(int num) {
			int frame = this.array.length;
			for (int i = 0; i < frame; i++) {
				if (this.array[i] == 0) {
					this.array[i] = num;
					break;
				} else if (this.array[i] < num) {
					i = i + ((frame - i) / 2);
				} else {
					frame = (this.array.length / 2);
				}
			}
		}

		public void print() {
			for (int i = 0; i < array.length; i++) {
				System.out.print(this.array[i] + " ");
			}
		}
	}
}