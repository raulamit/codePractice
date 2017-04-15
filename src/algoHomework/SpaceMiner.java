package algoHomework;

/**
 * Created by raula on 4/1/2017.
 */
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Point{
    int x;
    int y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }

}

public class SpaceMiner {
    public static Point home = new Point(0,0);
    public static Point[] points=null;
    public static HashMap<String,Integer> memo = new HashMap();
    public static HashMap<String, Integer> distances= new HashMap();
    public static int n;
    public static String[] ls= null;
    public static ArrayList<Integer> sub = new ArrayList<>();
    public static HashMap<Integer,String> subL = new HashMap<>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner (System.in);
        n= sc.nextInt();
        points= new Point[n];
        for (int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x,y);
        }
        ls = new String[n + n*(n-1)/2];
        updateDistances(points,ls);
        HashSet<String> set = new HashSet();
        findMinCost(n-1 + n*(n-1)/2, set,0,"");
        int min= Integer.MAX_VALUE;
        for(int m:sub) if(min>m) min=m;
        System.out.println(min);
//        System.out.println(findMinCost(home,2,n));
    }

    public static void findMinCost(int index, HashSet<String> set, int min,String s){
        if(s.equals("3,8;2,10 ")){
            System.out.println();
        }
        if (set.size()==n){
            sub.add(Integer.valueOf(min));
            subL.put(Integer.valueOf(min),s);
            return;
        }else{
            if(index<0) return ;
            String[] ps = ls[index].split(";");
            for(String d: ps){
                if(set.contains(d)) return ;
            }
            findMinCost(index-1,set,min,s);
            HashSet<String> cloneSet= (HashSet<String>) set.clone();
            int k=0;
            for(String d: ps){
                cloneSet.add(d);
                k++;
            }
            if(k>=2){
                if(k>2){
                    System.out.println();
                }
            }
            int c2=distances.get(ls[index]);
            findMinCost(index-1, cloneSet,min+c2,ls[index]+" "+s);
        }
    }

    public static void updateDistances(Point[] points, String[] ls){
        int index=0;
        for(Point point: points){
            ls[index]=point.x+","+point.y;
            distances.put(ls[index],2*distance(point,new Point(0,0)));
            index++;
        }
        for(int i=0; i<points.length;i++){
            Point p1=points[i];
            for(int j=i+1; j<points.length;j++){
                Point p2=points[j];
                ls[index]= p1.x+","+p1.y +";"+p2.x+","+p2.y;
                distances.put(ls[index],distance(p1,new Point(0,0))+
                                        distance(p2,new Point(0,0))+
                                        distance(p1,p2));
                index++;
            }
        }
    }
    public static int findMinCost(Point curr, int t, int n){
        if(n==0){
            if(curr.x==0&&curr.y==0) return 0;
            else return distance(curr, home);
        }
        else{
            if(t==0){
                return distance(home, curr) + findMinCost(home,2,n);
            }
            else{
                int min =Integer.MAX_VALUE;
                if(!(curr.x==0&&curr.y==0)){
                    min= distance(home,curr)+ findMinCost(home,2,n);
                }
                for (int i=0; i<points.length;i++){
                    if(points[i].x==100) continue;
                    int x= points[i].x;
                    int y =points[i].y;
                    points[i].x=100;
                    points[i].y=100;
                    min = Math.min(min,distance(new Point(x,y),curr)+ findMinCost(new Point(x,y),t-1,n-1));
                    if(t==2) min= Math.min(min,2*distance(home,new Point(x,y))+findMinCost(home,2,n-1));
                    points[i].x=x;
                    points[i].y=y;
                }
                if(min==Integer.MAX_VALUE) return 0;
                return min;
            }
        }
    }



