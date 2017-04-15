package ctci.sortingAndSearching;

/**
 * Created by raula on 2/27/2017.
 */
public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] a= {15, 16, 19, 20, 25, 1, 3,  4, 5, 7, 10, 14};

        System.out.println(searchInRotatedArray(a,15));
    }

    private static int searchInRotatedArray(int[] a,int n) {
        int l=0;
        int h=a.length-1;
        return search(a,l,h,n);
    }

    private static int search(int[] a, int l, int h, int n) {
        if (h<l) return -1;
        int mid=(l+h)/2;
        if(a[mid]==n) return mid;
        int foundIndex=-1;
        boolean searchedLeft=false;
        if (a[mid]>n) {
            foundIndex=search(a,mid+1,h,n);
            searchedLeft=true;
            if (foundIndex!=-1) return foundIndex;
        }
        foundIndex=search(a,l,mid-1,n);
        if (foundIndex!=-1) return foundIndex;
        if(!searchedLeft) return search(a,mid+1,h,n);
        else return -1;
    }
}
