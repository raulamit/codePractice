import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by raula on 12/20/2016.
 */
public class Dungeons {

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numList = new ArrayList<>();
        while (sc.hasNext()) {
            numList.add(sc.nextInt());
        }
        System.out.println("failure");
        Integer[] numArray = numList.toArray(new Integer[0]);

        LinkedList<Integer[]> frontier = new LinkedList<>();
        HashSet<Integer> exploredSet = new HashSet<>();
        frontier.add(new Integer[]{0});
        Boolean goal= false;
        while (!frontier.isEmpty()){
            Integer[] currentNode= frontier.poll();
            int currentIndex = currentNode[currentNode.length-1];
            if (exploredSet.contains(currentIndex)) continue;
            else exploredSet.add(currentIndex);

            ArrayList<Integer> successors= getChildren(numArray,currentIndex);
            if (successors==null){
                goal=true;
                printpath(currentNode);
            }else{
                for (int successor : successors){
                    frontier.add( Stream.concat(Arrays.stream(currentNode), Arrays.stream(new Integer[]{successor}))
                            .toArray(Integer[]::new));
                }
            }
        }
        if(!goal){
            System.out.println("failure");
        }

    }

    public static ArrayList<Integer> getChildren(Integer[] numArray, int index ){
        ArrayList<Integer> children= new ArrayList<>();
        for (int i =index+1 ; i < index+1+numArray[index] ;i++){
            if(i>=numArray.length){
                return null;
            }
            else if (numArray[i]!=0){
                children.add(i);
            }
        }
        return children;
    }
    public static void printpath(Integer[] path){
        for (Integer num: path) {
            System.out.print(num +", ");
        }
        System.out.println("out");
    }
}
