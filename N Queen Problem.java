/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    public static int N = 5;
    public static boolean solveNqueen(int[][] arr,int col)
    {
        if(col>=N)
            return true;
        for(int i=0;i<N;i++)
        {
            if(isSafe(arr,i,col))
            {
                arr[i][col] = 1;
                if(solveNqueen(arr,col+1))
                    return true;
                
                arr[i][col] = 0;
            }
        }
        return false;
        
    }
    public static boolean isSafe(int[][] arr,int row,int col)
    {
        int i,j;
        for(i=row,j=col;i>=0 && j>=0;i--,j--) if(arr[i][j]==1) return false;
        for(i=row,j=col;j>=0;j--) if(arr[i][j]==1) return false;
        for(i=row,j=col;i<N && j>=0;i++,j--) if(arr[i][j]==1) return false;
        return true;
    }
	public static void main(String[] args) {
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++)
		{
		    for(int j=0;j<N;j++)
		    {
		        arr[i][j] = 0;
		    }
		}
		
		if(solveNqueen(arr,0)==true) //column is zero
		{
		for(int i=0;i<N;i++)
		{
		    for(int j=0;j<N;j++)
		    {
		        System.out.print(arr[i][j]+" ");
		    }
		    System.out.println();
		}
		}
		
	}
}
