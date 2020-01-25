/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class MyDS
{
    ArrayList<Integer> alist;
    HashMap<Integer,Integer> map;
    
    MyDS()
    {
        alist = new ArrayList<>();
        map = new HashMap<>();
    }
    public void insert(int x)
    {
        if(map.get(x)!=null)
            return;
        int size = alist.size();
        alist.add(x);
        map.put(x,size);
    }
    public int search(int x)
    {
        if(map.get(x)==null)
            return -1;
        else
            return map.get(x);
    }
    public int getRandom()
    {
        
        Random rnd = new Random();
        int index = rnd.nextInt(alist.size());
        return alist.get(index);
    }
    public void remove(int x)
    {
        Integer index = map.get(x);
        if(index==null)
        {
            System.out.println("Could not find " + x );
            return;
        }
        map.remove(x);
        int size = alist.size();
        int last = alist.get(size-1);
        Collections.swap(alist,index,size-1);
        alist.remove(size-1);
        map.put(last,index);
    }
    public void print()
    {
        for(int i:alist)
            System.out.print(i+" ");
    }
}
class GFG {
	public static void main (String[] args) {
		MyDS d = new MyDS();
		d.insert(10);
		d.insert(20);
		d.insert(30);
		d.insert(40);
		d.insert(50);
		d.print();
		System.out.println();
		System.out.println(d.getRandom());
		System.out.println(d.getRandom());
		System.out.println(d.getRandom());
		d.insert(60);
		d.insert(70);
		d.print();
		System.out.println();
		System.out.println(d.search(50));
		System.out.println(d.search(100));
		System.out.println();
		d.remove(100);
		d.remove(40);
		d.remove(10);
		d.print();
	}
}