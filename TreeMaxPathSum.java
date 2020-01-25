/*package whatever //do not write package name here */
import java.io.*;
class Node
{
    int data;
    Node left,right;
    public Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}
class Temp
{
    int value;
}
class GFG {
    public static void inOrder(Node root)
    {
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static Node createTree(int[] arr,Node root,int i)
    {
        if(i<arr.length)
        {
            Node temp = new Node(arr[i]);
            root = temp;
            
            root.left = createTree(arr,root.left,(2*i)+1);
            root.right = createTree(arr,root.right,(2*i)+2);
        }
        return root;
    }
    public static int getDiameter(Node root)
    {
        Temp tmp = new Temp();
        tmp.value = Integer.MIN_VALUE;
        maxPathUtil(tmp,root);
        return tmp.value;
    }
    public static int maxPathUtil(Temp t, Node root)
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.data;
        int ls = maxPathUtil(t,root.left);
        int rs = maxPathUtil(t,root.right);
        if(root.left!=null && root.right!=null)
        {
            t.value = Math.max(t.value,ls+rs+root.data);
            return Math.max(ls,rs) + root.data;
        }
        return (root.left==null)? rs+root.data : ls+root.data;
    }
    public static int height(Node root)
    {
        if(root==null)return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public static int printMaxDiameterPath(int[] arr,int nodes)
    {
        //we will create a tree here using a dummy node.
        Node a = new Node(0);
        Node root = createTree(arr,a,0);
        // inOrder(root);
        int maxsum = getDiameter(root);
        return maxsum;
        
        
    }
	public static void main (String[] args) {
		int[] arr = {2,4,5,8,-4,3,-6};
		int nodes = 7;
		System.out.println(printMaxDiameterPath(arr,nodes));
	}
}