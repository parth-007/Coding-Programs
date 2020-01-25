/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void Find(int[] arr,int n)
    {
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i] <=0 )
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j++] = temp;
            }
        }
        
        for(int k=j;k<n;k++)
        {
            int index = j + Math.abs(arr[k]) - 1;
            if(index<n && arr[index] > 0)
                arr[index] = -arr[index];
        }
        boolean found = false;
        int l;
        for(l=j;l<n;l++)
        {
            if(arr[l]>0)
            {
                found=true;
                System.out.println(l-j+1);
                break;
            }
        }
        if(!found)
            System.out.println(l+1);
    }
	public static void main (String[] args) {
		int[] arr = {1,2,3,-3,5,6};
		int n = arr.length;
		Find(arr,n);
	}
}