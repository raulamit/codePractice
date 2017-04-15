package ctci.graphsAndTrees;

import java.util.HashSet;

/**
 * Created by raula on 3/7/2017.
 */
public class PathsWithSum {
    public static void main(String[] args) {
        // TREE 1
		/* Construct the following tree
			26
			/ \
		   10  3
		  / \	\
		 4	 6	 3
		  \
		  30 */
        Node root1 = new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);

        int count=countPaths(root1,14,0);
        System.out.println(count);
        HashSet<Integer> ps = new HashSet<>();
        ps.add(0);
        count=countPaths(root1,14,0, ps);
        System.out.println(count);
    }


    //more optimal uses a running sum
    private static int countPaths(Node node, int t, int rs, HashSet<Integer> pathSums) {
        if(node==null){
            return 0;
        }else{
            int count=0;
            rs+=node.data;
            pathSums.add(rs);
//            if(rs==t) count++;
            if(pathSums.contains(rs-t)) count++;
            count=count+countPaths(node.left,t,rs,pathSums)+
                    countPaths(node.right,t,rs,pathSums);
            pathSums.remove(rs);
            return count;
        }
    }

    private static int countPaths(Node node, int t, int sum) {
        if(node==null){
            return 0;
        }else{
            int count=0;
            if(sum+node.data==t) count++;
            return count+countPaths(node.left,t,sum+node.data)+
                    countPaths(node.left,t,sum)+
                    countPaths(node.right,t,sum+node.data)+
                    countPaths(node.right,t,sum);
        }
    }
}
