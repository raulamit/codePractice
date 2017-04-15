package ctci.sortingAndSearching;

/**
 * Created by raula on 3/1/2017.
 */
public class PeaksAndValley {
    public static void main(String[] args) {
        int[] in ={8,5,4,6,7,2};

        transformPeakAndValley(in);
        for (int num:in) {
            System.out.print(num+ "  ");
        }
    }

    private static void transformPeakAndValley(int[] in) {
        for (int i = 1; i < in.length; i+=2) {
            if(i+1<in.length){
                if(in[i+1]>=in[i-1]){
                    if(in[i+1]>in[i]){
                        int temp=in[i];
                        in[i]=in[i+1];
                        in[i+1]=temp;
                    }
                }else{
                    if(in[i-1]>in[i]){
                        int temp=in[i];
                        in[i]=in[i-1];
                        in[i-1]=temp;
                    }
                }
            }else{
                if(in[i-1]>in[i]){
                    int temp=in[i];
                    in[i]=in[i-1];
                    in[i-1]=temp;
                }
            }

        }
    }
}
