/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    static String s;
	public static void main (String[] args) {
		s = "Mangukiya Parth A.";
		Reverse(s);
	}
	static void Reverse(String s)
	{
	    char[] ch = s.toCharArray();
	    int n = ch.length;
	    int j = n-1;
	    for(int i=0;i<n/2;i++)
	    {
	        char c = ch[i];
	        ch[i] = ch[j];
	        ch[j] = c;
	        j--;
	    }
	    s = new String(ch);
	    System.out.println(s);
	}
}