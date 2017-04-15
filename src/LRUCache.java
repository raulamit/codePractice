import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by raula on 3/7/2017.
 */
public class LRUCache {
    LinkedList<DoublyNode> values;
    private long maxSize=0;
    private long size=0;
    private HashMap<Integer,DoublyNode> mp;
    private DoublyNode head;
    private DoublyNode tail;

    public static void main(String[] args) {
/*        LRUCache l = new LRUCache(2);
        l.put(1,1);
        l.put(2,2);
        System.out.println(l.get(1));
        l.put(3,3);
        System.out.println(l.get(2));
        l.put(4,4);
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
        System.out.println("a");*/
        LRUCache l = new LRUCache(3);
        l.put(1,1);
        l.put(2,2);
        l.put(3,3);
        l.put(4,4);
        l.get(4);
        l.get(3);
        l.get(2);
        l.get(1);
        l.put(5,5);
        l.get(1);
        l.get(2);
        l.get(3);
        l.get(4);
        l.get(5);
    }
    public LRUCache(int capacity) {
        maxSize=capacity;
        this.values= new LinkedList<>();
        this.mp= new HashMap<>();
    }

    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        DoublyNode node = mp.get(key);
        delete(key);
        put(key,node.data);
        return node.data;
    }

    public void put(int key, int value) {
        if(mp.containsKey(key)) delete(key);
        if(size>=maxSize){
             delete();
        }
        if(size==0){
            DoublyNode node= new DoublyNode();
            node.data=value;
            node.key=key;
            head=node;
            tail=node;
            mp.put(key,node);
            size++;
        }else{
            DoublyNode node= new DoublyNode();
            node.data=value;
            node.key=key;
            mp.put(key,node);
            node.next=head;
            head.prev=node;
            head=node;
            if(size==1){
                tail.prev=head;
            }
            size++;

        }
    }

    private void delete(int key) {
        size--;
        DoublyNode node = mp.get(key);
        mp.remove(key);
        if(size==0){
            head=null;
            tail=null;
        }
        else if(node.equals(head)){
            head= head.next;
            head.prev=null;
            if(head.equals(tail)) {
                head.prev=null;
                tail.next=null;
            }
        }
        else if(node.equals(tail)) {
            tail= tail.prev;
            tail.next=null;
            if(head.equals(tail)) {
                head.prev=null;
                head.next=null;
            }
        }else {
            DoublyNode next = node.next;
            DoublyNode prev = node.prev;
            if (next != null) {
//                next.next = node.next;
                next.prev=node.prev;
            }
            if (prev != null) {
//                prev.prev = node.prev;
                prev.next=node.next;
            }
        }
    }

    public void delete(){
        size--;
        int key = tail.key;
        mp.remove(key);
        if(size==0) {
            head = null;
            tail=null;
        }
        else if(size==1) {
            head.next=null;
            tail=head;
        }
        else if(tail.prev!=null){
            tail= tail.prev;
            tail.next=null;
        }else{
            tail=null;
        }
    }
}

class DoublyNode{
    int data;
    int key;
    DoublyNode next;
    DoublyNode prev;
}
