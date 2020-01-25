/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    public static int N = 5;
    public static void Print(int[][] arr)
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
    public static boolean isSafe(int[][] arr,int x,int y)
    {
        return (x>=0 && y>=0 && x<N && y<N && arr[x][y]==0);
    }
    public static void Solve(int[][] arr,int x,int y)
    {
        // arr[0][0] = 5;
       if(UtilHelper(arr,0,0)==false)
       {
           System.out.println("Rat can't reach to the destination.");
           return;
       }
       System.out.println("Rat in the Maze Solved");
       Print(arr);
    }
    public static boolean UtilHelper(int[][] arr,int x,int y)
    {
        if(x==N-1 && y==N-1){
            arr[N-1][N-1] = 5;
            return true;
        }
        // arr[0][0] = 5;
        
        if(isSafe(arr,x,y) == true){
            arr[x][y] = 5;
            
            
            if(UtilHelper(arr,x+1,y))
                return true;
            
            if(UtilHelper(arr,x,y+1))
                return true;
            
            arr[x][y] = 0;
            
            // return false;
        }
        
        
        return false;
    }
	public static void main(String[] args) {
	    // 0 for Blank
	    // 1 for Obstraction
	    // 5 for Answer of Path
		int[][]arr = new int[N][N];
		for(int i=0;i<N;i++)
		{
		    for(int j=0;j<N;j++)
		    {
		        arr[i][j] = 0;
		    } 
		}
		arr[0][1]=arr[1][1]=arr[2][3]=arr[2][4]=arr[3][3]=arr[3][0]=arr[4][1]=arr[0][2]=arr[1][2] = 1;
		
		Solve(arr,0,0);
	}
}
