/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static int[] ClosestDistance(int[] arr)
    {
        int[] result = new int[arr.length];
        Arrays.fill(result,0);
        HashMap<Integer,ArrayList<Integer>> hmap = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(!hmap.containsKey(arr[i]))
            {
                ArrayList<Integer> a1 = new ArrayList<>();
                hmap.put(arr[i],a1);
                hmap.get(arr[i]).add(i);
            }
            else
                hmap.get(arr[i]).add(i);
        }
        // for(Map.Entry<Integer,ArrayList<Integer>> m:hmap.entrySet())
        // {
        //     ArrayList<Integer> alist = m.getValue();
        //     System.out.println();
        //     System.out.print(m.getKey()+"->");
        //     for(int i=0;i<alist.size();i++)
        //         System.out.print(alist.get(i)+" ");
        // }
        for(Map.Entry<Integer,ArrayList<Integer>> m:hmap.entrySet())
        {
            ArrayList<Integer> alist = m.getValue();
            int n = alist.size();

            int before = 0;
            int after = 0;
            for(int i=1;i<n;i++)
                after+=alist.get(i) - alist.get(0);
            result[alist.get(0)] = after;
            for(int i=1;i<n;i++)
            {
                int diff = alist.get(i) - alist.get(i-1);
                after -= diff * (n-i);
                before += diff * i;
                
                result[alist.get(i)] = after + before;
            }
        }
        return result;
    }
	public static void main (String[] args) {
		int[] arr = {1,2,2,1,5,1};
		int[] result = ClosestDistance(arr);
		for(int i:result)
		    System.out.print(i+" ");
	}
}