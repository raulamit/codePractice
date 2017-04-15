package ctci.graphsAndTrees;

import java.util.HashSet;

/**
 * Created by raula on 3/6/2017.
 */
public class BuildOrder {
    public static void main(String[] args) {
        boolean[][] dependency= {{false,false,false,true,false,false},//a
                                 {false,false,false,true,false,false},//b
                                 {false,false,false,false,false,false},//c
                                 {false,false,true,false,false,false},//d
                                 {false,false,false,false,false,false},//e
                                 {true,true,false,false,false,false}};//f
        HashSet<Integer> built= new HashSet<>();
        printBuildOrder(dependency,built);
    }

    private static void printBuildOrder(boolean[][] dependency, HashSet<Integer> built) {
        for (int j=0; j<dependency.length; j++){
            int i;
            if(built.contains(j)){
                if(j==dependency.length-1&&built.size()==dependency.length){
                    j=-1;
                }
                continue;
            }
            for (i=0; i<dependency[0].length; i++){
                if(dependency[i][j]) break;
            }
            if(i<dependency[0].length&&dependency[i][j]) continue;
            built.add(j);
            System.out.println((char)(j+'a')+" ");
            clearRow(dependency,j);
            j=-1;
        }

    }

    private static void clearRow(boolean[][] dependency, int i) {
        for (int j = 0; j < dependency.length; j++) {
            dependency[i][j] =false;
        }
    }
}
