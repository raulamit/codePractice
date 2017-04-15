package hackercup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by raula on 1/7/2017.
 */
public class prob3 {
    public static void main(String[] args) throws FileNotFoundException {
        String fileLocation = "";
        File inputFile = new File("C:\\Users\\raula\\Downloads\\lazy_loading.txt");
        File outputFile = new File("C:\\Users\\raula\\Downloads\\hackercup\\prob2.txt");
        PrintWriter pw = new PrintWriter(outputFile);
        Scanner sc = new Scanner(inputFile);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int hp = sc.nextInt();
            int nos= sc.nextInt();
            sc.nextLine();
            for (int j=0; j<nos; j++){
                String spell = sc.nextLine();
                int ehp=hp;
                int nod=0;
                int dice=0;
                if (spell.split("[d-]").length==3){
                    String[] spellArr= spell.split("[d-]");
                    nod= Integer.parseInt(spellArr[0]);
                    dice= Integer.parseInt(spellArr[1]);
                    ehp= hp+ Integer.parseInt(spellArr[2]);
                }else if (spell.split("[d+]").length==3){
                    String[] spellArr= spell.split("[d+]");
                    nod= Integer.parseInt(spellArr[0]);
                    dice= Integer.parseInt(spellArr[1]);
                    ehp= hp- Integer.parseInt(spellArr[2]);
                }else{
                    String[] spellArr= spell.split("[d]");
                    nod= Integer.parseInt(spellArr[0]);
                    dice= Integer.parseInt(spellArr[1]);
                }
            }
        }
    }

    public static void q1Sort(int[] a){
        int n = a.length;
        int k=10;
        int[] countArr = new int[k];

        // initializing with all zeros O(k) i.e O(10)
        for (int i=0; i<k; i++)
            countArr[i]= 0;

        for (int i=0; i<n; i++) countArr[a[i]]++;

        int index=0;
        for (int i=0 ; i<k ;i++){
            for (int j=0; j< countArr[i]; j++){
                a[index]=i;
                index++;
            }
        }
    }

    static void q2Sort(int arr[], int n)
    {
        int m = n*n;
        for (int exp = 1; m/exp > 0; exp *= n)
            countSort(arr,exp);
    }

    private static void countSort(int[] a,  int exp) {
        int n = a.length;
        int k=10;
        int[] countArr = new int[k];
        // initializing with all zeros O(k) i.e O(10)
        for (int i=0; i<k; i++)
            countArr[i]= 0;

        for (int i=0; i<n; i++) countArr[a[i]]++;

        int index=0;
        for (int i=0 ; i<k ;i++){
            for (int j=0; j< countArr[i]; j++){
                a[index]=i;
                index++;
            }
        }
    }
}
