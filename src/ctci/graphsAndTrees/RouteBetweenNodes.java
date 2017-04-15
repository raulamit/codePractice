package ctci.graphsAndTrees;
import java .util.*;

/**
 * Created by raula on 3/5/2017.
 */
public class RouteBetweenNodes {
    public static void main(String[] args) {
    	GraphNode start = new GraphNode(10);
    	ArrayList<GraphNode> adj = new ArrayList();
    	GraphNode end = new GraphNode(4);
    	GraphNode tempNode =new GraphNode(6);
    	tempNode.adjacentNodes.add(start);
    	adj.add(new GraphNode(5));
    	adj.add(tempNode);
    	adj.add(end);
    	start.adjacentNodes= adj;

    	boolean isPath=isPathBetweenNodes(start,end);
        System.out.println(isPath);
    }

    public static boolean isPathBetweenNodes(GraphNode start, GraphNode end){
    	HashSet<GraphNode> startExplored = new HashSet();
    	// HashSet<GraphNode> endExplored = new HashSet();
    	LinkedList<GraphNode> startFringe = new LinkedList();
    	startFringe.add(start);
    	// LinkedList<GraphNode> endFringe = new LinkedList();
    	// endFringe.enqueue(start);
    	while(!startFringe.isEmpty()){
    		GraphNode currNode = startFringe.poll();
    		startExplored.add(currNode);
    		for(GraphNode n : currNode.adjacentNodes){
                System.out.println(n.data);
                if(!startExplored.contains(n)){
    		        startFringe.add(n);
    		        if(n.data==end.data) return true;
                }
            }
    	}
        return false;
    }
}
class GraphNode {
	public int data;
	public ArrayList<GraphNode> adjacentNodes= new ArrayList();

	public GraphNode(int d){
		data =d;
	}
}

