package ctci.sortingAndSearching;

import java.util.Arrays;

/**
 * Created by raulamit on 2/28/2017.
 */
public class RankandStream {

    public static Node root= null;
    public static void main(String[] args) {
        int[] in ={10, 4, 6, 22, 15,4,6,7, 40,12,33,55,30,1};
        for (int i: in) {
            track(i);
        }
        Arrays.sort(in);
        for (int i:in ) {
           int rank = getRankOfNumber(i,root);
            System.out.println(rank);
            System.out.println(Arrays.binarySearch(in,i));
        }
    }

    private static int getRankOfNumber(int n,Node node) {
        if(node==null) return -1;
        if(node.data>=n){
            if(node.data==n) return node.leftCount;
            return getRankOfNumber(n,node.left);
        }else{
            return node.leftCount+1+getRankOfNumber(n,node.right);
        }
    }


    private static void track( int i) {
        if (root ==null){
            root= new Node();
            root.data=i;
        }else{
            root.insert(i);
        }

    }
}
    class Node{
        Node left;
        Node right;
        int data;
        int leftCount;

        public void insert (int d){
            if(this.data>=d){
                leftCount++;
                if(this.left==null){
                    this.left= new Node();
                    this.left.data=d;
                }else{
                    this.left.insert(d);
                }
            }else{
                if(this.right==null){
                    this.right= new Node();
                    this.right.data=d;
                }else{
                    this.right.insert(d);
                }
            }
        }
    }
