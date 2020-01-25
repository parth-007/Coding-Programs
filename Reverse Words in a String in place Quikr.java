/*package whatever //do not write package name here */

import java.util.*;

class GFG {
   public static String reverseWords2(String s) {
   if(s.equals(null) || s.equals(" "))
    return s;
    int i = 0;
    int l = s.length();
    String res=" ";
    while(i<l)
    {
        while(i<l && s.charAt(i)==' ')
            i++;
        String w ="";
        while(i<l && s.charAt(i)!=' ')
            {
                w += s.charAt(i);
                i++;
            }
            if(!w.equals(""))
                res=w+" "+res;
    }
    return (res.isEmpty() ? "" :res.substring(0,res.length()-1));
}
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String s = sc.nextLine();
		System.out.println(reverseWords2(s));
	}
}