/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class GFG {
    static HashSet<Integer> set = new HashSet<>();
    public static void GenerateSubsequences(String s)
    {
        int l = s.length();
        for(int i=0;i<l;i++)
        {
            for(int j=s.length();j>i;j--)
            {
                String sub_str = s.substring(i,j);
                int val = Integer.parseInt(sub_str);
                if(!set.contains(val))
                    set.add(Integer.parseInt(sub_str));
                
                for(int k=1;k<sub_str.length()-1;k++)
                {
                    StringBuffer sb = new StringBuffer(sub_str);
                    sb.deleteCharAt(k);
                    int val2 = Integer.parseInt(sb.toString());
                    if(!set.contains(val2))
                        GenerateSubsequences(sb.toString());
                }
            }
        }
    }
    public static String ContainsO(int i, HashSet<Integer> set,int k)
    {
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext())
        {
            if(itr.next() % k == i)
                return "YES";
        }
        return "NO";
    }
	public static void main (String[] args) {
	    int[] q = {0,1,2};
		String s = "174";
		int k = 5;
		GenerateSubsequences(s);
		for(int i=0;i<q.length;i++)
		{
		    System.out.println(ContainsO(q[i],set,k));
		}
		System.out.print(set);
	}
}