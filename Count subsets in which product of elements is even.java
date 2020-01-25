/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void find(int[] arr,int n)
    {
        int odd=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]%2==1)
                odd++;
        }
        int res = (int)(Math.pow(2,n) - 1);
        int r1 = (int)(Math.pow(2,odd) - 1);
        System.out.println(res - r1);
    }
	public static void main (String[] args) {
		int a[] = {2, 2, 3}; 
        int n = a.length; 
  
// function calling  
        find(a, n); 
	}
}