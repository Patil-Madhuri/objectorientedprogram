package com.bridgelabz.program;
class Node
{
	String data;
	Node next;
}
public class CardQueue
{
	Node front,rear;
	int size;
	
	public CardQueue() 
	{
		front = null;
		rear = null;
		size=0;
	}
	
	public boolean isEmpty()
	{
		return(size==0);
	}
	public void push(String data)
	{
		Node oldrear =rear;
		rear = new Node();
		rear.data = data;
		rear.next = null;
		if(isEmpty())
		{
			front=rear;
		}
		else
		{
			oldrear.next = rear;
		}
		size++;
		System.out.println(data+" ");
	}
}
