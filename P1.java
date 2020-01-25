/*package whatever //do not write package name here */
// Number of ways to choose elements from the array such that their average is K
// https://www.geeksforgeeks.org/number-of-ways-to-choose-elements-from-the-array-such-that-their-average-is-k/

import java.io.*;
import java.util.*;

class GFG {
    public static final int MAX_INDEX = 51;
    public static final int MAX_SUM = 2505;
    public static int[][][] dp = new int[MAX_INDEX][MAX_SUM][MAX_INDEX];
    public static int no_of_ways(int sum,int count,int k,int index,List<Integer> alist)
    {
        if(index < 0)
            return 0;
        if(index == 0)
        {
            if(count == 0)
                return 0;
            int rem = sum % count;
            if(rem != 0)
                return 0;
            int avg = sum / count;
            if(avg == k)
                return 1;
        }
        if(dp[index][sum][count] != -1)
            return dp[index][sum][count];
        int dontpick = no_of_ways(sum,count,k,index-1,alist);
        int pick = no_of_ways(sum+alist.get(index),count+1,k,index-1,alist);
        int total = dontpick + pick;
        dp[index][sum][count] = total;
        return total;
        
    }
    public static int initialize(int[] arr,int len,int k)
    {
        ArrayList<Integer> alist = new ArrayList<>();
        alist.add(-1);
        for(int i=0;i<len;i++)
            alist.add(arr[i]);
        // Arrays.fill(dp,-1);
        for(int i=0;i<MAX_INDEX;i++)
        {
            for(int j=0;j<MAX_SUM;j++)
            {
                for(int g=0;g<MAX_INDEX;g++)
                    dp[i][j][g] = -1;
            }
        }
        int answer = no_of_ways(0,0,k,len,alist);
        return answer;
    }
	public static void main (String[] args) {
		int[] arr = {6,7,3,6,2,8,5,9};
		int len = arr.length;
		int k = 5;
		System.out.println(initialize(arr,len,k));
	}
}