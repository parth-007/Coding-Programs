/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    public static boolean isPrime(int n)
    {
        if(n<=1)return false;
        if(n<=3) return true;
        if(n%2==0 || n%3==0)return false;
        for(int i=5;i*i<=n;i=i+6)
        {
            if((n%i)==0 && (n%(i+2))==0)
                return false;
        }
        return true;
    }
    public static int count(int l,int r)
    {
        int set = 0;
        int result = 0;
        
        for(int i=l;i<=r;i++)
        {
            set = count_set_bits(i);
            if(isPrime(set))
            {
                result++;
            }
        }
        return result;
    }
    public static int count_set_bits(int i)
    {
        int cnt = 0;
        while(i>0)
        {
            i = i & i-1;
            cnt++;
        }
        return cnt;
    }
	public static void main (String[] args) {
		//Prime number of Set bits in binary representation.
		int l = 6;
		int r = 10;
		System.out.println(count(l,r));
	}
}