
import java.util.HashMap;
import java.util.Iterator;


public class JavaPracticeOperations {
	
	public static void main (String[] args) {
		itHashMap(testHashMap());
		itHashMapForEach(testHashMap());
	}

	/******************************************************
	* java.util.HashMap
	******************************************************/

	private static HashMap<String,String> testHashMap() {
		return new HashMap<String,String>() {{
			put("f","bar");
			put("g","applepie");
			put("a","orangejuice");
			put("z","peachcobbler");
		}};
	}

	private static void itHashMap(HashMap<String,String> input) {
		Iterator it = input.entrySet().iterator();
		while(it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry)it.next();
			System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
		}
	}

	private static void itHashMapForEach(HashMap<String,String> input) {
		for(HashMap.Entry entry : input.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}

}