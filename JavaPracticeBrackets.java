import java.util.ArrayList;
import java.util.Stack;

public class JavaPracticeBrackets {


	private static boolean ordering(String input, String ordering) {
		int length = input.length();
		int[] hashmap = new int[128];
		for (int i = 0; i < length; i++) {
			hashmap[input.charAt(i)] = i;
		}

		for( int i = 0; i < ordering.length() - 1; i++) {
			if (!(hashmap[ordering.charAt(i)] < hashmap[ordering.charAt(i + 1)]))
			{
				return false;

			}
		}
		return true;
	}

	private static int findIndexOfClosingBracket(String line) {
		Stack<int> myStack = new Stack<>();
		for(char i : String line) {
			if(i == '(') {
              myStack.push(1);
			} else if(i == ')') {
				myStack.pop();
				if(myStack.top() == null) {
					return i;
				}
			}
		}
		return line.length();
	}

	private static ArrayList<String> braceExpansion(String input) {
		ArrayList<String> list;
		for (int i = 0; i < input.length(); i++) {
			if( input.charAt(i) == '(') {
				int end = findIndexOfClosingBracket(input.substring(i, input.length()));
                list.addAll(braceExpansion(input.substring(i, end)));
                i = end;
			}
			else if (input.indexOf(',') == -1) {
				list.add(input.substring(i, input.length()));
				return;
			}
			else {
				list.add(input.substring(i, input.indexOf(i, ',')));
			}
		}
		return list;
	}

	private static void testOrdering() {
		String[] inputs = new String[] {"hello world!", "hello world!", "hello world!", "aaaabbbcccc"};
		String[] orderings = new String[] {"hlo!", "!od", "he!", "ac"};
		for(int i = 0; i < 4; i++) {
			System.out.println("Input: " + inputs[i] + ", ordering: " + orderings[i] + ", result: " + ordering(inputs[i], orderings[i]));
		}
	}

	public static void main(String[] args) {
		testOrdering();
		ArrayList<String> list = braceExpansion("((a,b)o")
	}
}