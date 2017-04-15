package ctci.recursionDP;

import java.util.*;
/**
 * Created by raula on 3/3/2017.
 */
public class PermOfString {
    public static void main(String[] args) {
    	String s = "angrms";
    	int count=0;
    	for(String perm: getAllPermutations(s,0, "")){
    		System.out.println(perm);
    		count++;
    	}
        System.out.println(count);
    }

    public static ArrayList<String> getAllPermutations(String s, int i, String perm){
    	if (i==s.length()) {
    	    ArrayList<String> allPerms = new ArrayList<>();
    	    allPerms.add(perm);
    	    return allPerms;
        }
    	else{
    		ArrayList<String> allPerms = new ArrayList<>();
    		 for(int j=0; j<=perm.length();j++){
    		 	StringBuilder  sb = new StringBuilder(perm);
                sb.insert(j, s.charAt(i));
    		 	allPerms.addAll(getAllPermutations(s,i+1,sb.toString()));
    		 }
    		 return allPerms;
    	}
    }
}
