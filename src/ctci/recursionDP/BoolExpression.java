package ctci.recursionDP;
import java.util.*;
/**
 * Created by raula on 3/5/2017.
 */
public class BoolExpression {
	public static HashMap<String,Integer> memo= new HashMap();
    public static void main(String[] args) {
        String exp = "0&0&0&1^1|0";
        boolean result= true;
        int count=getBoolExpCount(exp,result);
        System.out.println(count);
    }

    private static int getBoolExpCount(String exp, boolean result) {
    	if(exp.length()==1){
    		return result&&exp.equals("1")||(!result)&&exp.equals("0")?1:0;
    	}else if (memo.containsKey(exp+","+result)) return memo.get(exp+","+result);
    	else{
    		int count=0;
    		for( int i=1; i<exp.length(); i+=2){
    			String left= exp.substring(0,i);
    			String right= exp.substring(i+1);
    			char op = exp.charAt(i);
    			int leftTrue= getBoolExpCount(left,true);
    			int rightTrue= getBoolExpCount(right,true);
    			int leftFalse= getBoolExpCount(left,false);
    			int rightFalse = getBoolExpCount(right,false);
    			if(result){
	    			if(op=='|') count+=(leftTrue*rightTrue +leftTrue*rightFalse+leftFalse*rightTrue);
	    			else if (op=='&') count+= (leftTrue*rightTrue);
	    			else count+= (leftTrue*rightFalse +leftFalse*rightTrue);
    			}else{
    				if(op=='&') count+=(leftFalse*rightFalse +leftTrue*rightFalse+leftFalse*rightTrue);
	    			else if (op=='|') count+= (leftFalse*rightFalse);
	    			else count  += (leftTrue*rightTrue +leftFalse*rightFalse);
    			}
    		}
	    	memo.put(exp+","+result,count);
	    	return count;
    	}
    }

}
