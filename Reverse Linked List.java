/*package whatever //do not write package name here */

import java.io.*;
class Node
{
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next = null;
    }
}
public class GFG {
    public static void print(Node head)
    {
        Node curr = head;
        while(curr!=null)
        {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
    public static Node printR(Node head)
    {
        if(head==null || head.next==null)
            return head;
        Node newHead = printR(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static Node printL(Node head)
    {
        Node curr = head;
        Node prev = null;
        Node vnext = null;
        while(curr!=null)
        {
            vnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = vnext;
        }
        head = prev;
        return head;
    }
	public static void main (String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		print(head);
		System.out.println();
		System.out.println("After Reverse - Recursion");
		Node c = printR(head);
		print(c);
		System.out.println();
		System.out.println("After Reverse - Loop");
		Node r = printL(c);
		print(r);
	}
}