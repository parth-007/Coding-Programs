import java.util.*;
import java.io.*;
public class MyClass {
    
    static int power(int x, int a) 
    { 
        int res = 1; 
        while (a>0) 
        { 
            if ((a & 1)>0) 
                res = res * x; 
            x = x * x; 
            a >>= 1; 
        } 
        return res; 
    }
    
    public static int number_break(int N)
    {
        // 2 == 1 + 1 => 1*1=>1
        if(N==2)
            return 1;
        if(N==3) //3 == 2 + 1 =>2 * 1 =>2
            return 2;
        int maxProduct = -1;
        switch(N%3)
        {
            case 0:
                maxProduct = power(3,N/3);
                break;
            case 1:
                maxProduct = 2 * 2 * power(3,N/3 - 1);
                break;
            case 2:
                maxProduct = 2 * power(3,N/3);
                break;
        }
        return maxProduct;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();//N=10 //N=23 //N=39 // N=
        System.out.println(number_break(N));
    }
}
