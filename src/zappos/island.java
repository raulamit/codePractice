package zappos;

import java.util.Scanner;

/**
 * Created by raula on 2/4/2017.
 */
public class island {
    private static int m,n;

    public static void main(String[] args) {

    Scanner sc = new Scanner (System.in);
    m = sc .nextInt();
    n = sc.nextInt();
    int[][] mat = new int[m][n];
    int count=0;
        for (int i=0; i<m; i++){
        for (int j=0; j<n; j++){
            mat[i][j]= sc.nextInt();
        }
    }
        for (int i=0; i<m; i++){
        for (int j=0; j<n; j++){
            if (mat[i][j]==1){
                count++;
                exploreIsland(mat, i ,j);
            }
        }
    }

        System.out.println(count);
}

    public static void exploreIsland(int[][] mat, int i, int j){
        if (i>=m||i<0||j<0||n<=j) return;
        if (mat[i][j]==0) return;
        mat[i][j]=0;
        for (int a=-1; a<2;a++){
            for (int b=-1; b<2;b++){
                exploreIsland(mat,i+a, j+b);
            }
        }

    }
}
