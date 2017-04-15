package ctci.arraysAndStrings;
import java.util.*;
/**
 * Created by raula on 2/24/2017.
 */
public class isUnique {
	public static void main(String[] args){
		String input= "helWlord";
		if(isUnique(input)) System.out.println("is unique");
		else System.out.println("not unique");
        if(isUniqueSlow(input)) System.out.println("is unique");
        else System.out.println("not unique");
		if(isUniqueFast(input)) System.out.println("is unique");
        else System.out.println("not unique");
        if(isUniqueAfterSort(input)) System.out.println("is unique");
        else System.out.println("not unique");
	}


	// using hashSet
    private static boolean isUnique(String input) {
        HashSet<Character> charSet= new HashSet<>();
        char[] inputChars = input.toCharArray();
        for (char c : inputChars){
            if(charSet.contains(c)){
                return false;
            }
            else{
                charSet.add(c);
            }
        }
        return true;
    }

    //without addition datastructures
    private static boolean isUniqueSlow(String input){
    	char[] inputChars= input.toCharArray();
    	for (int i=0;i<inputChars.length ;i++ ) {
    		for (int j =i+1;j<inputChars.length ;j++ ) {
 				if(inputChars[i]==inputChars[j]) return false;   			
    		}
    	}
    	return true;
    }

    //uses array of boolean chars
    private static boolean isUniqueFast(String input){
    	boolean[] charsused = new boolean[256];
    	char[] inputChars= input.toCharArray();
    	for (char c: inputChars) {
    		if(charsused[c]) return false;
    		else charsused[c] = true;
    	}
    	return true;
    }

    //sorts the string and compares uniqueness
    private static boolean isUniqueAfterSort (String input){
    	char[] inputChars= input.toCharArray();
    	quickSort(inputChars,0,inputChars.length-1);
//        Arrays.sort(inputChars);
    	for(int i=0; i<inputChars.length-1;i++){
    		if(inputChars[i]==inputChars[i+1]) return false;
    	}
    	return true;
    }

    private static int partition(char[] input, int l,int h){
    	char pivot = input[h];
    	int i=l-1;
    	for(int j=l; j<h;j++){
    		if(input[j]<pivot){
    			i++;
    			exchange(input,i,j);
    		}
    	}
    	exchange(input,i+1,h);
    	return i+1;
    }

    private static void quicksort(char[] input, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = input[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (input[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (input[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(input,i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(input,low, j);
        if (i < high)
            quicksort(input,i, high);
    }

    private static void exchange(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static void quickSort(char[] input,int l,int h){
       if(l>=h) return;
    	// int pivot= (l+h)/2;
    	int lh= partitionBoth(input,l,h);
    	// if(l<lh-1)
    	quickSort(input,l,lh-1);
    	// if (lh<h) 
    	quickSort(input,lh+1,h);
    }

    private static int partitionBoth(char[] input, int l, int h){
        int pivot =(l+h)/2;
    	while(l<h){
    		while(input[l]<input[pivot]) l++;
    		while(input[h]>input[pivot]) h--;
    		if(l<h){
                exchange(input,l,h);
            }
    	}
    	return l;
    }
}
