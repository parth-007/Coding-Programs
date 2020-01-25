/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		
	    int n=63;
	    StringBuilder sb = new StringBuilder();
	    int r = 0;
	    while(n>0)
	    {
	        r = n % 16;
	        if(r>9)
	        {
	            r = r - 10;
	            sb.append((char)(r+'A'));
	        }
	        else    
	            sb.append(r);
	        n = n / 16;
	    }
	    System.out.println(sb.reverse().toString());
		  
	}
}