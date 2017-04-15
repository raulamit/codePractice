package ctci.graphsAndTrees;

/**
 * Created by raula on 3/6/2017.
 */
public class CheckBalanced {
    public static void main(String[] args) {
        BTNode root= new BTNode();
        isBalanced(root,0);
    }

    private static int isBalanced(BTNode root,int h) {
        if(root==null) return h;
        else{
            int left = isBalanced(root.left,h+1);
            int right= isBalanced(root.right,h+1);
            if(left==-1||right==-1 ) return -1;
            if (Math.abs(left-right)>1) return -1;
            else return Math.max(left,right);
        }
    }
}

class BTNode{
    int data;
    BTNode left;
    BTNode right;
}
