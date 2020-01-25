//This program will find the number of unique BST from given number of nodes.

import java.io.*;

class GFG {
    public static int printBST(int n)
    {
        int[] dp = new int[n+2];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                dp[i] = dp[i] + (dp[i-j] * dp[j-1]);
            }
        }
        
        /*2nd approach
        for(int i=2;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                dp[i] = dp[i] + (dp[j] * dp[i-j-1]);
            }
        }
        */
        return dp[n];
    }
	public static void main (String[] args) {
		int n = 4;
	    System.out.println(printBST(n));
	}
}