package ctci.sortingAndSearching;

import java.util.Arrays;

/**
 * Created by raula on 2/27/2017.
 */
public class SortedMerge {
    public static void main(String[] args) {
        int[] a = {4, 4, 6, 6, 15, 22 ,0,0,0,0,0};
        int [] b = {1,4,5,6,12};
        mergeArray(a,b);
        printArray(a);
    }

    private static void mergeArray(int[] a , int[] b){
    	int bl = b.length-1;
    	int al = a.length-b.length-1;
    	for(int i=a.length-1; i>=0;i--){
            if (al>=0&&a[al]>b[bl]){
    			a[i]=a[al];
    			al--;
    		}else {
    			a[i]=b[bl];
    			bl--;
    		}
    	}
    }

    public static void printArray(int[] a){
        for (int e : a){
            System.out.print(e +" ");
        }
        System.out.println();
    }

}
