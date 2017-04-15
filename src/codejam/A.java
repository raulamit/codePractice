package codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by raula on 4/7/2017.
 */
public class A {
    public static int length=0;
    public  static HashMap<String,Integer> memo= new HashMap<>();
    public static HashSet<String> exp = new HashSet<>();
    public static void main(String[] args) throws FileNotFoundException {
        String small="A-small-attempt1";
        String large= "A-large";

        File in = new File("C:\\Users\\raula\\Downloads\\"+large+".in");
        Scanner sc = new Scanner(new FileInputStream(in));
        File out = new File("C:\\Users\\raula\\Downloads\\"+large+".out");
        PrintWriter pw = new PrintWriter(out);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= t; i++) {
            String line = sc.nextLine();
            String[] splits = line.split(" ");
            int k = Integer.parseInt(splits[1]);
//            System.out.println(splits[0].length());
//            int result = pancakeFlip(splits[0],s,splits[0].length(),0);
            System.out.println(splits[0].length());
            int result = pancakeFlip(splits[0],k);
            pw.println("Case #"+ i+": " + (result==Integer.MAX_VALUE? "IMPOSSIBLE":result));
        }
        pw.close();
    }

    public static int pancakeFlip(String p, int k){
        char[] pc = p.toCharArray();
        int count=0;
        for (int i = 0; i <= pc.length-k ; i++) {
            if(pc[i]=='-'){
                count++;
                for (int j = i; j < i+k; j++) {
                    if (pc[j]=='-') pc[j]='+';
                    else pc[j]='-';
                }
            }
        }
        for (char c:pc ) {
            if(c=='-') return Integer.MAX_VALUE;
        }
//        if() return Integer.MAX_VALUE;
        return count;
    }


}
