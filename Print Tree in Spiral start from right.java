/*package whatever //do not write package name here */
import java.util.*;
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
    public static void printSpiral(Node root)
    {
        if(root==null)return;
        else
        {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            
            s1.add(root);
            while(!s1.empty() || !s2.empty())
            {
                
                while(!s1.empty())
                {
                    Node n = s1.pop();
                    System.out.print(n.data+" ");
                    
                   if(n.right!=null)
                        s2.add(n.right);
                    if(n.left!=null)
                        s2.add(n.left);
                    
                }
                
                while(!s2.empty())
                {
                    Node n = s2.pop();
                    System.out.print(n.data+" ");
                     
                      if(n.left!=null)
                        s1.add(n.left);
                    if(n.right!=null)
                        s1.add(n.right);
                   
                }
                
                
                
            }
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