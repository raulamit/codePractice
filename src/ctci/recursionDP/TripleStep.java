package ctci.recursionDP;

/**
 * Created by raula on 3/1/2017.
 */
public class TripleStep {
    static int[] memo;
    public static void main(String[] args) {
        int n=5;
        memo= new int[n+1];
        for (int i=0;i<=n;i++) memo[i]=-1;
        if(n==0) System.out.println(0);
        else System.out.println(tripleSteps(n));
    }

    private static int tripleSteps(int n) {
        if(n==0) return 1;
        if(n<0) return 0;
        if (memo[n]!=-1) return memo[n];
        else{
            memo[n]= tripleSteps(n-1)+tripleSteps(n-2)+tripleSteps(n-3);
            return memo[n];
        }
    }
}
