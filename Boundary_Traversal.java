class Node
{
    char data;
    Node left,right;
    Node(char  c)
    {
        data = c;
        left = right = null;
    }
}
public class MyClass {
    public static void print(Node root){
        if(root==null) return;
        print(root.left);
        System.out.print(root.data+" ");
        print(root.right);
    }
    public static void Boundary(Node root)
    {
        if(root==null) return;
        System.out.print(root.data+" ");
        LeftBoundary(root.left);
        LeafNodes(root);
        RightBoundary(root.right);
        
    }
    public static void LeftBoundary(Node root)
    {
        if(root!=null)
        {
            if(root.left!=null)
            {
                System.out.print(root.data+" ");
                LeftBoundary(root.left);
            }
            else if(root.right!=null)
            {
                System.out.print(root.data+" ");
                LeftBoundary(root.right);
            }
        }
    }
    public static void RightBoundary(Node root)
    {
        if(root!=null)
        {
            if(root.right!=null)
            {
                RightBoundary(root.right);
               System.out.print(root.data+" ");
                
            }
            else if(root.left!=null)
            {
                RightBoundary(root.left);
                 System.out.print(root.data+" ");
                
            }
        }
    }
    public static void LeafNodes(Node root)
    {
        if(root!=null)        
        {
            LeafNodes(root.left);
            if(root.left==null && root.right==null)
                System.out.print(root.data+" ");
            LeafNodes(root.right);
        }
    }
    public static void main(String args[]) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.left.right = new Node('h');
        root.left.left = new Node('c');
        root.left.left.right = new Node('g');
        root.left.left.left = new Node('d');
        root.left.left.left.right = new Node('f');
        root.left.left.left.right.right = new Node('e');
        root.right = new Node('k');
        root.right.left = new Node('j');
        root.right.right = new Node('l');
        root.right.right.left = new Node('m');
        root.right.right.right = new Node('n');
        
        //print(root);
        Boundary(root);
    }
}