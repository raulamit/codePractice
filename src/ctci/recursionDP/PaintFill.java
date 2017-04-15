package ctci.recursionDP;

/**
 * Created by raula on 3/4/2017.
 */
public class PaintFill {
    public static void main(String[] args) {
        int[][] colorMat = {{1,2,2,2,3,3,4},{1,2,2,2,3,3,4},{1,2,2,2,3,3,3},{1,2,3,3,3,3,4}};
        fillColor(colorMat,3,0,1,4);
        for (int[] a:colorMat     ) {
            for (int b: a) {
                System.out.print( b+" ");
            }
            System.out.println();
        }
    }

    private static void fillColor(int[][] colorMat, int oc , int nc, int r, int c) {
    	if (r>=colorMat.length || r<0 ||c<0|| c>=colorMat[0].length) return;
    	else{
    		if(colorMat[r][c]==oc){
    			colorMat[r][c]=nc;
    			fillColor(colorMat,oc,nc,r+1,c);
    			fillColor(colorMat,oc,nc,r-1,c);
    			fillColor(colorMat,oc,nc,r,c+1);
    			fillColor(colorMat,oc,nc,r,c-1);
    		}else return;
    	}
    }
}
