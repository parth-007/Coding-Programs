import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws Exception
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        
	        String s = sc.next();
	        Map<Character,Integer> map = new TreeMap<>(Collections.reverseOrder());
	        for(int i=0;i<s.length();i++)
	        {
	            char c = s.charAt(i);
	            if(!map.containsKey(c))
	                map.put(c,1);
	            else
	                map.put(c,map.get(c)+1);
	        }
	        for(Map.Entry<Character,Integer> m:map.entrySet())
	        {
	            int key = m.getValue();
	            for(int i=0;i<key;i++)
	                System.out.print(m.getKey());
	        }
	        System.out.println();
	    }
	    
	 }
}