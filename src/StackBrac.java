import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StackBrac {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextInt();
        HashMap<Character,Character> mp = new HashMap<>();
        mp.put('{','}');
        mp.put('(',')');
        mp.put('[',']');

        for(long a0 = 0; a0 < t; a0++){
            String s = in.next();
            boolean balanced =false;
            Stack bracks = new Stack();
            for (char c : s.toCharArray()){
                if (c == '(' ||c =='[' || c=='{'){
                    bracks.push(c);}
                else if (c == ')' ||c ==']' || c=='}'){
                    if (!bracks.isEmpty()&&mp.get(bracks.peek())==c ) {
                        bracks.pop();
                        balanced=true;
                    }
                    else {
                        balanced=false;
                        break;
                    }
                }
            }
            if (balanced&&bracks.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }}
