package ctci.sortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by raula on 2/27/2017.
 */
public class GroupAnagams {
    public static void main(String[] args) {
        String[] anagrams = {"allw","dhla","lwal", "ladh","wlla"};
        groupAnagrams(anagrams);
        for (String anagram:anagrams) {
            System.out.println(anagram);
        }
    }

    private static void groupAnagrams(String[] anagrams) {
        for(int i=0; i<anagrams.length;i++) {
            String current=anagrams[i];
            for (int j = i+1; j < anagrams.length; j++) {
                if(isAnagram(current,anagrams[j])){
                    i++;
                    String temp=anagrams[i];
                    anagrams[i]=anagrams[j];
                    anagrams[j]=temp;
                }
            }
        }
    }

    private static boolean isAnagram(String o1, String o2) {
        int[] charDict= new int[26];
        for (char c: o1.toCharArray()  ) {
            charDict[Character.toLowerCase(c)-'a']++;
        }
        for (char c: o2.toCharArray()  ) {
            charDict[Character.toLowerCase(c)-'a']--;
        }
        int count=0;
        for (int value:charDict) {
            if (value!=0) count++;
        }
        if (count==0) return true;
        return false;
    }

  /*         Arrays.sort(anagrams, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return isAnagram(o1,o2);
            }

            private int isAnagram(String o1, String o2) {
                int[] charDict= new int[26];
                for (char c: o1.toCharArray()  ) {
                    charDict[Character.toLowerCase(c)-'a']++;
                }
                for (char c: o2.toCharArray()  ) {
                    charDict[Character.toLowerCase(c)-'a']++;
                }
                int count=0;
                for (int value:charDict) {
                    if (value==0) count++;
                }
                if (count==0) return 0;
                return 1;
            }
        });*/
}
