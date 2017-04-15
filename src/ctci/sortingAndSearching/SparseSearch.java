package ctci.sortingAndSearching;

/**
 * Created by raula on 2/27/2017.
 */
public class SparseSearch {
    public static void main(String[] args) {
        String[] sparseInput ={ "at","", "","","the", "","ball", "","","park", "","outside"};

        System.out.println(sparseSearch(sparseInput,0,sparseInput.length-1,"ball"));

    }

    private static int sparseSearch(String[] s, int l, int h,String query) {
        if (h<l) return -1;
        int mid=(l+h)/2;
        if(s[mid].equals(query)) return mid;
        if (s[mid].length()==0){
            int index= sparseSearch(s,mid+1,h,query);
            return index==-1?sparseSearch(s,l,mid-1,query):index;
        }
        if(s[mid].compareTo(query)<0) return sparseSearch(s,mid+1,h,query);
        else return sparseSearch(s,l,mid-1,query);
    }
}
