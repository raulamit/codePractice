package ctci.arraysAndStrings;

import java.util.HashMap;

/**
 * Created by raula on 2/25/2017.
 */
public class StringCompression {
    public static void main(String[] args) {
        String input= "aabbbbcc";
        System.out.println(compressedString(input));
    }

    private static String compressedString(String input) {
        HashMap<Character,Integer> dic= new HashMap<>();

        for (char c: input.toCharArray()){
            if(dic.containsKey(c)) dic.put(c,dic.get(c)+1);
            else dic.put(c,1);
        }
        String compressedString="";
        char[] inputChars = input.toCharArray();
        for( int i=0; i<inputChars.length; i++){
            char current= inputChars[i];
            compressedString+= ""+current+ dic.get(inputChars[i]);
            while(i<inputChars.length-1 && inputChars[i+1]==inputChars[i]) i++;
        }
        if (compressedString.length()<=inputChars.length) return compressedString;
        else return input;
    }
}
