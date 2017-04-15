package ctci.recursionDP;

/**
 * Created by raula on 3/3/2017.
 */
public class RecursiveMultiply {
    public static void main(String[] args) {
        int a =9;
        int b =23;
/*//        System.out.println(recursiveMul(a,b));
//
        int res =0;
        while(a>0){
            res+=b;
            a--;
        }
        System.out.println(res);*/
        int max=1;
        int power=0;
        while(max>a &&max>b){
            max = max<<1;
            power++;
        }
        System.out.println(multiply(a,b,power));
        System.out.println(a*b);
    }

    private static int multiply(int a, int b, int p) {
        int min,max =0;
        if( a>b){
            min=b;
            max=a;
        }else{
            min=a;
            max=b;
        }
        int res=max;
        if (min==0) return 0;
        if(min==1) return max;
        res = multiply(max,(min>>1),0);
        if((min & 1)==0){
            res= res<<1;
        }else{
            res+=multiply(max,min-(min>>1),0);
        }
        return res;
    }
}
