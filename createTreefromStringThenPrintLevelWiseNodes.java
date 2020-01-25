/*package whatever //do not write package name here */
import java.util.*;
import java.io.*;
class Node
{
    char data;
    Node left,right;
    public Node(char c)
    {
        data = c;
        left = null;
        right = null;
    }
}
class GFG {
    public static int findIndex(String s,int low,int high)
    {
        if(low > high)
            return -1;
        Stack<Character> st = new Stack<>();
        for(int i=low;i<=high;i++)
        {
            char c = s.charAt(i);
            if(c=='(')
                st.push(c);
            else if(c==')')
            {
                if(st.peek()=='(')
                {
                    st.pop();
                    
                    if(st.empty())
                        return i;
                }
            }
        }
        return -1;
    }
    public static Node TreeFromString(String s,int low,int high)
    {
        if(low > high) //base case
            return null;
        Node root = new Node(s.charAt(low));
        int index = -1;
        //findindex function is for finding the index of ending ) for the corresponding (.
        if(low+1 <= high && s.charAt(low+1)=='(')
            index = findIndex(s,low+1,high);
        if(index != -1)
        {
            root.left = TreeFromString(s,low+2,index-1);
            root.right = TreeFromString(s,index+2,high-1);
        }
        return root;
    }
    public static void inOrder(Node root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.println(root.data+" ");
        inOrder(root.right);
    }
    public static void printLevel(Node root,int k)
    {
        if(root==null)return;
        HashMap<Integer,LinkedList<Node>> map = new HashMap<>();
        int hd = 0;
        verticalOrderUtil(root,map,hd);
        ArrayList<Character> alist = new ArrayList<>();
        for(int x:map.keySet())
        {
            if(x==k)
            {
                for(Node n:map.get(x))
                {
                    alist.add(n.data);
                }
            }
        }
        Collections.sort(alist);
        for(int f:alist)
        System.out.print(f-'0'+" ");
    }
    public static void verticalOrderUtil(Node root,HashMap<Integer,LinkedList<Node>> map,int hd)
    {
        if(root==null)
            return;
        if(!map.containsKey(hd))
        {
            LinkedList<Node> list = new LinkedList<Node>();
            list.add(root);
            map.put(hd,list);
        }
        else
        {
            map.get(hd).add(root);
        }
        verticalOrderUtil(root.left,map,hd-1);
        verticalOrderUtil(root.right,map,hd+1);
        
    }
	public static void main (String[] args) {
		String str = "4(2(3)(1))(6(5))";
		Node root = TreeFromString(str,0,str.length()-1);
		int k = 0;
		printLevel(root,k);
// 		inOrder(root);
	}
}