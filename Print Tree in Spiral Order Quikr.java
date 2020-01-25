/*package whatever //do not write package name here */

import java.io.*;

class Node
{
    int data;
    Node left,right;
    public Node(int x)
    {
        data = x;
        left = right = null;
    }
}
class GFG {
    static int height(Node root)
    {
        if(root==null)return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public static void printSpiral(Node root)
    {
        int h = height(root);
        int cnt = 0;
        for(int i=1;i<=h;i++)
        {
            printUtil(root,i,cnt);
            cnt++;
        }
    }
    public static void printUtil(Node root,int level,int cnt)
    {
        if(root==null)return;
        else if(level == 1)
            System.out.print(root.data+" ");
        else if(level>1 && cnt%2==0)
        {
            
            printUtil(root.left,level-1,cnt);
            printUtil(root.right,level-1,cnt);
           
        }
        else if(level>1 && cnt%2==1)
        {
             printUtil(root.right,level-1,cnt);
            printUtil(root.left,level-1,cnt);
            
        }
    }
	public static void main (String[] args) {
		Node root = new Node(10);
		root.left = new Node(1);
		root.right = new Node(9);
		root.left.left = new Node(7);
		root.left.right = new Node(11);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(22);
		root.right.left = new Node(2);
		root.right.right= new Node(20);
		root.right.right.left = new Node(15);
		root.right.right.right = new Node(3);
		root.left.right.right = new Node(6);
		
		printSpiral(root);
	}
}