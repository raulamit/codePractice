package interviewQuestions;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by raula on 3/1/2017.
 */
public class targetSum {

    static HashMap<String,Integer> mp= new HashMap<>();
    public static void main(String[] args) {
    	int[] a = {13,12,11,10,0,1,2,3,9,4};
    	int k=18;
    	int m=4;
        Random rnd = new Random();
        int t= 50;
        int count=0;
        for (int i=0; i<t;i++){
            int n= 2+rnd.nextInt(12);
            int[] A= new int[n];
            for (int j = 0; j < n; j++) {
                A[j]= rnd.nextInt(n*2);
            }
            int M= rnd.nextInt(Math.max(n/2,1));
            int K = rnd.nextInt(n*3);
            int recur=targetSum(A,0,K,M,"");
            int iter =iterativeTargetSum(A,K,M);
            if(recur==iter) System.out.println("same");
            else {
                count++;
                System.out.println("Different"+ "\t recur"+ recur +"\t iter"+ iter);
            }
        }
        System.out.println(count);
//        System.out.println(targetSum(a,0,k,m,""));
        System.out.println(iterativeTargetSum(a,k,m));
    }

    public static int targetSum(int[] a,int i,int k,int m, String s){
//        if(mp.containsKey(i+","+k+","+m)) return mp.get(i+","+k+","+m);
    	if(k<0) return 0;
    	if(m==0) {
            if (k == 0){
                System.out.println(s);
                return 1;
            }
            else return 0;
        }
        if(i>=a.length) return 0;
    	else{
    	    int sum= targetSum(a,i+1,k,m,s)+targetSum(a,i+1,k-a[i],m-1,s+","+a[i]);
    	    mp.put(i+","+k+","+m,sum);
    		return sum;
    	}
    }

   public static int iterativeTargetSum(int[] A,int K, int M ){
        int sum=0;
        int memo[][][] = new int[M+1][K+1][A.length+1];
        for(int m=0; m<=M;m++){
            for (int k=0; k<=K;k++){
                for(int i=0; i<=A.length;i++){
                    if(m==0){
                        if(k==0) memo[m][k][i]=1;
                    }/*else if(i==0){
                            if(m==0 && k==0) memo[m][k][i]=1;
                    }*/else if(i>0){
                        if(k-A[i-1]>=0)
                            memo[m][k][i]=  memo[m-1][k-A[i-1]][i-1]  +  memo[m][k][i-1];
                        else  memo[m][k][i]=memo[m][k][i-1];

                    }
                }
            }
        }
        return memo[M][K][A.length];
    }

}
