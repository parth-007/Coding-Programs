/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    public static String capital(String s)
    {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\\s+");
        for(String w:words)
            sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
        return sb.toString().trim();
    }
	public static void main (String[] args) {
		String s = "welcome to india, bear grylls.";
		System.out.println(capital(s));
	}
}