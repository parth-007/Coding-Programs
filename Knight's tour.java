/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    public static int N = 8;
    static void printSolution(int[][] arr)
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.printf("%3d ",arr[i][j]);
            }
            System.out.println();
        }
    }
    static boolean isSafe(int[][] arr,int x,int y)
    {
        return (x>=0 && x<N && y>=0 && y<N && arr[x][y] == -1);
    }
    static boolean SolveKnightTour(int[][]arr)
    {
        int x1[] = {1,2,2,1,-1,-2,-2,-1};
        int y1[] = {2,1,-1,-2,-2,-1,1,2};
        
        arr[0][0] = 0;
        
        if(!SolveUtility(arr,0,0,1,x1,y1)){
            System.out.println("Solution does not exist");
            return false;
        }
        else{
            System.out.println("Knight's Tour Completed...");
        printSolution(arr);
        }
        return true;
    }
    static boolean SolveUtility(int[][] arr,int xStart,int yStart,int index,int[] x1,int[] y1)
    {
        int k,nextX,nextY;
        if(index == N*N)
        {
            arr[xStart][yStart] = index;
            return true;
        }
            
        
        for(k=0;k<N;k++)
        {
            nextX = x1[k] + xStart;
            nextY = y1[k] + yStart;
            
            if(isSafe(arr,nextX,nextY)){
                arr[nextX][nextY] = index;
                
                if(SolveUtility(arr,nextX,nextY,index+1,x1,y1))
                    return true;
                    
                else
                     arr[nextX][nextY] = -1;
            }
            
        }
        return false;
    }
	public static void main (String[] args) {
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++)
	        for(int j=0;j<N;j++)
	            arr[i][j] = -1;
		SolveKnightTour(arr);
		
	}
}