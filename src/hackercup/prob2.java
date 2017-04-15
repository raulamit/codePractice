package hackercup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;


/**
 * Created by raula on 1/6/2017.
 */
public class prob2 {
    public static void main(String[] args) throws FileNotFoundException {
        String fileLocation ="";
        File inputFile= new File("C:\\Users\\raula\\Downloads\\lazy_loading.txt");
        File outputFile = new File("C:\\Users\\raula\\Downloads\\hackercup\\prob2.txt");
        PrintWriter pw = new PrintWriter(outputFile);
        Scanner sc = new Scanner(inputFile);
        int t = sc .nextInt();
        for (int i=0; i< t; i++){
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int n= sc.nextInt();
            for (int j=0;j<n;j++){
                int k= sc.nextInt();
                minHeap.add(k);
                maxHeap.add(k);
            }
            int popCount=0;
            int trips=0;
            while(popCount<n){
                int max=maxHeap.poll();
                popCount++;
                for (int k=0; k<50/max;k++){
                    if(popCount==n) {trips --; break;}
                    minHeap.poll();
                    popCount++;
                }
                trips++;
            }
            pw.println("Case #"+ (i+1) + ": " + trips);
        }
        pw.close();
    }
}
