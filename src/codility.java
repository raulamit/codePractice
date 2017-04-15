import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sanket on 1/20/17.
 */
public class codility {

    public codility() throws FileNotFoundException {
    }

    public String solution(int A, int B, int C, int D) {

        int[] arr = new int[4];

        arr[0] = A;
        arr[1] = B;
        arr[2] = C;
        arr[3] = D;

        Arrays.sort(arr);
        int len = 4;

        if ((arr[0] > 1 && arr[1] > 3) || (arr[0] > 2 || arr[1] > 5 || arr[2] > 9 || arr[3] > 9))
            return "Not Possible";

        StringBuilder sb = new StringBuilder();

        int first = 0, second = 0, third = 0, fourth = 0;

        for (int i = len - 1; i >= 0; i--) {

            if (arr[i] <= 2 && first < arr[i])
                first = arr[i];

            else if (((first <= 1 && arr[i] <= 9) || (first == 2 && arr[i] <= 3))
                    && second < arr[i])
                second = arr[i];

            else if (arr[i] <= 5 && third < arr[i])
                third = arr[i];

            else if (fourth < arr[i])
                fourth = arr[i];
        }

        if (first == 2 && second > 3) {

            int temp = second;

            if (third >= fourth) {

                if (third < 4) {

                    second = third;

                    if (temp > fourth && temp < 6)
                        third = temp;

                    else {
                        third = fourth;
                        fourth = temp;
                    }
                } else {
                    second = fourth;
                    fourth = temp;
                }
            } else {

                if (fourth < 4) {

                    second = fourth;

                    if (temp > third && temp < 6) {
                        fourth = third;
                        third = temp;
                    } else
                        fourth = temp;
                } else {
                    second = fourth;
                    fourth = temp;
                }

            }
        }

        sb.append(String.valueOf(first));
        sb.append(String.valueOf(second));
        sb.append(":");
        sb.append(String.valueOf(third));
        sb.append(String.valueOf(fourth));


        return sb.toString();
    }

 /*   public int solution2(int[] A){

            int len = A.length;
            int start, end, i, max, min;

            // find the start index where the unsorted array start
            for (start = 0; start < len-1; start++)
            {
                if (A[start] > A[start+1])
                    break;
            }

            if (start == len-1)
                return 0;           // array is already sorted

            //find the end index for an unsorted array
            for(end = len - 1; end > 0; end--) {

                if(A[end] < A[end-1])
                    break;
            }


            max = A[start]; min = A[start];

            // find max and min from the unsorted part
            for(i = start + 1; i <= end; i++) {

                if(A[i] > max)
                    max = A[i];
                if(A[i] < min)
                    min = A[i];
            }

            for( i = 0; i < start; i++) {

                if(A[i] > min) {
                    start = i;
                    break;
                }
            }

            for( i = len -1; i >= end+1; i--) {
                if(A[i] < max) {
                    end = i;
                    break;
                }
            }

            return (end-start)+1;
    }
*/
/*
    public static void main(String[] args){

        codility cod = new codility();
        System.out.println(cod.solution1(2,3,5,0));

        //System.out.println(cod.solution3());


        String str = "gggggt";

        */
/*StringBuilder sb = new StringBuilder();


        char[] chars = str.toCharArray();

        int count = 1;

        for (int i = 1; i < str.length(); i++){

            if (str.charAt(i) == str.charAt(i-1)){

                count++;
            }
            else {

                sb.append(count);
                sb.append(str.charAt(i-1));

                count = 1;
            }
        }

        if (str.charAt(str.length()-2) == str.charAt(str.length()-1)) {

            sb.append(count);
            sb.append(str.charAt(str.length() - 1));

        }
        else {
            sb.append(1);
            sb.append(str.charAt(str.length() - 1));

        }

        System.out.println(sb.toString());*//*

    }
*/

    /*
        public String solution1 (int a, int b , int c, int d){
            int[] arr= {a, b, c, d};
            Arrays.sort(arr);
            String output="";
            int index=-1;
            int limit =2;
            for (int i=0; i<arr.length; i++){
                if(arr[i]<=limit){
                    index=i;
                }
            }
            if (arr[index]==2) limit =3;
            else limit=9;
            if (index !=-1) {
                output+=arr[index];
                arr[index]=-1;
            }
            else return "NOT POSSIBLE";
            index=-1;
            for (int i=0; i<arr.length; i++){
                if(arr[i]>=0 && arr[i]<=limit){
                    index=i;
                }
            }

            if (index !=-1) {
                output+=arr[index]+":";
                arr[index]=-1;
            }
            else return "NOT POSSIBLE";


            limit=5;
            index=-1;
            for (int i=0; i<arr.length; i++){
                if(arr[i]>=0 && arr[i]<=limit){
                    index=i;
                }
            }
            if (index !=-1) {
                output+=arr[index];
                arr[index]=-1;
            }
            else return "NOT POSSIBLE";
            limit=9;

            index=-1;
            for (int i=0; i<arr.length; i++){
                if(arr[i]>=0 && arr[i]<=limit){
                    index=i;
                }
            }
            if (index !=-1) {
                output+=arr[index];
                arr[index]=-1;
            }
            else return "NOT POSSIBLE";

            return output;

        }

    */
    public static void main(String[] args) throws IOException {


        PrintWriter pw = new PrintWriter(new File("C:\\Users\\raula\\Documents\\MAD\\wordlist_en_str.txt"));
        File f = new File("C:\\Users\\raula\\Documents\\MAD\\wordlist.txt");

        Scanner sc = new Scanner(f);
        int max = 0;
        // max size of word is 45
        DataOutputStream dosInt=new DataOutputStream(new FileOutputStream(new File("C:\\Users\\raula\\Documents\\MAD\\wordlist_en_int.txt")));
        DataOutputStream dosLong=new DataOutputStream(new FileOutputStream(new File("C:\\Users\\raula\\Documents\\MAD\\wordlist_en_long.txt")));
        while (sc.hasNext()) {
            String word = sc.nextLine();
            if(word=="add"){
                System.out.println();
            }
            if (word.length() <= 6) {
                outputInt(word,dosInt);
            }
            else if(word.length() <= 12 &&word.length()>8){
                outputLong(word,dosLong);
            }
            else {
                pw.println(word);
            }
        }
//        sc.close();
//        sc=new Scanner(f);
//        while (sc.hasNext()) {
//            String word = sc.nextLine();
//            if(word.length()>12) pw.println(word);
//        }
        dosInt.close();
        dosLong.close();

        sc.close();

        System.out.println(max);
        pw.close();

    }

    private static void outputInt(String word, DataOutputStream dos) throws IOException {
        char[] chars = word.toCharArray();
        int intValue = 0;
        for (char c : chars) {

            intValue += c - 96;
            intValue = intValue << 5;
        }
        if(word=="add"){
            System.out.println(intValue);
        }
        dos.writeInt(intValue);
    }

    private static void outputLong(String word, DataOutputStream dos) throws IOException {
        char[] chars = word.toCharArray();
        long longValue = 0;
        for (char c : chars) {
            longValue += c - 96;
            longValue = longValue << 5;
        }
        dos.writeLong(longValue);
    }
}