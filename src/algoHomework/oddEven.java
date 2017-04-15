package algoHomework;

/**
 * Created by raula on 2/23/2017.
 */
public class oddEven {
    public static int n=0;
    public static void main(String[] args) {
        int[] elements= {1,2,3,4,5,6,7,8,11,12,13,14,15,16,17,18};
        n=elements.length/2;
        mergeNumbers(elements,1,0);
        for (int e: elements) {
            System.out.println(e);
        }
    }


    public static void mergeNumbers(int[]a,int skipLength,int start){
        if(skipLength==n) return;
        mergeNumbers(a,skipLength*2,start+skipLength);
        mergeNumbers(a,skipLength*2,start);
        smartSwap(a,skipLength,start);
    }

    private static void smartSwap(int[] a, int skipLength, int start) {
        int i=start+skipLength;
        int j=start+2*skipLength;
        int count=0;
        while(count<(n/(2*skipLength))){
            int temp= a[i];
            a[i]=a[j];
            a[j]=temp;
            i+=n/skipLength;
            j+=n/skipLength;
            count++;
        }
    }
}
