/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		int[] arr = {1,2,3,4,5};
		//output should be {120,60,40,30,24}
		//Constraints: Don't use / operator
		//2. Time Complexity : O(N)
		int[] prefix = new int[arr.length];
		int[] suffix = new int[arr.length];
		
		prefix[0] = 1;
		suffix[suffix.length - 1] = 1;
		suffix[0] = 120;
		
		for(int i=1;i<5;i++)
		    prefix[i] = i * prefix[i-1];
		
		for(int i=3;i>=1;i--)
		    suffix[i] = (i+2) * suffix[i+1];
		    
        for(int i=0;i<5;i++)
            System.out.print(prefix[i] * suffix[i]+" ");
	}
}