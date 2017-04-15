package ctci.arraysAndStrings;

/**
 * Created by raula on 2/25/2017.
 */
public class StringRotation {
    public static void main(String[] args) {
        String a ="palindrome";
        String b= "dromepalin";
        System.out.println(isRotation(a,b));

    }

    private static boolean isRotation(String a, String b) {
        if (a.length()!=b.length()) return false;
        b=b+b;
        return isSubString(b,a);
    }

    private static boolean isSubString(String b, String a) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int aPtr=0;
        for (int i=0; i<b.length(); i++){
            if(charsA[aPtr]== charsB[i]){
                aPtr++;
                if(aPtr==charsA.length) return true;
            }else{
                aPtr=0;
            }
        }
        return false;
    }
}
