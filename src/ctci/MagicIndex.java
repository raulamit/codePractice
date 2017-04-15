package ctci;

/**
 * Created by raula on 2/22/2017.
 */
public class MagicIndex {
    public static void main(String[] args) {
        int[] a= {-2, 0, 2,15, 17,19,22,28};
        System.out.println(findMagicIndex(a,0,a.length-1));
    }

    public static int findMagicIndex(int[] args, int l, int h){
        if(l>h) return -1;
        int split =(l+h)/2;
        if(args[split]==split) return split;
        else if(args[split]>split) return findMagicIndex(args, l, split-1);
        else return findMagicIndex(args,split+1, h);

        /*  if dupllicate numbers are allowed
        * int split =(l+h)/2;
        * int left= findMagicIndex(args, l, split-1);
        if(left!=-1) return left;
        int right= findMagicIndex(args,split+1, h);
        return right;
        */
    }
}
