package hackercup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by amit on 1/6/17.
 */
public class prob1 {

    public static void main(String[] args) throws FileNotFoundException {
        String fileLocation ="";
        File inputFile= new File("C:\\Users\\raula\\Downloads\\progress_pie.txt");
        File outputFile = new File("C:\\Users\\raula\\Downloads\\hackercup\\prob1.txt");
        PrintWriter pw = new PrintWriter(outputFile);
        Scanner sc = new Scanner(inputFile);
        int t = sc .nextInt();
        for (int i=0; i< t; i++){
            int p = sc.nextInt();
            double theta= (double) (p*0.02*Math.PI);
            int x = sc.nextInt();
            int y = sc.nextInt();
            String color= "white";
            if (inSector(x,y, theta)) color ="black";
            pw.println("Case #"+ (i+1) + ": " + color);
        }
        pw.close();
    }

    private static boolean inSector(int x, int y, double theta) {
        int distance= x*x+ y*y;
        if (distance>10000) return false;
        double angle =Math.atan2(y-50,x-50);
        if (angle<0) angle+=2*Math.PI;
        if (round(angle,6)>round(theta,6)) return false;
        return true;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}