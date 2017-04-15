package ctci.arraysAndStrings;
import java.util.*;
/**
 * Created by raula on 2/24/2017.
 */
public class CheckPermutations {
    public static void main(String[] args) {
    	String a= "baggabb";
    	String b = "gabgbac";
    	if(isPermutation(a,b)) System.out.println(" Same permutations!");
    	else System.out.println("Different permutations!");
    }

/*    private static boolean isPermutation(String a, String b){
    	if (a.length()!=b.length()) return false;
    	char[] charsA = a.toCharArray();
    	Arrays.sort(charsA);
    	char[] charsB = b.toCharArray();
    	Arrays.sort(charsB);
    	for (int i=0;i<charsA.length ;i++ ) {
    		if(charsA[i]!= charsB[i]) return false;
    	}
    	return true;
    }
*/
    // checks cahracter counts in a hashMap
    private static boolean isPermutation(String a, String b){
    	if (a.length()!=b.length()) return false;
    	HashMap<Character, Integer> aMap= new HashMap<>();
    	HashMap<Character, Integer> bMap= new HashMap<>();
    	for (char c : a.toCharArray()) {
    			if(aMap.containsKey(c)) aMap.put(c,aMap.get(c)+1);
    			else aMap.put(c,1);
    	}
    	for (char c : b.toCharArray()) {
    			if(bMap.containsKey(c)) bMap.put(c,bMap.get(c)+1);
    			else bMap.put(c,1);
    	}
        Set<Character> aKeys =  aMap.keySet();
        Set<Character>  bKeys = bMap.keySet();
        if(aKeys.size()!=bKeys.size()) return false;
        for(char c: aKeys){
            if(aMap.get(c)!=(bMap.get(c))) return false;
        }
   	    return true;
    }
}
