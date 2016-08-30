public class JavaPracticeSpringManipulation {


	public static void main(String[] args) {
		System.out.println("Is abcsdefghijklmnopqrstuvwxy unique? " + uniqueChars("abcsdefghijklmnopqrstuvwxy"));
		System.out.println("Is abcdefghijklmnopqrstuvwxyz unique? " + uniqueChars("abcdefghijklmnopqrstuvwxyz"));

	}

	//1.1
	// Implement an algorithm to determine if a string has all unique
	// characters. What if you cannot use additional data structures
	public static boolean uniqueChars(String string){
		int[] hash = new int[127];

		for(int i = 0; i < string.length(); i++) {
			if(hash[string.charAt(i)] == 1) {
				return false;
			}
			hash[string.charAt(i)] = 1;
		}

		return true;
	}
}