
/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    public static void printPermutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutation(ros, ans + c);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        printPermutation(str, " ");
    }
}