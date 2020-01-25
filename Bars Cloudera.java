/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static int count(int m,int n,int[] hor,int[] ver)
    {
        if(hor.length==m && ver.length==n)
            return m*n;
        if(hor.length==0 && ver.length==0)
            return 1;
        
        int hc = 1;
        int vc = 1;
        int count = 1;
        Arrays.sort(hor);
        Arrays.sort(ver);
        for(int i=1;i<hor.length;i++)
        {
            if(hor[i] == hor[i-1] + 1)
                count++;
            else
            {
                hc = Math.max(hc,count);
                count = 1;
            }
        }
        hc = Math.max(hc,count);
        count = 1;
        for(int i=1;i<ver.length;i++)
        {
            if(ver[i] == ver[i-1] + 1)
                count++;
            else
            {
                vc = Math.max(vc,count);
                count = 1;
            }
        }
        vc = Math.max(vc,count);
        if(hor.length==0)
            return vc+1;
        if(ver.length==0)
            return hc+1;
        return (hc+1) * (vc+1);
    }
	public static void main (String[] args) {
		int m = 3;
		int n = 3;
		int[] hor = {1,2,3};
		int[] ver = {1,2,3};
		System.out.println(count(m,n,hor,ver));
	}
}