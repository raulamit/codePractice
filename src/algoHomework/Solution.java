package algoHomework;

/**
 * Created by raula on 2/22/2017.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[][] a= new int [3][n];
        int[] rightEnd= new int[n];
        for (int i=0; i<n;i++){
            a[0][i] =sc.nextInt();
            a[1][i] = sc.nextInt();
            rightEnd[i]=a[1][i];
            a[2][i]=i;
        }
        sortEnds(a,0,n-1,0,2);
        //Arrays.sort(rightEnd);

      /*  for(int i=0;i<n;i++){
            a[3][a[2][i]]=i;
        }*/
//        sortEnds(a,0,n-1,0,3);
        ArrayList<Integer> ar = new ArrayList<>();
        System.out.println(count(a,0,ar));
        // System.out.println(intersectionCount(a));
/*        Integer[] ar = {12,9,7,6,4,2,1};
        ArrayList<Integer> al= new ArrayList<>();
        al.addAll(Arrays.asList(ar));
        int out= binSearchIndex(al,7,0);
        System.out.println(out);*/
    }


    public static int count(int[][] a,int l,ArrayList<Integer> ar){
        int count=0;
        if (l==0) {
            ar.add(a[1][a[2][l]]);
            l++;
        }
        while (l<a[0].length){
            int index= binSearchIndex(ar,l, a[1][a[2][l]]);
            ar.add(index,a[1][a[2][l]]);
            l++;
            count+=index;
        }
        return count;
    }

    private static int binSearchIndex(ArrayList<Integer> ar, int size,int a) {
        int l=0;
        int h= size-1;
        while(l<=h){
            int mid= (l+h)/2;
            if(a> ar.get(mid)){
             h= mid;
            }else if(mid>=(size-1) || ar.get((mid+1))<a){
                return mid+1;
            }else{
                l= (l+h)/2 +1;
            }
            if (h==0) return 0;
        }
        return -1;
    }

    /*    public static int count(int[][] a){
            int count=0;
            for(int i=0; i<a[0].length;i++){
                int index= a[3][i];
                if(index>i) count+= index-i;
            }
            return count;
        }*/
    public static void sortEnds(int[][] a, int l, int h,int endIndex,int index){
        int i=l;
        int j=h;
        int pivot= a[endIndex][(h+l)/2];
        while(i<=j){
            while(a[endIndex][i]<pivot) i++;
            while( a[endIndex][j]>pivot) j--;
            if(i<=j){
                int temp= a[endIndex][i];
                a[endIndex][i]=a[endIndex][j];
                a[endIndex][j]= temp;
                temp= a[index][i];
                a[index][i]=a[index][j];
                a[index][j]= temp;
                i++;
                j--;
            }
        }
        if(l<j) sortEnds(a,l,j,endIndex,index);
        if(h>i) sortEnds(a,i,h,endIndex,index);

    }

/*    public static int intersectionCount(int[][] a){
        int count=0;
        for(int i=0; i<a.length;i++){
            for(int j=i+1; j<a.length;j++){
                if((long)(a[i][0]-a[j][0])*(long)(a[i][1]-a[j][1]) <0) count++;
            }
        }
        return count;
    }*/
}