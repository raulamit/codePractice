package ctci.arraysAndStrings;

/**
 * Created by raula on 2/24/2017.
 */
public class URLify {
    public static void main(String[] args) {
    	String input= "my name is john      ";
    	System.out.println(urlify(input));
    }

    private static String urlify(String in){
    	char[] inChars = in.toCharArray();
    	int end= inChars.length-1;
    	int strEnd= end;
    	while(inChars[strEnd]== ' '){
    		strEnd--;
    	}
    	while(strEnd>=0){
    		if(inChars[strEnd]==' '){
    			strEnd--;
    			inChars[end--]= '0';
    			inChars[end--]= '2';
    			inChars[end--]= '%';
    			
    		}else{
    			exchange(inChars,strEnd,end);
    			end--;
    			strEnd--;
    		}
    	}
    	return new String(inChars);
    }

    private static void exchange(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
