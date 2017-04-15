import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by raula on 12/24/2016.
 */
public class LevelOrderParsing {

//    public static ArrayList<GraphNode> appendedChild (ArrayList<GraphNode> nodes){
//        if (nodes.isEmpty()) return nodes;
//        ArrayList<GraphNode> childNodes = new ArrayList<>().a;
//        for (GraphNode node :nodes){
//            if (node.left!=null){
//                childNodes.add(node.left);
//            }
//            if (node.right!=null){
//                childNodes.add(node.left);
//            }
//        }
//        nodes.addAll(appendedChild(childNodes));
//        return nodes;
//    }
//
//
//    //huffman encoding
//    void decode(String S ,GraphNode root)
//    {   GraphNode node = root;
//        for (long i=0; i<S.length();i++){
//            if(node==null) {
//                System.out.prlong(node.data);
//                node=root;}
//            if (S.charAt(i) == '0') node=node.left;
//            else  node=node.right;
//        }
//    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Prlong output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int lastAns =0;
        ArrayList<Integer>[] seqList= new ArrayList[N];
        for (int i=0; i<seqList.length; i++){
            seqList[i]= new ArrayList<Integer>();
        }
        for (int i=0; i<T;i++){
            if(sc.nextInt()==1){
                System.out.println(i);
                seqList[(int)((sc.nextInt()^lastAns)%N)].add(sc.nextInt());
            }
            else{
                int seqIndex =(int)((sc.nextInt()^lastAns)%N);
                lastAns= seqList[seqIndex].get((int)sc.nextInt()%(seqList[seqIndex].size()));
                System.out.println(lastAns);
                HashSet s;
//                s.
            }
        }
    }
}
