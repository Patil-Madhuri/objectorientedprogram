package com.bridgelabz.program;
/***************************************************************************
 * @purpose : structure for deck of cards using queue 
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 15/03/2018
 ***************************************************************************/
class Node1
{
	String data;
	Node1 next;
}
public class CardQueue
{
	Node1 front,rear;
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
		Node1 oldrear =rear;
		rear = new Node1();
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
