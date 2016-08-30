public class JavaPracticeLinkedList {


	public static void main(String[] args) {
		testFrontOfList();
		testEndOfList();
		testReverseLinkedList();
	}

	/******************************************************
	*  Iterative Linked List
	******************************************************/
	private static class ListNode {
		private int num;
		private ListNode nextNode;
		public ListNode(int num) {
			this.num = num;
			nextNode = null;
		}
		public void setNext(ListNode next) {
            nextNode = next;
		}
		public ListNode getNext() {
            return this.nextNode;
		}
		public int getNum() {
			return num;
		}
	}

	private static class LinkedList {
		private ListNode head;
		public LinkedList(int num) {
			this.head = new ListNode(num);
		}
		public void addToFrontOfList(int num) {
            ListNode tempNode;
            tempNode = this.head;
            this.head = new ListNode(num);
            this.head.setNext(tempNode);
		}
		public void addToEndOfList(int num) {
			ListNode ptr = this.head;
			while(ptr.getNext() != null) {
				ptr = ptr.getNext();
			}
			ptr.setNext(new ListNode(num));
		}
		public void reverse() {
            ListNode ptr = this.head;
            ListNode prev = null;
            ListNode next = null;
            while(ptr != null) {
            	next = ptr.getNext();
            	ptr.setNext(prev);
            	prev = ptr;
            	ptr = next;
            }
            ptr = prev;
            this.head = ptr;
		}
		public void printList() {
			ListNode ptr = this.head;
			while(ptr.getNext() != null) {
            	System.out.print(ptr.getNum() + " ");
            	ptr = ptr.getNext();
			}
			System.out.println(ptr.getNum());
		}
	}
	/******************************************************
	* Tests
	******************************************************/

	private static void testFrontOfList() {
		LinkedList testList = new LinkedList(1);
        testList.addToFrontOfList(2);
        testList.addToFrontOfList(3);
        testList.addToFrontOfList(4);
        testList.addToFrontOfList(5);
        testList.addToFrontOfList(6);
        testList.addToFrontOfList(7);
        System.out.println("Should print 1 - 7 in descending order: ");
        testList.printList();
	}

	private static void testEndOfList() {
		LinkedList testList = new LinkedList(1);
		testList.addToEndOfList(2);
        testList.addToEndOfList(3);
        testList.addToEndOfList(4);
        testList.addToEndOfList(5);
        testList.addToEndOfList(6);
        testList.addToEndOfList(7);
        System.out.println("Should print 1 - 7 in acscending order: ");
        testList.printList();
	}

	private static void testReverseLinkedList() {
	    LinkedList testList = new LinkedList(1);
		testList.addToEndOfList(2);
        testList.addToEndOfList(3);
        testList.addToEndOfList(4);
        testList.addToEndOfList(5);
        System.out.println("Should print 1 - 5 in acscending order: ");
        testList.printList();
        testList.reverse();
        System.out.println("Should print 1 - 5 in descending order: ");
        testList.printList();

	}

}