/*    public static int findMinCost(Point curr, int t, int n){
        if(memo.containsKey(""+curr.x+","+curr.y+","+t+","+n)) return memo.get(""+curr.x+","+curr.y+","+t+","+n);
        if(n==0){
            if(curr.x==0&&curr.y==0) return 0;
            else return distance(curr, home);
        }
        else{
            if(t==0){
                memo.put(""+curr.x+","+curr.y+","+t+","+n,distance(home, curr) + findMinCost(home,2,n));
                return memo.get(""+curr.x+","+curr.y+","+t+","+n);
            }
            else{
                int min =Integer.MAX_VALUE;
                if(!(curr.x==0&&curr.y==0)){
                    min= distance(home,curr)+ findMinCost(home,2,n);
                }
                for (int i=0; i<points.length;i++){
                    if(points[i].x==100) continue;
                    int x= points[i].x;
                    int y =points[i].y;
                    points[i].x=100;
                    points[i].y=100;
                    min = Math.min(min,distance(new Point(x,y),curr)+ findMinCost(new Point(x,y),t-1,n-1));
                    if(t==2) min= Math.min(min,2*distance(home,new Point(x,y))+findMinCost(home,2,n-1));
                    points[i].x=x;
                    points[i].y=y;
                }
                if(min==Integer.MAX_VALUE) return 0;
                memo.put(""+curr.x+","+curr.y+","+t+","+n,min);
                return memo.get(""+curr.x+","+curr.y+","+t+","+n);
            }
        }
    }
    */

    public static int distance(Point a , Point b){
        return (a.x-b.x)*(a.x-b.x) +(a.y-b.y)*(a.y-b.y);
    }
}

/*
}
    public static Point[] points=null;
    public static Point home = new Point(0,0);
    public static void main(String[] args) {
        */
/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. *//*

        Scanner sc = new Scanner (System.in);
        int n= sc.nextInt();
        points= new Point[n];
//        ArrayList<Point> points = new ArrayList<Point>();
        for (int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x,y);
//            points.add(new Point(x,y));
        }

//        System.out.println(findMinCost(points,2,home));
         System.out.println(findMinCost(home,2,n));
    }

    public static int findMinCost(ArrayList<Point> points,int credits, Point currPoint){
        if(points.size()==0){
            if(currPoint.x==0&&currPoint.y==0) return 0;
            return distance(home,currPoint);
        }
        else{
            int min = Integer.MAX_VALUE;
            if (credits==0) return distance(home,currPoint)+ findMinCost(points,2,home);
            for (int i = 0; i < points.size(); i++) {
                ArrayList<Point> rem = new ArrayList<>(points);
                Point p = rem.get(i);
                rem.remove(i);
                min= Math.min(min,distance(p,currPoint)+findMinCost(rem,credits-1,p));
                if(credits==2) min= Math.min(min,2*distance(home,p)+findMinCost(rem,2,home));
            }
            return min;
        }
    }

    public static int findMinCost(Point curr, int t, int n){
        if(n==0){
            if(curr.x==0&&curr.y==0) return 0;
            else return distance(curr, home);
        }
        else{
            if(t==0){
                return distance(home, curr) + findMinCost(home,2,n);
            }
            else{
                int min =Integer.MAX_VALUE;
                if(!(curr.x==0&&curr.y==0)){
                    min= distance(home,curr)+ findMinCost(home,2,n);
                }
                for (int i=0; i<points.length;i++){
                    if(points[i].x==100) continue;
                    int x= points[i].x;
                    int y =points[i].y;
                    points[i].x=100;
                    points[i].y=100;
                    min = Math.min(min,distance(new Point(x,y),curr)+ findMinCost(new Point(x,y),t-1,n-1));
                    if(t==2) min= Math.min(min,2*distance(home,new Point(x,y))+findMinCost(home,2,n-1));
                    points[i].x=x;
                    points[i].y=y;
                }
                if(min==Integer.MAX_VALUE) return 0;
                return min;
            }
        }
    }

    public static int distance(Point a , Point b){
        return (a.x-b.x)*(a.x-b.x) +(a.y-b.y)*(a.y-b.y);
    }
}*/
