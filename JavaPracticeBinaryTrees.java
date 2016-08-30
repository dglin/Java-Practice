import java.util.ArrayList;
import java.util.LinkedList;

public class JavaPracticeBinaryTrees {


	public static void main(String[] args) {
		BinaryTree test = testBinaryTree();
		print(test.DFSBinaryTree());
		print(test.BFSBinaryTree());
		// print(test.prettyPrintBinaryTree());
	}

	public static void print(ArrayList<Integer> list) {
		for(int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static BinaryTree testBinaryTree() {
		BinaryTree binaryTree = new BinaryTree(0);
		BinaryTree ptr;
		binaryTree.setLeft(1);
		binaryTree.setRight(2);
		ptr = binaryTree.getLeft();
		ptr.setLeft(3);
		ptr.setRight(4);
		ptr = binaryTree.getRight();
		ptr.setLeft(5);
		ptr.setRight(6);
		return binaryTree;
	}

	private static class BinaryTree {

		private BinaryTree left;
		private BinaryTree right;
		private int dataValue;

		public BinaryTree(int value) {
			dataValue = value;
			left = null;
			right = null;
		}

		public int getDataValue() { return dataValue; }

		public void setLeft(int value) { this.left = new BinaryTree(value); }

		public void setRight(int value) { this.right = new BinaryTree(value); }

		public BinaryTree getLeft() { return left; }

		public BinaryTree getRight() { return right; }

		private ArrayList<Integer> DFSBinaryTree() {
			ArrayList<Integer> returnList = new ArrayList<Integer>();
			if(left != null) {
				returnList.addAll(left.DFSBinaryTree());
			}
			if(right != null) {
				returnList.addAll(right.DFSBinaryTree());
			}
			returnList.add(dataValue);
			return returnList;
		}

		// Using a linked list as a Queue for simplicity sake.
		private ArrayList<Integer> BFSBinaryTree() {
			LinkedList<BinaryTree> bfsQueue = new LinkedList<BinaryTree>();
			ArrayList<Integer> returnList = new ArrayList<Integer>();
			BinaryTree ptr = this;
			bfsQueue.add(ptr);
			while(bfsQueue.size() > 0) {
				ptr = bfsQueue.removeFirst();
				if(ptr.left != null) bfsQueue.add(ptr.left);
				if(ptr.right != null) bfsQueue.add(ptr.right);
				returnList.add(ptr.getDataValue());
			}
			return returnList;
		}
	}
}