package ctci.recursionDP;

import java.util.*;

/**
 * Created by raula on 3/3/2017.
 */
public class Parens {
    public static void main(String[] args) {
		int n=10;
		HashSet<String> parSets= getParSubset(n);
        System.out.println(parSets.size());
    }

    private static HashSet<String> getParSubset(int n){
    	if (n==1){
    		HashSet<String> permSet= new HashSet();
    		permSet.add("()");
    		return permSet;
    	}else{
    		HashSet<String> permSet = getParSubset(n-1);
    		HashSet<String> currSet = new HashSet();
    		for(String perm: permSet){
    			int leftCount =0;
    			String currPerm="()"+perm;
    			currSet.add(currPerm);
    			for(int i=0;i<perm.length();i++){
    				if(perm.charAt(i)=='(') {
    					currSet.add(perm.substring(0,i+1)+"()"+perm.substring(i+1));
    				}
    			}
    		}
            return currSet;
    	}
    }
}
