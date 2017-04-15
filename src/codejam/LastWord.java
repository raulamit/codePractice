package codejam;

import java.io.*;
import java.util.Scanner;

/**
 * Created by raula on 4/3/2017.
 */
public class LastWord {
    public static void main(String[] args) throws FileNotFoundException {
        File in =new File("C:\\Users\\raula\\Downloads\\A-large-practice.in");
        Scanner sc = new Scanner(new FileInputStream(in));
        File out = new File("C:\\Users\\raula\\Downloads\\A-small-practice.out");
        PrintWriter pw = new PrintWriter(out);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i=1; i<=t;i++){

            pw.println("Case #"+ i+": "+lastWord(sc.nextLine()));
        }
        pw.close();
    }

    private static String lastWord(String s) {
        if (s.equals("")) return s;
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(cs[0]);
        char  first = cs[0];
        char last = cs[0];
        for (int i=1; i<cs.length;i++){
            if(cs[i]-first>=0){
                first=cs[i];
                sb.insert(0,cs[i]);
            }else {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }
}
