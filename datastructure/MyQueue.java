package com.bridgelabz.datastructure;

public class MyQueue<T>
{	
	private T[] items;
	private int front;
	private int rear;
	private int size;
	private int capacity;
	
	//empty Constructor
	@SuppressWarnings("unchecked")
	public MyQueue()
	{
		capacity=1000;
		items=(T[])new Object[capacity];
		front=0;
		rear=-1;
		size=0;
	}
	//Constructor
	@SuppressWarnings("unchecked")
	public MyQueue(int capacity)
	{
		this.capacity=capacity;
		items=(T[])new Object[capacity];
		front=-1;
		 rear=-1;
		size=0;
		

	}
	
	public boolean isEmpty()
	{
	return size==0;
	}
	
	public boolean isFull()
	{
	return size==capacity;
	}
	
	public void enqueue(T element)
	{
	if(isFull())
	{
	System.out.println("the queue is full");
	return;
	}
	else if(rear==-1&&front==-1)
	{
	rear=(rear+1)%capacity;
	front=rear;
	items[rear]=element;
	size++;
	}else
	rear=(rear+1)%capacity;
	items[rear]=element;
	size++;
}
	
	
	public T dequeue() 
	{
		if(isEmpty()) 
		{
		System.out.println("Queue is empty...Enqueue some items before dequeuing it...!");
			
		}
		T element=items[front]; 
		front=(front+1)%capacity; 
		size=size-1; 
		return element; 
	}
	
	//return the front element of the queue
	public T peek()
	{
		if(isEmpty())
		{
		System.out.println("the queue is empty");
		}
		return items[front];
	}
	public int size()
	{
		return size;
	}
	public void show()
	{
		for(int i=0;i<size;i++)
		{
			System.out.print(items[i]);
		}
	}

}
