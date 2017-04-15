import java.util.*;

/**
 * Created by raula on 3/2/2017.
 */
public class InfixEvaluation {
    public static void main(String[] args) {
        String digits="123";
        System.out.println(dp(digits,0,6,""));
    }

    String[] composeExpression(String digits, int target) {
        String result= dp(digits,0,target,"");
        if (result.equals("")) return new String[0];
        String[] resultArray=result.substring(1).split(",");
        Arrays.sort(resultArray);
        return resultArray;
    }


    public static String dp(String digits,int i, int target, String currString){
        if(i==digits.length()-1){
            currString+=digits.charAt(i);
            int currSum= evaluateVal(currString);
            if (currSum==target) return ","+currString;
            else return "";
        }else{
            return dp(digits,i+1,target,currString+digits.charAt(i)+"+")+
                    dp(digits,i+1,target,currString+digits.charAt(i)+"-")+
//to include cases like 13 +2       dp(digits,i+1,target,currString+digits.charAt(i))
                    dp(digits,i+1,target,currString+digits.charAt(i)+"*");
        }
    }


    // need to change the logic to include digits of size more than 1
    public static int evaluateVal(String exp){
        Stack<Integer> numStk = new Stack<>();
        Stack<Character> opStk = new Stack<>();
        for (int i=0; i<exp.length(); i++){
            char val = exp.charAt(i);
            int num=0;
            while(val-'0'<=9&&val-'0'>=0){
                if(num!=0) num*=10;
                num+= (val-'0');
                i++;
                if(i<exp.length()){
                    val=exp.charAt(i);
                }
            }
            numStk.push(num);

            if(val=='+' || val =='-') {
                while(!opStk.isEmpty())
                    if (opStk.peek()=='*') {
                        int res = numStk.pop()*numStk.pop();
                        opStk.pop();
                        numStk.push(res);
                    }else{
                        int res=0;
                        if(opStk.peek()=='+') res = numStk.pop()+numStk.pop();
                        else res = -numStk.pop()+numStk.pop();
                        opStk.pop();
                        numStk.push(res);
                    }
            }
            else{
                while(!opStk.isEmpty() &&opStk.peek()=='*'){
                    int res = numStk.pop()*numStk.pop();
                    opStk.pop();
                    numStk.push(res);
                }
            }
            opStk.push(val);
        }

        while(!opStk.isEmpty()){
            int res =0;
            char op=opStk.pop();
            if(op=='*'){
                res= numStk.pop()*numStk.pop();
            }else if(op=='+') res= numStk.pop()+numStk.pop();
            else res= -numStk.pop()+numStk.pop();
            numStk.push(res);
        }
        return numStk.pop();
    }


}
