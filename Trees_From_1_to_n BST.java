/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}
class GFG {
	public static void main (String[] args) {
		ArrayList<Node> alist = ConstructTrees(1,3);
		System.out.println("Preorder Traversal of All constructed BSTs");
		for(int i=0;i<alist.size();i++)
		{
		    PreOrder(alist.get(i));
		    System.out.println();
		}
	}
	static ArrayList<Node> ConstructTrees(int start,int end)
	{
	    ArrayList<Node> list = new ArrayList<>();
	    if(start>end)
	    {
	        list.add(null);
	        return list;
	    }
	    for(int i=start;i<=end;i++)
	    {
	        ArrayList<Node> leftsubtree = ConstructTrees(start,i-1);
	        ArrayList<Node> rightsubtree = ConstructTrees(i+1,end);
	        for(int j=0;j<leftsubtree.size();j++)
	        {
	            Node left = leftsubtree.get(j);
	            for(int k=0;k<rightsubtree.size();k++)
	            {
	                Node right = rightsubtree.get(k);
	                Node node = new Node(i);
	                node.left = left;
	                node.right = right;
	                list.add(node);
	            }
	        }
	    }
	    return list;
	}
	static void PreOrder(Node root)
	{
	    if(root==null)return;
	    System.out.print(root.data+" ");
	    PreOrder(root.left);
	    PreOrder(root.right);
	}
}