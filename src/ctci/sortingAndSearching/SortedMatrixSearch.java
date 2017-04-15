package ctci.sortingAndSearching;

import java.util.Arrays;

/**
 * Created by raula on 2/28/2017.
 */
public class SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] sortMat = {{1,2,6,8},
                            {3,7,9,10},
                            {4,11,12,13}};
        int[] indices= matrixSearch(sortMat,12);
        indices=matrixBinSearch(sortMat,0,0,sortMat.length-1,sortMat[0].length-1,10);
        System.out.println(indices[0]+ ",  "+indices[1]);
    }

    private static int[] matrixSearch(int[][] sortMat, int n) {
        int i=0;
        int j= sortMat[0].length-1;
        while(i<sortMat.length&&j>=0){
            if(sortMat[i][j]==n) return new int[]{i,j};
            if (sortMat[i][j]>n) j--;
            else i++;
        }
        return new int[]{-1,-1};
    }


    // fails when the diagonal element selected equals hr or hc
    /* Possible action that could be taken:
      * if row length greater search matrix after the diagonal row element
      * else
    * */
    private static int[] matrixBinSearch(int[][] mat,int lr, int lc, int hr, int hc, int n){
        int diagLength = 1+ Math.min(hr-lr,hc-lc);
        if (diagLength <=0) return new int[] {-1,-1};
        int startR= lr;
        int endR= lr+diagLength-1;
        int startC=lc;
        int endC= lc+diagLength-1;
        while(endC>startC &&endR>startR){
            int dl = (endC-startC)/2;
            if(mat[startR+dl][startC+dl]==n) return new int[] {startR+dl,startC+dl};
            else if (mat[startR+dl][startC+dl]>n){
                endC=(startC+dl)-1;
                endR=(startC+dl)-1;
            }else{
                startC+=dl+1;
                startR+=dl+1;
            }
        }
        return partitionAndSearch(mat,lr,lc,hr,hc,startC,startR,n);
    }

    private static int[] partitionAndSearch(int[][] mat, int lr, int lc, int hr, int hc, int startC, int startR, int n) {
        if(mat[startR][startC]==n) return new int[]{startR,startC};
        int[] indices = matrixBinSearch(mat,startR,lc,hr,startC-1,n);
        if(indices[0]==-1){
            return matrixBinSearch(mat,lr,startC, startR-1,hc,n);
        }else{
            return indices;
        }
    }

}
