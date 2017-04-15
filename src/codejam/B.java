package codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by raula on 4/7/2017.
 */
public class B {
    public static void main(String[] args) throws FileNotFoundException {
        /*String small="B-small";
        String large= "B-large";
        File in = new File("C:\\Users\\raula\\Downloads\\"+small+".in");
        Scanner sc = new Scanner(*//*new FileInputStream(in)*//*System.in);
        File out = new File("C:\\Users\\raula\\Downloads\\"+small+".out");*/
        String small="B-small-attempt0";
        String large= "B-large";
        File in = new File("C:\\Users\\raula\\Downloads\\"+large+".in");
        Scanner sc = new Scanner(new FileInputStream(in));
        File out = new File("C:\\Users\\raula\\Downloads\\"+large+".out");
        PrintWriter pw = new PrintWriter(out);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= t; i++) {
            char[] nums=sc.nextLine().toCharArray();
            tidyNum(nums,0,0);
            StringBuilder sb = new StringBuilder();
            int j=0;
            for (j = 0; j < nums.length && nums[j]=='0'; j++) {
            }
            for (; j < nums.length; j++) {
                sb.append(nums[j]);
            }
            if (sb.length()==0) sb.append('0');

            pw.println("Case #"+ i+": " + sb.toString());
        }

        pw.close();
    }

    public static void tidyNum(char[] nums,int i, int a){
        if( i>=nums.length-1) return;
        else{
            if(nums[i]-nums[i+1]<=0) {
                tidyNum(nums,i+1,nums[i]-'0');
                if(nums[i]-nums[i+1]>0){
                    nums[i]--;
                    for(int j=i+1;j<nums.length;j++) nums[j]='9';
                    tidyNum(nums,i+1,nums[i]-'0');
                }
            }
            else{
                if(nums[i]-'0' >0) {
                    nums[i]--;
                    for(int j=i+1;j<nums.length;j++) nums[j]='9';
                }

            }
        }
    }
}
