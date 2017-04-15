package ctci.graphsAndTrees;

/**
 * Created by raula on 3/7/2017.
 */
public class CheckSubtrees {
    public static void main(String[] args) {
        Node root1 = new Node(26);
        root1.right = new Node(3);
       root1.right.right = new Node(3);
       root1.left = new Node(10);
       root1.left.left = new Node(4);
       root1.left.left.right = new Node(30);
       root1.left.right = new Node(6);

        Node root2 = new Node(10);
        root2.right = new Node(6);
        root2.left = new Node(4);
        root2.left.right = new Node(30);

        System.out.println(isSubtree(root1, root2));

    }

    private static boolean isSubtree(Node root1, Node root2) {
        if(root1== null) return false;
        else{
            if(root1.data==root2.data){
                if(isSame(root1,root2)) return true;
            }
            if (isSubtree(root1.left,root2)) return true;
            else if(isSubtree(root1.right,root2)) return true;
            else return false;
        }
    }

    private static boolean isSame(Node root1, Node root2) {
        if(root1== null && root2==null) return true;
        else if (root1==null|| root2==null) return false;
        else{
            return (root1.data==root2.data)&&isSame(root1.left,root2.left)&& isSame(root1.right,root2.right);
        }
    }
}
