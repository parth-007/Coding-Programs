public class MyClass {
    public static int search(int[] arr,int low,int high,int find)
    {
        if(low >= high)
            return -1;
        else
        {
            while(low < high)
            {
                int mid = (low + high) / 2;
                if(arr[mid]==find)
                    return mid;
                else if(arr[mid] < find)
                    low++;
                else if(arr[mid] > find)
                    high--;
            }
        }
        return -1;
    }
    public static void main(String args[]) throws Exception {
       int[] arr = {0,0,0,0,0,0,1,1,1,1,1};
       System.out.println(arr.length);
       int low=0,high=1;
       int flag = 0;
       while(true)
       {
           if(flag == 0)
           {
               low = high;
               high = 2 * high;
           }
           else
           {
               high--;
           }
           try
           {
               if(arr[high]==1)
               {
                   System.out.println("Implementing Binary search between " + low +" and " + high);
                   System.out.println("Found 1 at " + search(arr,low,high,1) + " position");
                   break;
               }
           }
           catch(Exception e)
           {
               flag = 1;
           }
       }
    }
}
