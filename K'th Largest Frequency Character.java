/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Pair
{
    char ch;
    int cnt;
    Pair(char c1,int c)
    {
        ch = c1;
        cnt = c;
    }
}
class GFG {
	public static void main (String[] args) {
	    int k = 3;//because I want 2nd largest frequency character.
		String str = "aaabbacccd";
		char[] ch = str.toCharArray();
		TreeMap<Character,Integer> map = new TreeMap<>();
		for(int i=0;i<str.length();i++)
		{
		    if(!map.containsKey(str.charAt(i)))
		        map.put(str.charAt(i),1);
		    else
		        map.put(str.charAt(i),map.get(str.charAt(i))+1);
		}
		ArrayList<Pair> alist = new ArrayList<Pair>();
		for(Map.Entry<Character,Integer> m:map.entrySet())
		{
		    alist.add(new Pair(m.getKey(),m.getValue()));
		}
		Collections.sort(alist,(a,b)->{
		    if(a.cnt>=b.cnt)
		        return -1;
		    else
		        return 1;
		    
		});
		System.out.println(alist.get(k-1).ch);
		
	}
}