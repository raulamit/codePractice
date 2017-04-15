package ctci.sortingAndSearching;

import java.util.HashMap;

/**
 * Created by raula on 2/26/2017.
 */
public class SortAlgos {
    public static void main(String[] args) {
        int[] a = {10, 4, 6, 22, 15,6, 4,40, 30, 1};
        printArray(a);
        System.out.println("bubbleSort.....");
        int[] b = bubbleSort(a);
        printArray(b);
        a= new int[] {10, 4, 6, 22, 15,6, 4,40, 30, 1};
        printArray(a);
        System.out.println("Merge sort....");
        printArray(mergeSort(a,0,a.length-1));
        a= new int[] {10, 4, 6, 22, 15,6, 4,40, 30, 1};
        printArray(a);
        System.out.println("Quick sort....");
        quickSort(a,0,a.length-1);
        printArray(a);
        HashMap mp;


    }

    private static void quickSort(int[] a, int l, int h) {
        if(h>l){
            int pivot=partition(a,l,h);
            quickSort(a,l,pivot-1);
            quickSort(a,pivot+1,h);
        }
    }

    private static int partition(int[] a, int l, int h) {
        exchange(a,h,(l+h)/2);
        int pivot= a[h];
        int part=-1;
        for (int i = 0; i < a.length; i++) {
            if(a[i]<a[h]){
                part++;
                exchange(a,i,part);
            }
        }
        exchange(a,part+1,h);
        return part+1;
    }

    private static int[] mergeSort(int[] a, int l, int h) {
        if(h-l <=0) return a;
        int split = (l+h)/2;
        int[] left = new int[split-l+1];
        for (int i = 0; i < left.length; i++) {
            left[i]=a[i];
        }
        int[] right = new int[h-split];
        for (int i = 0; i < right.length; i++) {
            right[i]=a[split+1+i];
        }
        int[] b = new int[h-l+1];
        left=mergeSort(left,0,split-l);
        right=mergeSort(right, 0, h-split-1);
        merge(left,right,b);
        return b;
    }

    private static void merge(int[] left, int[] right, int[] a) {
        int l=0;
        int r=0;
        for (int i = 0; i < a.length; i++) {
            if(r>=right.length){
                a[i]=left[l];
                l++;
                continue;
            }
            if(l>=left.length){
                a[i]=right[r];
                r++;
                continue;
            }
            if(left[l]>right[r]){
                a[i]=right[r];
                r++;
                continue;
            }
            else{
                a[i]=left[l];
                l++;
                continue;
            }
        }
    }


    public static int[] bubbleSort(int[] a){
        for(int i=a.length-1; i>=0;i--){
            for (int j=0; j<i; j++){
                if(a[j+1]<a[j]) exchange(a,j+1,j);
            }
        }
        return a;
    }







    private static void exchange(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void printArray(int[] a){
        for (int e : a){
            System.out.print(e +" ");
        }
        System.out.println();
    }

}
