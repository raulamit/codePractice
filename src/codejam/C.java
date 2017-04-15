package codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by raula on 4/7/2017.
 */
public class C {
    public static void main(String[] args) throws FileNotFoundException {
        String small = "C-small-2-attempt0";
        String large = "C-large";
        File in = new File("C:\\Users\\raula\\Downloads\\" + large + ".in");
        Scanner sc = new Scanner(new FileInputStream(in));
        File out = new File("C:\\Users\\raula\\Downloads\\" + large + ".out");
        PrintWriter pw = new PrintWriter(out);
        long t = sc.nextInt();
        sc.nextLine();

        for (long i = 1; i <= t; i++) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    int cmp = o2.s.compareTo(o1.s);
                    if (cmp != 0) return cmp;
                    else {
                        return o1.i.compareTo(o2.i);
                    }
                }
            });
            System.out.println(i);
            Node res= stalls(q,n,k);
            long min = Math.min(res.ls,res.rs);
            long max= Math.max(res.ls,res.rs);
            pw.println("Case #" + i + ": "+ max +" "+ min);
        }
        pw.close();
    }

    public static Node stalls(PriorityQueue<Node> q, long n, long k) {
        Node curr= new Node(n,n/2);
        k--;
        while (k>0){
            long l = (curr.s-1)/2;
            long r = curr.s/2;
            long li= curr.i - l;
            long ri= curr.i + r+1;
            Node ls = new Node(l,li);
            Node rs = new Node(r,ri);
            q.add(ls);
            q.add(rs);
            curr= q.poll();
            k--;
        }
        long l = (curr.s-1)/2;
        long r = curr.s/2;
        curr.ls=l;
        curr.rs=r;
        return curr;
    }

}

class Node{
    Long s;
    Long i;
    long ls;
    long rs;
    public Node(long s, long i){
        this.s=s;
        this.i=i;
    }

}
