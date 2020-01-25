
import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
    public static void Print1(int[][] arr,int M,int N)
     {
          for(int i=0;i<M;i++)
	        {
	        for(int j=0;j<N;j++)
	        {
	            System.out.print(arr[i][j]+" ");
	        }
	        System.out.println();
	    }
     }
     
    static void print (int arr[][], int M, int N)
    {
        int k=0,l=0;
        int last_row = M;
         int last_col = N;
         
         int i,j;
         int esum = 0;
         while(k<last_row && l<last_col)
         {
             //1st block
             System.out.print("Sum:" + arr[k][l]+" ");
             esum += arr[k][l]; //[0][0]
             
            for(i=l;i<last_col;i++)             
            {
                System.out.print(arr[k][i]+" ");
            }
            
            System.out.print("Sum:" + arr[k][last_col-1]+" ");
            esum+=arr[k][last_col-1]; //[last_col]
            
            k++;
            for(i=k;i<last_row;i++)
            {
                System.out.print(arr[i][last_col - 1]+" ");
            }
            System.out.print("Sum:" + arr[last_row-1][last_col-1]+" ");
            esum+=arr[last_row-1][last_col-1];
            
            last_col--;
            if(k<last_row)
            {
                for(i=last_col - 1;i>=l;i--)
                    System.out.print(arr[last_row - 1][i]+" ");
                    
                last_row--;
            }
            System.out.print("Sum:" + arr[last_row][l]+" ");
            esum+=arr[last_row][l];
            if(l<last_col)
            {
                for(i=last_row - 1;i>=k;i--)
                    System.out.print(arr[i][l]+" ");
            l++;    
            }
            
         }
         System.out.println("ans:" + esum);
    }
	public static void main (String[] args)
	{
	    Scanner s = new Scanner(System.in);
	    
	        int m = 5;
	        int n = 5;
	        int arr[][] = new int[m][n];
	        int k = 1;
	        for(int i=0;i<m;i++)
	        for(int j=0;j<n;j++)
	        arr[i][j]= k++;
	        print(arr,m,n);
	        System.out.println();
	    
	
	}
}