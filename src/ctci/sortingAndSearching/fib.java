package ctci.sortingAndSearching;

/**
 * Created by raula on 3/14/2017.
 */
public class fib {
    public static void main(String[] args) {
//        System.out.println(2+"2"+ 2);
        printFibonacci(5);
    }
    public static void printFibonacci(int n){
        if (n==0) return;
        int f=1;
        int s= 1;
        System.out.println(1);

        printRec(n - 1, f, s);
    }

    public static void printRec(int n, int f ,int s){
        if (n==1) System.out.println(s);
        else{
            System.out.println(s);
            printRec(n-1, s, f+s);
        }
    }

}
