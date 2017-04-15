package ctci.arraysAndStrings;

/**
 * Created by raula on 2/24/2017.
 */
public class PalindromePermutation {
    public static void main(String[] args) {
     	String input= "heeoll oh";
     	System.out.println(isPalindromePermutation(input));
    }

    private static boolean isPalindromePermutation(String input){
    	char[] inChars= input.replaceAll(" ","").toCharArray();
    	boolean[] oddChars = new boolean[26];
    	// beacuse java initializes booleans to false, when the boolean has true element the charwacter occurence is odd
    	int oddNum=0;
    	for (char c : inChars ) {
            oddChars[Character.toUpperCase(c)-'A']^=true; //negate
    		if (oddChars[Character.toUpperCase(c)-'A']) oddNum++;
    		else oddNum--;
    	}
    	if (oddNum>1) return false;
    	return true;
    }


    // This approach uses a long as a bit vector to track even/ odd entries of a character
/*    private static boolean isPalindromePermutation(String input){
    	char[] inChars= input.replaceAll(" ","").toCharArray();
    	long out=0L;
    	for(char c : inChars){
    		out^= 1L << (int) (Character.toUpperCase(c)-'A');
    	}
    	return (out & (out-1))==0;

    }*/
}
