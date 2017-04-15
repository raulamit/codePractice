package ctci.graphsAndTrees;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by raula on 3/6/2017.
 */
public class ListOfDepths {

    public static void main(String[] args) {
        TreeNode root= new TreeNode();
        listOfDepth(root,null,0);
    }

    private static HashMap<Integer,ArrayList<TreeNode>> listOfDepth(TreeNode root, HashMap<Integer,ArrayList<TreeNode>> l, int height){
        if (root== null) return l;
        else{
            ArrayList<TreeNode> c= l.get(height);
            c.add(root);
            ArrayList<TreeNode> childList=null;
            if(!l.containsKey(height+1)){
                childList= new ArrayList<TreeNode>();
                l.put(height+1,childList);
            }
            for (TreeNode child: root.children){
                listOfDepth(child,l,height+1);
            }
            return l;
        }
    }
}

class TreeNode{
    int data;
    ArrayList<TreeNode> children = new ArrayList<>();
}

