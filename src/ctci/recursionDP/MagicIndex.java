package ctci.recursionDP;

/**
 * Created by raula on 3/3/2017.
 */
public class MagicIndex {
    public static void main(String[] args) {
        int[] a= {-2, 0, 2,15, 17,19,22,28};
        System.out.println(findMagicIndex(a,0,a.length-1));
        System.out.println(findMagicIndexWithDuplicate(a,0,a.length-1));
    }

    private static int findMagicIndexWithDuplicate(int[] a, int l, int h) {
        if(h<l) return -1;
        int mid =(l+h)/2;
        if (a[mid]==mid) return mid;
        int low=findMagicIndex(a,l,mid-1);
        if(low!=-1) return low;
        else return findMagicIndex(a,mid+1,h);    }

    private static int findMagicIndex(int[] a, int l, int h) {
        if(h<l) return -1;
        int mid =(l+h)/2;
        if (a[mid]==mid) return mid;
        else if (a[mid]>mid) return findMagicIndex(a,l,mid-1);
        else return findMagicIndex(a,mid+1,h);
    }
}
