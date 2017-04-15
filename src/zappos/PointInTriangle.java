package zappos;

/**
 * Created by raula on 2/4/2017.
 */
public class PointInTriangle {
    public static void main(String[] args) {
        System.out.println(
                insideTriangle(3,7,5,1,1,1,5,1)
        );

    }


    public static boolean insideTriangle(int x1, int x2, int x3, int x, int y1, int y2, int y3, int y ){
        return sameSide(x1,x2,x3,x,y1,y2,y3,y)&&
                sameSide(x3,x1,x2,x,y3,y1,y2,y)&&
                sameSide(x2,x3,x1,x,y2,y3,y1,y)
                || onTriangle(x1,x2,x3,x,y1,y2,y3,y)||
                onTriangle(x3,x1,x2,x,y3,y1,y2,y)||
                onTriangle(x2,x3,x1,x,y2,y3,y1,y);
    }


    public static boolean sameSide(int x1, int x2, int x3, int x, int y1, int y2, int y3, int y ){
        return !(((y-y1)*(x2-x1)>(y2-y1)*(x-x1))
                ^((y3-y1)*(x2-x1)>(y2-y1)*(x3-x1)));
    }
    public static boolean onTriangle(int x1, int x2, int x3, int x, int y1, int y2, int y3, int y ){
        return ((y-y1)*(x2-x1)==(y2-y1)*(x-x1));
    }

    public static float getSlope(int x1, int x2, int y1, int y2){
        try{return (y2-y1)/(x2-x1);}
        catch (Exception e){
            return Float.MAX_VALUE;
        }
    }
}
