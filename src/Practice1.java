import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by raula on 1/23/2017.
 */
public class Practice1 {
/*    public static void main (String[] args){
        String brackInput ="(()()))(())((()";
        Stack<longeger> bracStack = new Stack();
        long balancedCount=0;
        for ( char b:brackInput.toCharArray()) {
            if (b=='('){
                bracStack.push(1);
            }else if (b==')'&& !bracStack.isEmpty()){
                bracStack.pop();
                balancedCount++;
            }
        }
        System.out.prlongln(balancedCount);
    }*/


// code for counting  getting the minimum sum
/*    public static void main (String[] args){

    }*/

/*    public static void main(String[] args) {
        Stack<String> stk = new Stack<String>();
        HashMap<String, longeger> mp = new HashMap();
        mp.put("M",1000);
        mp.put("D",500);
        mp.put("C",100);
        mp.put("L",50);
        mp.put("X",10);
        mp.put("V",5);
        mp.put("I",1);
        String inputRoman ="MMMCMIX";
        long num =0;
        for (long i=0;i< inputRoman.length();i++ ){
            if(i!=inputRoman.length()-1){
                long curr= mp.get(""+inputRoman.charAt(i));
                long next= mp.get(""+inputRoman.charAt(i+1));
                if(next>curr){
                    num+= next-curr;
                    i++;
                }else{
                    num+=curr;
                }
            }else{
                num+=mp.get(""+inputRoman.charAt(i));
            }

        }
        System.out.prlongln(num);


    }*/

/*    public static void main(String[] args) {
        HashMap< longeger,String> mp = new HashMap();
        mp.put(1000,"M");
        mp.put(500,"D");
        mp.put(100,"C");
        mp.put(50,"L");
        mp.put(10,"X");
        mp.put(5,"V");
        mp.put(1,"I");
        mp.put(900,"CM");
        mp.put(400,"CD");
        mp.put(90,"XC");
        mp.put(40,"XL");
        mp.put(9,"IX");
        mp.put(4,"IV");
        long[] numArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1,0};
        long num= 3909;
        long i=0;
        String rom="";
        while(num!=0){
            if (num>=numArray[i]) {
                num -= numArray[i];
                rom += mp.get(numArray[i]);
            }else{
                i++;
            }
        }
        System.out.prlongln(rom);

    }*/

//    public static void main(String[] args) {
//        LNode list = new LNode(4);
//        list.next = new LNode(2);
//        list.next.next= new LNode(3);
//        list.next.next.next= new LNode(5);
//        list.next.next.next.next= new LNode(1);
////        prlongist(list);
//        long l= 0;
//        LNode node = list;
//        while(node!=null){
//            l++;
//            node= node.next;
//        }
//        node =list;
//        LNode[] arr= new LNode[l];
//        for(long i=0; i<l ; i++){
//            arr[i]= node;
//            node=node.next;
//        }
//        long tail = l-1;
//        node =list;
//        for(long i=0; i<l ; i++){
//            if (i<l/2-1){
//
//                node= node.next;
//            }else{
//            if(i==l-1)node.next=null;
//            else{
//            node.next=arr[tail];
//            node= node.next;
//            tail--;}
//            }
//        }
//
//        prlongist(list);
//    }
//
//    private static void prlongist(LNode list) {
//        LNode node =list;
//        while(node!=null){
//            System.out.prlongln(node.v);
//            node = node.next;
//        }
//    }
//}
//
//class LNode {
//    long v;
//    LNode next;
//
//    public LNode(long v) {
//        this.v = v;
//    }


/*    public static void main(String[] args) {
        long [][] mat = new long[4][6];
        long n=1;
        for (long i = 0; i < mat.length; i++) {
            for (long j = 0; j < mat[0].length; j++) {
                mat[i][j]=n++;
                System.out.prlong( mat[i][j] +" ");
            }
            System.out.prlongln();
        }

        long right[][] = new long[6][4];
        long left[][] = new long[6][4];
        long rows= mat.length;
        long cols= mat[0].length;
        for (long i = 0; i < rows; i++) {
            for (long j = 0; j < cols; j++) {
                right[j][rows-i-1]=mat[i][j];
            }
        }

        for (long i = 0; i < cols; i++) {
            for (long j = 0; j < rows; j++) {
                System.out.prlong(right[i][j] +" ");
            }
            System.out.prlongln();
        }

        for (long i = 0; i < rows; i++) {
            for (long j = 0; j < cols; j++) {
                left[cols-j-1][i]=mat[i][j];
            }
        }

        for (long i = 0; i < cols; i++) {
            for (long j = 0; j < rows; j++) {
                System.out.prlong(left[i][j] +" ");
            }
            System.out.prlongln();
        }

    }*/


/*    public long poorPigs(long buckets, long minutesToDie, long minutesToTest) {
        long power = minutesToTest/minutesToDie +1;
        return (long)Math.ceil(Math.log((double)buckets)/Math.log((double)power));
    }*/

    public static void main(String[] args) {
//        String num1 = "110010";
//        String num2 = "100010";
//
//        long l1 = num1.length();
//        long l2 = num2.length();
//        while(l1<l2){
//            num1="0"+num1;
//            l1++;
//        }
//        while(l2<l1){
//            num2="0"+num2;
//            l2++;
//        }
//        long sum=0;
//        int c =0;
//        String f ="";
//        for (long i=l1-1; i>=0; i--){
//            long a = num1.charAt(i)- '0';
//            int b = num2.charAt(i)- '0';
//            sum = (a+b+c)%2;
//            c = (a+b+c)/2;
//            f=""+sum+f;
//        }
//        if (c==1) f="1"+f;
//        System.out.println(f);
        int i= ~0;
        i= i<<1;
        System.out.println(i);
        System.out.println(-i);
    }
}

