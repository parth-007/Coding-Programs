/*package whatever //do not write package name here */
import java.util.*;
import java.io.*;
class Dog
{
    int size;
    public Dog(int s)
    {
        size = s;
    }
}
class DogComparator implements Comparator<Dog>{
    @Override
    public int compare(Dog o1,Dog o2)
    {
        return o1.size - o2.size;
        // return o2.size - o1.size; //for desceneding
    }
}
class GFG {
    public static void print(Dog[] d)
    {
        for(Dog d1:d)
            System.out.print(d1.size+" ");
    }
	public static void main (String[] args) {
	    
		Dog d1 = new Dog(5);
		Dog d2 = new Dog(1);
		Dog d3 = new Dog(3);
		Dog d4 = new Dog(2);
		Dog d5 = new Dog(4);
		Dog[] dogArray = {d1,d2,d3,d4,d5};
		
		print(dogArray);
		System.out.println("After Sorting....");
		System.out.println();
		Arrays.sort(dogArray,new DogComparator());
		print(dogArray);
	}
}