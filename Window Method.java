/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static int sum(int[] arr,int n,int k)
    {
        int mysum = 0;
        for(int i=0;i<k;i++)
            mysum+=arr[i];
            
            int window_sum = 0;
            int maxsum = 0;
            window_sum = mysum;
        for(int i=k;i<n;i++)
        {
            window_sum = window_sum + arr[i] - arr[i-k];
            maxsum = Math.max(maxsum,window_sum);
        }
        return maxsum;
    }
	public static void main (String[] args) {
		int arr[] = {1,4,2,10,2,3,1,0,20};
		int K = 4;
		
		System.out.println("Maximum Sum possible with 4 Elements:" + sum(arr,arr.length,K));
	}
}