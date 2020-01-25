/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void printSum(int[][] matrix,int n)
    {
        int[][] ans1 = new int[n][n];
        int[][] ans2 = new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    ans1[i][j] = matrix[0][0];
                    ans2[i][j] = matrix[0][0];
                }
                else
                {
                    if(j<=i)
                        ans1[i][j] = Integer.MAX_VALUE;
                    else if(i==0 && j!=0)
                        ans1[i][j] = ans1[i][j-1] + matrix[i][j];
                    else if(i!=j)
                        ans1[i][j] = Math.min(ans1[i-1][j],ans1[i][j-1]) + matrix[i][j];
                        
                    
                    if(j>=i)
                        ans2[i][j] = Integer.MAX_VALUE;
                    else if(j==0 && i!=0)
                        ans2[i][j] = ans2[i-1][j] + matrix[i][j];
                    else if(i!=j)
                        ans2[i][j] = Math.min(ans2[i-1][j],ans2[i][j-1]) + matrix[i][j];
                }
            }
        }
        System.out.println(matrix[n-1][n-1] + ans1[n-2][n-1] + ans2[n-1][n-2]);
    }
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];
// 		int[][] matrix = {
// 		    {5,11,4,6},{3,2,10,3},{1,3,1,3},{4,2,8,8}
// 		};
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<n;j++)
		    {
		        matrix[i][j] = sc.nextInt();
		    }
		}
		printSum(matrix,n);
	}
}