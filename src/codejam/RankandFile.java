package codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by raula on 4/3/2017.
 */
public class RankandFile {
    public static void main(String[] args) throws FileNotFoundException {
        File in =new File("C:\\Users\\raula\\Downloads\\B-large-practice.in");
        Scanner sc = new Scanner(new FileInputStream(in));
        File out = new File("C:\\Users\\raula\\Downloads\\A-small-practice.out");
        PrintWriter pw = new PrintWriter(out);
        int t = sc.nextInt();
        sc.nextLine();
        for( int i=1; i<=t;i++){
            int n=sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < 2*n-1; j++) {
                for (int k = 0; k < n; k++) {
                    int num= sc.nextInt();
                    if(set.contains(num)) set.remove(num);
                    else set.add(num);
                }
            }
            ArrayList<Integer> al = new ArrayList();
            al.addAll(set);
            pw.print("Case #"+ i+": ");
            Collections.sort(al);
            for (Integer a: al  ) {
                pw.print(a+ " ");
            }
            pw.println();
        }
        pw.close();
    }
}
