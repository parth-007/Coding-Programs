/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		String str = "dabcdefghbcdebc";
		String pat = "bcd";
		int c = 0;
		int t = str.length();
		int p = pat.length();
		int cnt = 0;
		for(int i=0;i<=t-p;i++)
		{
		    cnt = 0;
		    for(int j=0;j<p;j++)
		    {
		        if(str.charAt(i+j)!=pat.charAt(j))
		            break;
		        else    
		            cnt++;
		    }
		    if(cnt==p)
		        c++;
		}
		System.out.println(c);
	}
}