package ctci.graphsAndTrees;

import java.util.ArrayList;
import java.util.Stack;

import static ctci.graphsAndTrees.MinimalTree.makeTree;

/**
 * Created by raula on 3/7/2017.
 */
public class BSTSequences {
    public static void main(String[] args) {
//        int[] inputArray = {2, 3,4, 5, 6, 7, 8, 9};
        int[] inputArray = {6,8,9,10,12};
        int l = inputArray.length;
        //assuming inputArray has ateast one element
        Node root =makeTree(inputArray,0,l-1);

        Node[] fringe = new Node[100];
        fringe[0]=root;
        int[] num  = new int[100];
        printAllSeq(fringe,0, num,0);
    }

    private static void printAllSeq(Node[] fringe, int top, int[] num, int i) {
        if(top<0){
            printArray(num,i);
        }else{
            Node current = fringe[top--];
            num[i++]=current.data;
            if(current.left!=null && current.right!=null){
                fringe[++top]=current.left;
                fringe[++top]=current.right;
                printAllSeq(fringe,top,num,i);
                top--;
                top--;
                fringe[++top]=current.right;
                fringe[++top]=current.left;
                printAllSeq(fringe,top,num,i);

            }else{
                if(current.left!=null) fringe[++top]=current.left;
                if(current.right!=null) fringe[++top]=current.right;
                printAllSeq(fringe,top,num,i);
            }
        }
    }

    private static void printArray(int[] num, int l) {
        int i=0;
        while(i<l){
            System.out.print(num[i]+ " ");
            i++;
        }
        System.out.println();
    }
}
