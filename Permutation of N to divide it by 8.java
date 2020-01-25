import java.io.*;
import java.util.*;
public class MyClass {
    public static boolean check(String s,int l)
    {
        if(l < 3)
        {
            if(Integer.parseInt(s) % 8 ==0)
                return true;
            
            s = new String((new StringBuilder()).append(s).reverse());
            
            if(Integer.parseInt(s) % 8 ==0)
                return true;
        }
        int[] h = new int[10];
        for(int i=0;i<l;i++)
            h[s.charAt(i) - '0']++;
        for(int i=104;i<1000;i=i+8)
        {
            int dup = i;
            int[] freq = new int[10];
            freq[dup % 10]++;
            dup = dup / 10;
            freq[dup % 10]++;
            dup = dup / 10;
            freq[dup % 10]++;
            
            dup = i;
            
            if(freq[dup % 10] > h[dup%10])
            {
                continue;
            }
            dup = dup / 10;
             if(freq[dup % 10] > h[dup%10])
            {
                continue;
            }
            dup = dup / 10;
             if(freq[dup % 10] > h[dup%10])
            {
                continue;
            }
            
            return true;
        }
        return false;
        
    }
    public static void main(String args[]) {
        // String s = "42";
        String s = "1202";
        System.out.println(check(s,s.length()));
    }
}