/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    static class Pair{
        int freq;
        char ch;
        public Pair(int freq,char c)
        {
            this.freq = freq;
            ch = c;
        }
    }
	public static void main (String[] args) {
	    String str="abbc";
	    int k = 2;
// 	    String str = "aaaabbbbba";
// 		int k = 2;
		Stack<Pair> stack = new Stack<Pair>();
		char[] c = str.toCharArray();
		if(k==1)
		{
		 System.out.println("");
		}
		else
		{
		for(int i=0;i<c.length;i++)
		{
		    if(!stack.empty())
		    {
    		    Pair p = stack.peek();
    		    
    		    if(c[i] == p.ch)
    		    {
    		        stack.push(new Pair(p.freq+1,p.ch));
    		        if(!stack.empty() && k==stack.peek().freq)
    		        {
    		            while(!stack.empty() && stack.peek().ch == c[i])
    		                stack.pop();
    		        }
    		      
    		    }
    		    else
    		    {
    		        stack.push(new Pair(1,c[i]));
    		    }
    		    
		    }
		    else
		    {
		    stack.push(new Pair(1,c[i]));
		    }
		}
		StringBuilder sb =  new StringBuilder();
		while(!stack.empty())
		{
		    sb.append(stack.pop().ch+" ");
		}
		System.out.println(sb.reverse().toString());
		}
	}
}