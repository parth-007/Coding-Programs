import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     public static void print(int[][] grid,int n)
     {
        for(int i=0;i<n;i++) 
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
            
        }
     }  
     public static boolean isSafe(int[][] grid,int row,int col,int num)
     {
         for(int d=0;d<grid.length;d++)
         {
             if(grid[row][d] == num)
                return false;
         }
         for(int r=0;r<grid.length;r++)
         {
             if(grid[r][col] == num)
                return false;
         }
         int sqrt = (int) Math.sqrt(grid.length);
         int brstart = row - row % sqrt;
         int bcstart = col - col % sqrt;
         for(int r=brstart;r<brstart+sqrt;r++)
         {
             for(int d=bcstart;d<bcstart+sqrt;d++)
             {
                 if(grid[r][d]==num)
                    return false;
             }
         }
         return true;
     }
     public static boolean solveSudoku(int[][] grid,int n)
     {
         int row = -1;
         int col = -1;
         boolean isEmpty = true;
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n;j++)
             {
                 if(grid[i][j] == 0)
                 {
                     row = i;
                     col = j;
                     isEmpty = false;
                     break;
                 }
             }
             if(!isEmpty)
                break;
         }
         if(isEmpty)
            return true;
         for(int num=1;num<=9;num++)
         {
             if(isSafe(grid,row,col,num))
             {
                 grid[row][col] = num;
                 if(solveSudoku(grid,n))
                 {
                    return true;
                 }
                 else
                 {
                     grid[row][col] = 0;
                 }
             }
         }
         return false;
     }
     
	public static void main (String[] args) throws Exception
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0)
	    {
	        int[][] grid = new int[9][9];
	        for(int i=0;i<9;i++)
	        {
	            for(int j=0;j<9;j++)
	            {
	                grid[i][j] = sc.nextInt();
	            }
	        }
	        int n = grid.length;
	        if(solveSudoku(grid,n))
	        {
	            print(grid,n);
	        }
	        System.out.println();	        
	    }
        
	 }
}