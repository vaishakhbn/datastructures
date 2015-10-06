package ctci.vaishakh.linkedlist;

import java.util.HashSet;

public class Node 
{
	int data;
	Node next;
	public Node()
	{
		this.next = null;
	}
	public Node(int d)
	{
		this.data = d;
		this.next = null;
	}
	
	public void appendToTail(int d)
	{
		Node end = new Node(d);
		Node n = this;
		while(n.next!=null)
		{
			n = n.next;
		}
		n.next = end;
	}
	Node deleteNode(int d, Node head)
	{
		Node n = head;
		if(n.data == d)
		{
			return head.next;
		}
		while(n.next!=null)
		{
			if(n.data == d)
			{
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	void removeDups(Node head)
	{
		//Using Two Loops
		Node current = head;
		Node m = head.next;
		while(current.next!=null)
		{
			while(m.next!=null)
			{
				if(m.data == current.data)
				{
					m.next = m.next.next;
				}
				else
					m = m.next;
			}
			current = current.next;
			
		}
	}
	
	void removeDupsWithoutTwoLoops(Node head)
	{
		HashSet<Integer> list = new HashSet<Integer>();
		Node prev = null;
		while(head!=null)
		{
			if(list.contains(head.data))
			{
				prev.next = head.next;
			}
			else
			{
				list.add(head.data);
				prev = head;
			}
			head = head.next;
		}
	}
	
	int kthFromLast(Node head, int k)
	{
		Node cur = head;
		Node temp = head;
		for(int i = 0; i < k ; i++)
		{
			if(cur==null)
			{
				return -1;
			}
			else
				cur = cur.next;
		}
		while(cur!=null)
		{
			cur = cur.next;
			temp = temp.next;
		}
		return temp.data;
	}
	
	boolean deleteNode(Node middleNode)
	{
		if(middleNode == null || middleNode.next ==null)
			return false;
		Node temp = middleNode.next;
		middleNode.data = temp.data;
		middleNode.next = temp.next;
		return true;
	}
	
	Node addLists(Node l1, Node l2, int carry)
	{
		if(l1==null && l2 == null && carry == 0)
			return null;
		Node result = new Node();
		int val = carry;
		if(l1!=null)
		{
			val += l1.data;
		}
		if(l2!=null)
		{
			val+=l2.data;
		}
		result.data = val%10;
		
		result.next = addLists(l1 ==null ? null:l1.next, l2 ==null ? null:l2.next, val>10?val/10:0);
		return result;
	}
	

}
