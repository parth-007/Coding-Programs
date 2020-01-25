/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Point
{
    int x,y;
    Point(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class GFG {
    
	public static void main (String[] args) {
		int[] x = {1,3,9};
		int[] y = {1,6,8};
		int n = x.length;
		ArrayList<Point> list = new ArrayList<>();
		for(int i=0;i<n;i++)
		    list.add(new Point(x[i],y[i]));
		Collections.sort(list,new Comparator<Point>(){
		    public int compare(Point p,Point q)
                {
                    if(p.x > q.x) return 1;
                    else if(p.x < q.x)return -1;
                    else return 0;
                }
		});
		int minx = Integer.MAX_VALUE;
		int diffx = 0;
		long ans1 = 0;
	    for(int i=0;i<list.size()-1;i++)
	    {
	       Point p = list.get(i);
	       Point q = list.get(i+1);
	       diffx = q.x - p.x;
	       if(diffx < minx)
	       {
	           minx = diffx;
	           ans1 = (long)(Math.pow(q.x-p.x,2) + Math.pow(q.y-p.y,2));
	       }
	    }
	    
		Collections.sort(list,new Comparator<Point>(){
		    public int compare(Point p,Point q)
                {
                    if(p.y > q.y) return 1;
                    else if(p.y < q.y)return -1;
                    else return 0;
                }
		});
		int miny = Integer.MAX_VALUE;
		int diffy = 0;
		long ans2 = 0;
		for(int i=0;i<list.size()-1;i++)
	    {
	       Point p = list.get(i);
	       Point q = list.get(i+1);
	       diffy = q.y - p.y;
	       if(diffy < miny)
	       {
	           miny = diffy;
	           ans2 = (long)(Math.pow(q.x-p.x,2) + Math.pow(q.y-p.y,2));
	       }   
	    }
	    System.out.println(Math.min(ans1,ans2));
	
	}
}