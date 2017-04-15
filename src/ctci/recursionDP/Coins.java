package ctci.recursionDP;

import java.util.*;

/**
 * Created by raula on 3/4/2017.
 */
public class Coins {
	public static HashMap<String,Integer> memo = new HashMap();
    public static void main(String[] args) {
    	int n=15;
        Integer[] coins= {25,10,5,1};
        Arrays.sort(coins, Collections.reverseOrder());
        System.out.println(findWays(coins,n,coins[0]));
    }

    private static int findWays(Integer[] coins, int n, int maxCoin){
    	if (n<0) return 0;
    	if (n==0) return 1;
    	if(memo.containsKey(""+n+","+maxCoin)) return memo.get(""+n+","+maxCoin);
    	else{
    		int count=0;
    		boolean start = false;
    		int startCoin=0;

    		for ( int coin: coins){
    			if (coin<=maxCoin){
					count+=findWays(coins, n-coin,coin);
    		    }
    		}
    		memo.put(""+n+","+maxCoin,count);
    		return count;
    	}
    }
}
