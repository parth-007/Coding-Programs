/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static String rotate(String s,int k)
    {
        char[] ch = s.toCharArray();
        
        int n = s.length();
        char[] shifted = new char[n];
        for(int i=0;i<ch.length;i++)
        {
            int index = ((i+k) % n);
            shifted[index] = ch[i];
        }
        return String.valueOf(shifted);
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.nextLine();
		int k = sc.nextInt();
		System.out.println("After Rotating " + s + " "+ k +" " + "steps");
		System.out.println(rotate(s,k));
	}
}