package ctci.recursionDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by raula on 3/3/2017.
 */
public class PermOfStringDup {
    public static void main(String[] args) {
        String s = "aangram";
        int[] cs = new int[26];
        for(char c: s.toCharArray()){
            cs[c-'a']++;
        }
        int count=0;
        for(String perm: getAllPermutations(cs,0, "")){
            System.out.println(perm);
            count++;
        }

        System.out.println(count);
    }

    private static ArrayList<String> getAllPermutations(int[] c, int i, String perm) {
        if (i == c.length) {
            ArrayList<String> allPerms = new ArrayList<>();
            allPerms.add(perm);
            return allPerms;
        } else {
            ArrayList<String> allPerms = new ArrayList<>();
            allPerms.addAll(getDuplicatePerm (c[i], (char) ('a'+i),perm, 0,c));
            return allPerms;
        }
    }

    private static ArrayList<String> getDuplicatePerm (int count,char c,String perm, int index, int[] cs){
        if (count==0){
            ArrayList<String> allPerms = new ArrayList<>();
            allPerms.addAll(getAllPermutations(cs, c -'a'+1, perm));
            return allPerms;
        }else{
            ArrayList<String> allPerms = new ArrayList<>();
            for (int j = index; j <= perm.length(); j++) {
                StringBuilder sb = new StringBuilder(perm);
                sb.insert(j, c);
                allPerms.addAll(getDuplicatePerm(count-1,c,sb.toString(),j+1,cs));
            }
            return allPerms;
        }
    }
}
