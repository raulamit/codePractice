package ctci.sortingAndSearching; /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *//*

public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> nums = new ArrayList();
        if(root==null) return nums;
        nums.add(root.val);
        if(root.left==null&root.right==null) return nums;
        printLeftTree(nums,root.left);
        // if(nums.size()>1)nums.remove(nums.size()-1);
        printLeaves(nums,root);
        // if(nums.size()>1) nums.remove(nums.size()-1);
        printRightTree(nums, root.right);
        return nums;
    }

    public void printLeftTree(List<Integer> nums, TreeNode node){
        if(node==null) return;
        if(node.left==null && node.right==null){
            //nums.add(node.val);
            return;
        }
        nums.add(node.val);
        if(node.left==null) printLeftTree(nums,node.right);
        else printLeftTree(nums,node.left);
    }
    public void printLeaves(List<Integer> nums, TreeNode node){
        if (node==null) return;
        if(node.left==null && node.right==null){
            nums.add(node.val);
            return;
        }
        else{
            printLeaves(nums,node.left);
            printLeaves(nums,node.right);

        }
    }

    public void printRightTree(List<Integer> nums, TreeNode node){
        if(node==null) return;
        if(node.left==null && node.right==null){
            //nums.add(node.val);
            return;
        }
        if(node.right==null) printRightTree(nums,node.left);
        else printRightTree(nums,node.right);
        nums.add(node.val);
    }

*/
/*    public void printLeftTree(List<Integer> nums, TreeNode node){
        if(node==null) return;
        nums.add(node.val);
        printLeftTree(nums,node.left);
        if(node.right!=null){
            if(node.left==null&&(node.right.right!=null||node.right.left!=null)) nums.add(node.right.val);
            if(node.right.left==null && node.right.right==null)
                printLeftTree(nums, node.right);
            if (node.right.left!=null) printLeftTree(nums, node.right.left);
            if (node.right.right!=null) printLeftTree(nums, node.right.right);
        }
    }

    public void printRightTree(List<Integer> nums, TreeNode node){
        if(node==null) return;
        if(node.left!=null){
            if (node.left.left!=null) printRightTree(nums, node.left.left);
            if (node.left.right!=null) printRightTree(nums, node.left.right);
            if(node.left.right==null && node.left.left==null)
                printRightTree(nums, node.left);
            if(node.right==null&&(node.left.left!=null||node.left.right!=null)) nums.add(node.left.val);

        }
        printRightTree(nums,node.right);

        nums.add(node.val);
    }*//*

}

*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Point{
    int x;
    int y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }

}

public class leetCode {
    public static Point home = new Point(0,0);
    public static Point[] points=null;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner (System.in);
        int n= sc.nextInt();
        points = new Point[n];
        for (int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i]= new Point(x,y);
        }


        System.out.println(findMinCost(home,2,n));
    }

    public static int findMinCost(Point curr, int t, int n){
        if(n==0){
            if(curr.x==0&&curr.y==0) return 0;
            else return distance(curr, home);
        }
        else{
            if(t==0){
                return distance(home, curr) + findMinCost(home,2,n);
            }
            else{
                int min =Integer.MAX_VALUE;
                if(!(curr.x==0&&curr.y==0)){
                    min= distance(home,curr)+ findMinCost(home,2,n);
                }
                for (int i=0; i<points.length;i++){
                    if(points[i].x==100) continue;
                    int x= points[i].x;
                    int y =points[i].y;
                    points[i].x=0;
                    points[i].y=0;
                    min = Math.min(min,distance(new Point(x,y),curr)+ findMinCost(new Point(x,y),t-1,n-1));
                    points[i].x=x;
                    points[i].y=y;
                }
                return min;
            }
        }
    }

    public static int distance(Point a , Point b){
        return a.x*b.x +a.y*b.y;
    }
}




