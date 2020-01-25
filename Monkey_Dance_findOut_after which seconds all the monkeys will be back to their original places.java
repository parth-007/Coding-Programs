import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    //you may add more methods here
    public static int gcd(int a,int b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    
    public static int lcm(ArrayList<Integer> lcmar) 
    { 
        int ans=lcmar.get(0);
      
        for(int i=1;i<lcmar.size();i++)
        {
            ans=(ans*lcmar.get(i).intValue())/gcd(ans,lcmar.get(i).intValue());
        }
        return ans;
    }
    
    public static int danceTime(int N, int[] P) {
        
        ArrayList<Integer> ar=new ArrayList<Integer>();
        ArrayList<Integer> lc=new ArrayList<Integer>();
        int pos, cnt, num, num1, max=0;
        
        //System.out.println(P[pos]);
        for(int i=0;i<P.length;i++)
        {
            cnt=1;
            if(ar.contains(P[i]))
                continue;
            else
            {
                num=P[i];
                num1=P[num-1];
                ar.add(num);
            }
            
            while(num!=num1)
            {
                ar.add(num1);
                num1=P[num1-1];
                cnt++;
            }
            
            lc.add(cnt);
        }
        //int[] lcmar=new int[lc.size()];
        //lcmar=ar.toArray(lcmar);
        
        
        return lcm(lc);


    }
    
    public static void main(String args[]) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        
        for(int i=0;i<cases;i++){
            int monkeys = Integer.parseInt(br.readLine());
            String temp[] = br.readLine().split(" ");
            int initPosition[] = new int[temp.length];
            
            for(int j=0;j<temp.length;j++)
                initPosition[j] = Integer.parseInt(temp[j]);
            
            int answer = danceTime(monkeys, initPosition);
            
            System.out.println(answer);
        }
    }
}