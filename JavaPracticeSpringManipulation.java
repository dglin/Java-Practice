import java.util.HashMap;

public class JavaPracticeSpringManipulation {


	public static void main(String[] args) {
		System.out.println("Is abcsdefghijklmnopqrstuvwxy unique? " + uniqueChars("abcsdefghijklmnopqrstuvwxy"));
		System.out.println("Is abcdefghijklmnopqrstuvwxyz unique? " + uniqueChars("abcdefghijklmnopqrstuvwxyz"));

		System.out.println("Compressing \"aabcccccaaa\": " + compressString("aabcccccaaa"));
		System.out.println("Compressing \"\": " + compressString(""));
		System.out.println("Compressing \"abc\": " + compressString("abc"));

		System.out.println("Are these two permutations? \"abc\" , \"cba\": " + permutations("abc","cba"));
		System.out.println("Are these two permutations? \"dddddddd\" , \"ddddddd\": " + permutations("dddddddd","ddddddd"));
		System.out.println("Are these two permutations? \"applepie\" , \"pieapple\": " + permutations("applepie","pieapple"));
		System.out.println("Are these two permutations? \"abcdefg\" , \"abcaefg\": " + permutations("abcdefg","abcaefg"));

	}

	//1.1
	// Implement an algorithm to determine if a string has all unique
	// characters. What if you cannot use additional data structures
	public static boolean uniqueChars(String string){
		int[] hash = new int[127];

		for(int i = 0; i < string.length(); i++) {
			if(hash[string.charAt(i)] == 1) { return false; }
			hash[string.charAt(i)] = 1;
		}
		return true;
	}
	//1.5 Implement a method to perform basic string compression
	//using the counts of repeated characters. For example, 
	//the string aabcccccaaa would become a2blc5a3. 
	// If the "compressed" string would not become smaller than the 
	// original string, your method should return the original string.

	public static String compressString(String string) {
		if(string.length() == 0) {
			return string;
		}
		String returnString = "";
		Character last = string.charAt(0);
		int counter = 1;
		int totalCounter = 2;
		for(int i = 1; i < string.length(); i++) {
			if(string.charAt(i) == last) {
				counter++;
			} else {
				returnString += last.toString() + Integer.toString(counter);
				totalCounter += 2;
				if(totalCounter > string.length()) { return string; }
				counter = 1;
				last = string.charAt(i);
			}
		}
		return returnString + last.toString() + Integer.toString(counter);
	}

	// Given two strings, write a method to decide if one is a permutation of the other.
	public static Boolean permutations(String left, String right) {
		HashMap<Character, Integer> leftHash = new HashMap<Character,Integer>();
		HashMap<Character, Integer> rightHash = new HashMap<Character,Integer>();
		if(left.length() != right.length()) { return false;}
		for(int i = 0; i < left.length(); i++) {
			if(leftHash.get(left.charAt(i)) == null) { leftHash.put(left.charAt(i), 1); }
			leftHash.put(left.charAt(i), leftHash.get(left.charAt(i)) + 1);
			if(rightHash.get(right.charAt(i)) == null) { rightHash.put(right.charAt(i), 1); }
			rightHash.put(right.charAt(i), rightHash.get(right.charAt(i)) + 1);
		}
		return leftHash.equals(rightHash);
	}
}