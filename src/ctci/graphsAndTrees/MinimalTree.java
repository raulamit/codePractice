package ctci.graphsAndTrees;

/**
 * Created by raula on 2/9/2017.
 */
enum Data{
    NULLNODE,
        }
class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data =data;
    }
}

public class MinimalTree {
    public static void main(String[] args) {
        int[] inputArray = {2, 3,4, 5, 6, 7, 8, 9};
        int l = inputArray.length;
        int height = (int)Math.log(l)+1;
        //assuming inputArray has ateast one element
        Node root =makeTree(inputArray,0,l-1);
        System.out.println(getSuccessor(root,5));

//        boolean b=isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
//        System.out.println(b);
//        printTree(root, 1);
    }


    private static int getSuccessor(Node root,int num){
        if(root== null) return -1;
        else{
            if(root.data==num){
                if(root.right!=null) {
                    Node node = root.right;
                    while(node.left!=null) node= node.left;
                    return node.data;
                }
                return -2;
            }else{
                if(root.left!=null){
                    int leftSucc=getSuccessor(root.left,num);
                    if(leftSucc==-2) return root.data;
                    if(leftSucc>=0) return leftSucc;

                }
                if(root.right!=null){
                    int rightSucc = getSuccessor(root.right,num);
                    if (rightSucc==-2) return -2;
                    if (rightSucc>=0) return rightSucc;
                }
                return -1;
            }
        }
    }
    private static boolean isBinarySearchTree(Node root, int minValue, int maxValue) {
        if(root==null) return true;
        if(root.data<minValue||root.data>=maxValue) return false;
        return isBinarySearchTree(root.left,minValue,root.data) &&isBinarySearchTree(root.right,root.data,maxValue);
    }

    private static void printTree(Node n, int level) {
        if (n==null) return;
        printTree(n.left,level+1);
        System.out.println(n.data +"   "+ level);
        printTree(n.right,level+1);
    }

    public static Node makeTree(int[] arr, int low, int high){
        if (high-low < 0) return null;
        int split =(low+high)/2;
        Node parent= new Node(arr[split]);
        parent.left = makeTree(arr,low,split-1);
        parent.right = makeTree(arr,split+1,high);
        return parent;
    }
}
