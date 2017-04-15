package zappos;

/**
 * Created by raula on 2/4/2017.
 */
public class reverseString {
    public static void main(String[] args) {
        wordByrWordReverse("I am      Amit");
    }

    private static void wordByrWordReverse(String s) {
        String [] words = s.split(" ");
        String rev="";
        for (String word: words) {
            if (word.length()==0) rev+=" ";
            else rev+=reverse(word)+" ";
        }
        System.out.println(rev);
        System.out.println(s);

    }
     public static String reverse(String word){
        int l =word.length();
        char[] reverse = new char[l];
        for (int i=0; i<l; i++){
            reverse[l-1-i]=word.charAt(i);
        }
        return new String(reverse);
     }
}
