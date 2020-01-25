/*package whatever //do not write package name here */


//Every number can be described in powers of 2. For example, 29 = 2^0 + 2^2 + 2^3 + 2^4. Given an int n, return minimum number of additions and subtractions of 2^i to get n.
import java.io.*;

class GFG {
	public static void main (String[] args) {
		int n = 8;
		int[] dp = new int[n+1];
		dp[0] = 0;
		int pow = 1;
		for(int i=1;i<=n;i++)
		{
		    if(i==pow)
		    {
		        dp[i] = 1;
		        pow*=2;
		        System.out.println(dp[i]+" ");
		        continue;
		    }
		    dp[i] = 1 + Math.min(dp[i-pow/2],dp[pow-i]);
		    System.out.println(dp[i]+" ");
		}
		
	}
}