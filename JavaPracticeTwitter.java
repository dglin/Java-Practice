   
import java.util.HashMap;
import java.util.Iterator;


public class JavaPracticeTwitter {
    
    public static void main (String[] args) {
        System.out.println(differentByOne("Hella", "Hello"));
    } 




    static int differentByOne(String A, String B) {
        int flag = -1;
        for (int i = 0 ; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i) && flag == -1) {
                flag = i; 
            } else if(flag > -1) {
                return -1;
            }
        }
        return flag;
    }    
}