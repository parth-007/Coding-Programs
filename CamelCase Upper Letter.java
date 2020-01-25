/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    public static String change(String str)
    {
        int count = 0;
        char[] ch = str.toCharArray();
        
        int res_index = 0;
        for(int i=0;i<str.length();i++)
        {
            if(ch[i]==' ')
            {
                count++;
                ch[i+1] = Character.toUpperCase(ch[i+1]);
                continue;
            }
            else
            {
                ch[res_index++] = ch[i];
            }
        }
        return String.valueOf(ch,0,ch.length-count);
    }
	public static void main (String[] args) {
		String str = "I got intern at geeksforgeeks";
		System.out.println(change(str));
	}
}