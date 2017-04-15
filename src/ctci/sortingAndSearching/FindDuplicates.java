package ctci.sortingAndSearching;

/**
 * Created by raula on 2/28/2017.
 */
public class FindDuplicates {
    public static void main(String[] args) {
        int[] intList= {221,342,3434,2312,1212,3223,32,2,42,32,3434,221,1212};
        boolean[] dupCheck= new boolean[32000];

        for (int i:intList) {
            if(dupCheck[i-1]){
                System.out.println(i);
            }else{
                dupCheck[i-1]=true;
            }
        }
    }
}
