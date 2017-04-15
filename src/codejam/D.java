package codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by raula on 4/7/2017.
 */
public class D {
    public static void main(String[] args) throws FileNotFoundException {
        String small="D-small";
        String large= "D-large";
        File in = new File("C:\\Users\\raula\\Downloads\\"+small+".in");
        Scanner sc = new Scanner(new FileInputStream(in));
        File out = new File("C:\\Users\\raula\\Downloads\\"+small+".out");
        PrintWriter pw = new PrintWriter(out);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= t; i++) {

            pw.println("Case #"+ i+": ");
        }
    }
}
