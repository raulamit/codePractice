package ctci.graphsAndTrees;

import static ctci.graphsAndTrees.MinimalTree.makeTree;

/**
 * Created by raula on 3/6/2017.
 */
public class FirstCommonAncestor {
    public static void main(String[] args) {
        int[] inputArray = {2, 3,4, 5, 6, 7, 8, 9};
        int l = inputArray.length;
        int height = (int)Math.log(l)+1;
        Node root =makeTree(inputArray,0,l-1);

        // assumes no duplicate
        Node a=firstCommonAncestor(root,6,9);
        System.out.println(a.data);
    }

    private static Node firstCommonAncestor(Node root, int v1, int v2) {
        if (root==null) return null;
        Node left = firstCommonAncestor(root.left,v1,v2);
        Node right = firstCommonAncestor(root.right,v1,v2);
        if(left==null && right==null) {
            if(root.data==v1 || root.data==v2) return root;
            else return null;
        }
        if(left== null){
            if(root.data==v1 || root.data==v2) return root;
            return right;
        }
        if(right==null) {
            if(root.data==v1 || root.data==v2) return root;
            return left;
        }

        if((left.data==v1 &&right.data==v2) || (right.data==v1 &&left.data==v2 )) return root;
        if(root.data==v1 || root.data==v2) return root;
        return null;

    }
}
