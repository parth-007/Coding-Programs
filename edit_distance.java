import java.io.*;
import java.util.*;
class GFG {
    public static int edit(String first,String second)
    {
        int m = first.length();
        int n = second.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0)
                    dp[i][j] = j;
                else if(j==0)
                    dp[i][j] = i;
                else if(first.charAt(i-1)==second.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],//Replace
                                   Math.min(dp[i][j-1], //Insert
                                   dp[i][j-1])); //Delete
            }
        }
        return dp[m][n];
    }
	public static void main (String[] args) {
		Scanner sc =  new Scanner(System.in);
		LinkedHashSet<String> set = new LinkedHashSet<>();
		//you can use arraylist too. like ArrayList<String> alist = new ArrayList<>();
		while(true)
		{
		    String s = sc.nextLine();
		    if(s.equalsIgnoreCase("END"))
		        break;
		    set.add(s);
		}
		String[] s1 = sc.nextLine().trim().split("\\s+");
		String first = s1[0];
		String second = s1[1];
        System.out.println(edit(first,second));
	}
}