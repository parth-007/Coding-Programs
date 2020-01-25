import java.util.*;
public class HelloWorld{

    public static int minimum(int l,int r,int[][] dp,String str){
        if(l > r)
            return 0;
        if(l == r)
            return 1;
        if(dp[l][r] != -1)
            return dp[l][r];
        //one character delete
        
        int result = 1 + minimum(l+1,r,dp,str);
        
        //consecutive element deleted
        for(int i=l+1;i<=r;i++)
        {
            if(str.charAt(i) == str.charAt(l))
            result = Math.min(result, minimum(l+1,i-1,dp,str) + minimum(i,r,dp,str) ); 
        }
        return dp[l][r] = result;
    }
    
     public static void main(String []args){
        String str = "abcddcba";
        int n = str.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j] = -1;
            }
        }
        int total = minimum(0,n-1,dp,str);
        System.out.println(total);
     }
}