package ctci.recursionDP;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by raula on 3/3/2017.
 */
public class PowerSet {
    public static void main(String[] args) {
        Integer[] set ={1,4,2,5,7};
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(set));

        ArrayList<ArrayList<Integer>> subs= listOfsubsets(a,0, new ArrayList<>());
        for (ArrayList<Integer> subset: subs     ) {
            for (int num: subset ) {
                System.out.print(num +" ");
            }
            System.out.println();
        }
        System.out.println(subs.size());
    }

    /*private static ArrayList<ArrayList<Integer>> listOfsubsets(ArrayList<Integer> a, int i) {
        if (i>=a.size()){
            ArrayList<ArrayList<Integer>> emptySubset= new ArrayList<>();
            emptySubset.add(new ArrayList<>());
            return emptySubset;
        }
        else{
            ArrayList<ArrayList<Integer>> newArrList = new ArrayList<>();
            ArrayList<ArrayList<Integer>> nextArrList = listOfsubsets(a,i+1);
            newArrList.addAll(nextArrList);
            for ( ArrayList<Integer> subset: nextArrList) {
                ArrayList<Integer> newSubset = new ArrayList();
                newSubset.addAll(subset);
                newSubset.add(a.get(i));
                newArrList.add(newSubset);
            }
            return newArrList;
        }
    }*/

    private static ArrayList<ArrayList<Integer>> listOfsubsets(ArrayList<Integer> a, int i,ArrayList<Integer> subset) {
        if (i>=a.size()){
            ArrayList<ArrayList<Integer>> leaf= new ArrayList<>();
            leaf.add(subset);
            return leaf;
        }
        else{
            ArrayList<ArrayList<Integer>> allSubset = new ArrayList<>();
            allSubset.addAll(listOfsubsets(a,i+1,subset));
            ArrayList<Integer> subsetWIthEl = new ArrayList<>();
            subsetWIthEl.addAll(subset);
            subsetWIthEl.add(a.get(i));
            allSubset.addAll(listOfsubsets(a,i+1,subsetWIthEl));
            return allSubset;
        }
    }
}
