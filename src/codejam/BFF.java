package codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by raula on 4/3/2017.
 */
public class BFF {
    public static void main(String[] args) throws FileNotFoundException {
        File in = new File("C:\\Users\\raula\\Downloads\\B-large-practice.in");
        Scanner sc = new Scanner(new FileInputStream(in));
        File out = new File("C:\\Users\\raula\\Downloads\\A-small-practice.out");
        PrintWriter pw = new PrintWriter(out);
        int t = sc.nextInt();
        sc.nextLine();
//        Integer.MAX_INTEGER;
    }
}
