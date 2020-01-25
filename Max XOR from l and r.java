/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    public static int MaxXOR(int l,int r)
    {
        int s = l ^ r;
        int p = 1;
        while(s>0)
        {
            p=p<<1;
            s=s>>1;
        }
        return p-1;
    }
	public static void main (String[] args) {
		int l=10,r = 3;
		System.out.println(MaxXOR(l,r));
	}
}