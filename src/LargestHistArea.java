import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestHistArea {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Prlong output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int maxArea=-1;
        Stack<Integer> indexStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();

        for (int i=0; i<n; i++){
            int x= sc.nextInt();
            if (indexStack.isEmpty() || heightStack.peek()<=x){
                indexStack.push(i);
                heightStack.push(x);
            }else{
                int tempIndex=-1;
                while (!heightStack.isEmpty() &&heightStack.peek()>x){
                    tempIndex = indexStack.pop();
                    int tempHeight = heightStack.pop();
                    int max=tempHeight *(i - tempIndex);
                    maxArea= Math.max(maxArea,max);
                }

                heightStack.push(x);
                indexStack.push(tempIndex);
            }
        }
        while (!heightStack.isEmpty()){
            int tempIndex = indexStack.pop();
            int tempHeight = heightStack.pop();
            maxArea= Math.max(maxArea,tempHeight *(n - tempIndex));
        }
        System.out.println(maxArea);
    }
}