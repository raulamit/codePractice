package ctci.sortingAndSearching;

/**
 * Created by raula on 2/27/2017.
 */
public class SortedSearchNoSize {
    public static void main(String[] args) {
        int[] a= {1, 3,  4, 5, 7, 10, 14,15, 16, 19, 20, 25};
        System.out.println(findNum(a,1));
    }

    private static int findNum(int[] a, int n) {
        int size=1;
        while(size<=a.length){

            int index=binSearch(a,size-1,2*size-2,n);
            if(index!=-1) return index;
            size*=2;
        }
        return -1;
    }

    private static int binSearch(int[] a, int l, int h, int n) {
        if(h<l) return -1;
        int mid =(h+l)/2;
        if (mid>= a.length){
            return binSearch(a,l,mid-1,n);
        }else if (a[mid]== n) return mid;
        else if (a[mid]<n) return binSearch(a,mid+1,h,n);
        else return binSearch(a,l,mid-1,n);
    }
}
