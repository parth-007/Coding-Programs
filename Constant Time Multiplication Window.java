import java.util.*;
import java.io.*;

public class SlidingWindow {

private LinkedList<Integer> storage;
private int size;
private int numZeros;
private Integer product;

public static void main(String[] args)
{
    SlidingWindow s = new SlidingWindow(5);
    s.add(10);
    s.add(20);
    System.out.println(s.getProduct());
    s.add(30);
    s.add(0);
    s.add(-1);
    System.out.println(s.getProduct());
}
public SlidingWindow(int k) {
    storage = new LinkedList<Integer>();
    size = k;
    product = new Integer(1);
}

public void add(int val) {
    if (size < 1) {
        return;
    }
    if (storage.size() >= size) {
        int divisor = storage.pollFirst();
        if (divisor == 0) {
            --numZeros;
        } else {
            product /= divisor;
        }
    }
    if (val == 0) {
        ++numZeros;
    } else {
        product *= val;
    }
    storage.addLast(val);
}

public int getProduct() {
    if (size == 0 || numZeros > 0) {
        return 0;
    }
    return product;
}
}