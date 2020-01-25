/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    static void printLargest(ArrayList<String> alist)
    {
        Collections.sort(alist,new Comparator<String>(){
           public int compare(String X,String Y) 
           {
               String XY = X + Y;
               String YX = Y + X;
               return XY.compareTo(YX) > 0 ? -1 : 1;
           }
        });
        for(String s:alist)
            System.out.print(s+".");
    }
	public static void main (String[] args) {
	    ArrayList<String> alist = new ArrayList<>();
	    alist.add("68234324");
	    alist.add("81010122");
	    alist.add("122432984923482394");
	    alist.add("7171725");
	    alist.add("22541");
	    alist.add("9");
	    printLargest(alist);
	}
}