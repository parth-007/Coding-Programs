import java.util.*;
class Node
{
    int data;
    Node left,right;
    Node(int x)
    {
        data = x;
        left = right = null;
    }
}
public class MyClass {
    public static void inO(Node root)
    {
        if(root==null) return;
        inO(root.left);
        System.out.print(root.data+" ");
        inO(root.right);
    }
    public static String serialize(Node root)
    {
        if(root==null) return "X,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.data + "," + left + right;
    }
    public static Node deserialize(String s)
    {
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(s.split(",")));
        return Helper(nodesLeft);
    }
    public static Node Helper(Queue<String> nodesLeft)
    {
       String s = nodesLeft.poll();
       if(s.equals("X")) return null;
       
       Node n = new Node(Integer.valueOf(s));
       n.left = Helper(nodesLeft);
       n.right = Helper(nodesLeft);
       return n;
    }
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left  = new Node(6);
        root.right = new Node(16);
        root.right.right = new Node(23);
        root.right.left = new Node(12);
        root.right.left.right = new Node(13);
        root.left.left = new Node(3);
        inO(root);
        
        String s = serialize(root);
        System.out.println("Serialize Form of Tree: " + s);
        System.out.println("Creating Tree from Serialized Tree...");
        Node t = deserialize(s);
        inO(t);
    }
}