/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		String str = "dabcdefghbcdebc";
		String pat = "bcd";
		int c = 0;
		int j = 0;
		int t = str.length();
		int p = pat.length();
		int cnt = 0;
		for(int i=0;i<t;i++)
		{
		    if(str.charAt(i) == pat.charAt(j))
		    {
		        
		        j++;
		        if(j==p)
		        {
		            cnt++;    
		            j=0;
		        }
		    }
		    else
		        j=0;
		}
		System.out.println(cnt);
	}
}