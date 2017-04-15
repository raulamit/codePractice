package ctci.arraysAndStrings;

/**
 * Created by raula on 2/24/2017.
 */
public class OneAway {
    public static void main(String[] args) {
        String a ="paled";
        String b= "pale";
        System.out.println(isOneEdit(a,b));
    }

    private static boolean isOneEdit(String a, String b) {
    	int l = a.length()>b.length()? b.length(): a.length();
    	if((a.length()-b.length())< -1 || (a.length()-b.length()) >1) return false;
    	boolean oneEdit=false;
    	int offset=0;
    	for(int i=0; i<l;i++){
    		if (a.charAt(i)!=b.charAt(i+offset)){
    			if(oneEdit){
    				return false;
    			}
    			oneEdit=true;
    			//replace
    			if (i==a.length()-1 && i==b.length()-1 || a.charAt(i+1)==b.charAt(i+1)) continue;
    			//insert and delete
    			else if (a.length() != b.length()){
    				if(l<a.length()){
    				    offset=-1;
    					if ( a.charAt(i+1)==b.charAt(i)) continue;
    					else return false;
    				}else if ( a.charAt(i)==b.charAt(i+1)){
    				    offset=1;
    				    continue;
                    }
    					else return false;
    			}else{
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
