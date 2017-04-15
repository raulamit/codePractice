package ctci.recursionDP;

import java.util.Random;

/**
 * Created by raula on 3/4/2017.
 */
public class StackOfBoxes {
    public static void main(String[] args) {
    	Box[] bs= new Box[5];
    	Random rd = new Random();
    	for (int i=0; i<bs.length;i++){
    		bs[i]= new Box(2+ i+ rd.nextInt(3*(i+1)),
                    3 +i+ rd.nextInt(3*(i+1)),
                    1+i+ rd.nextInt(3*(i+1)));
    	}

    	System.out.println(getMaxHeight(bs,bs.length,new Box(0,0,0)));
    }


    private static int getMaxHeight(Box[] bs, int n,Box box){
    	if (n<=0) return 0;
    	else{
    		int max=0;
    		for (int i=0; i< bs.length ; i++){
    			if(bs[i]!=null){
    				Box temp = bs[i];
    				bs[i]=null;
    				if(box.h<temp.h&&box.w<temp.w&&box.d<temp.d){
    					max= Math.max(temp.h+max,temp.h+getMaxHeight(bs,n,temp));
    				}
    				bs[i]=temp;
    			}
    		}
    		return max;
    	}
    }




}
    class Box{
    	int w;
    	int h;
    	int d;
    	public Box(){}

    	public Box(int w, int h, int d){
    		this.w=w;
    		this.h=h;
    		this.d=d;
    	}
    }
