import java.util.ArrayList;
import java.util.LinkedList;

public class JavaPracticeBinaryTrees {


	public static void main(String[] args) {
		BinaryTree test = testBinaryTree();
		print(test.DFSBinaryTree());
		print(test.BFSBinaryTree());
		BinarySearchTree bstTest = testBinarySearchTree();
		print(bstTest.BFSBinarySearchTree());
		BinarySearchTree ptr = bstTest.balance();
		while(ptr.getRight() != null) {
			System.out.print(ptr.getValue() + " ");
			ptr = ptr.getRight();
		}
		System.out.println();
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

	public static BinarySearchTree testBinarySearchTree() {
		BinarySearchTree bst = new BinarySearchTree(5);
		BinarySearchTree ptr;
		bst.add(6);
		bst.add(7);
		bst.add(3);
		bst.add(4);
		bst.add(9);
		bst.add(1);
		return bst;
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

		public void setLeft(BinaryTree value) { this.left = value; }

		public void setRight(BinaryTree value) { this.right = value; }

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

	private static class BinarySearchTree {
		private BinarySearchTree left;
		private BinarySearchTree right;
		private int value;

		public BinarySearchTree getLeft() { return left; }

		public BinarySearchTree getRight() { return right; }

		public void setLeft(int value) { this.left = new BinarySearchTree(value); }

		public void setRight(int value) { this.left = new BinarySearchTree(value); }

		public void setLeft(BinarySearchTree left) { this.left = left; }

		public void setRight(BinarySearchTree right) { this.right = right; }

		public int getValue() { return value; }

		public BinarySearchTree(int value) { 
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public BinarySearchTree() {
			this.value = -1;
			this.left = null;
			this.right = null;
		}

		public void add(int value) {
			if(value < this.value) {
				if(this.left == null) {
					this.left = new BinarySearchTree(value);
				} else {
					this.left.add(value);
				}
			} else {
				if(this.right == null) {
					this.right = new BinarySearchTree(value);
				} else {
					this.right.add(value);
				}
			}
		}

		private ArrayList<Integer> BFSBinarySearchTree() {
			LinkedList<BinarySearchTree> bfsQueue = new LinkedList<BinarySearchTree>();
			ArrayList<Integer> returnList = new ArrayList<Integer>();
			BinarySearchTree ptr = this;
			bfsQueue.add(ptr);
			while(bfsQueue.size() > 0) {
				ptr = bfsQueue.removeFirst();
				if(ptr.left != null) bfsQueue.add(ptr.left);
				if(ptr.right != null) bfsQueue.add(ptr.right);
				returnList.add(ptr.getValue());
			}
			return returnList;
		}

		private BinarySearchTree balance() {
			BinarySearchTree bst = new BinarySearchTree();
			bst.setRight(this);
			bst.vineFromTree();
			bst.treeToVine();
			return bst;

		}

		private void vineFromTree() {
			BinarySearchTree ptr = this;
			BinarySearchTree rest = this.getRight();
			BinarySearchTree temp;

			while(rest != null) {
				if(rest.getLeft() == null) {
					ptr = rest;
					rest = ptr.getRight();
				} else {
					temp = rest.getLeft();
					rest.setLeft(temp.getRight());
					temp.setRight(rest);
					rest = temp;
					ptr.setRight(rest);
				}
			}
		}

		private void treeToVine() {
			BinaryTree ptr = this.right();
			int counter = 0;
			while(ptr != null) {
				ptr++;
				ptr = ptr.getRight();
			}

			
		}
	}
}













