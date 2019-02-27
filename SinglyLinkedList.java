package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList <E> implements List<E>{
	
	private class Node <E> {
		public E data;
		public Node next;
		
		public Node(E data, Node next)
		{
			this.data = data; 
			this.next = next; 
		}
	}
	
	private Node head; 
	private int size; 
	private Node <E> current;  
	private Node <E> prev;
	private Node <E> next;
	
	public SinglyLinkedList () {
		head = null;
		size = 0;
		
	}

	@Override
	public void addFirst(E element) {
		if(head == null)
		{
			head = new Node (element, next);  
			size++; 	
		}
		head.next = head;
		head = new Node (element, next);
	}

	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException {
		if (index > size)
		{
			throw new IndexOutOfBoundsException (); 
		}
		
		for (int i = 0; i <= size; i++)
		{
			if (i == index)
			{	
				Node temp = new Node (element, current.next);
				current.next = temp; 
				break; 
			}
		}
	}

	@Override
	public E getFirst() throws NoSuchElementException {
		if (head.data == null)
		{
			throw new NoSuchElementException (); 
		}
		
		//Added a cast to E, but it should already be E (???!)
		return (E) head.data; 
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index > size)
		{
			throw new IndexOutOfBoundsException(); 
		}
		int count = 0; 
		
		while(count <= size)
		{
			if (index == count)
			{
				return current.data; 
			}
			count++;
			current = current.next; 
		}
		return null; 
	}

	@Override
	public E removeFirst() throws NoSuchElementException {
		E result = (E) head.data; 
		
		head = head.next; 
		
		return result; 
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		
		if (index > size)
		{
			throw new IndexOutOfBoundsException(); 
		}
		int count = 0; 
		
		while(count <= size)
		{
			if (index == count)
			{
				prev.next = current.next;
				return current.data; 
			}
			count++; 
			current = current.next; 
		}
		return null; 
	}

	@Override
	public int indexOf(E element) {
		int count = 0; 
		
		while(count <= size)
		{
			if (current.data == element)
			{
				return count;  
			}
			current = current.next; 
			count++; 
		}
		return -1; 
	}

	@Override
	public int size() {
		return size; 
	}

	@Override
	public boolean isEmpty() {
		if (size >= 0)
		{
			return false; 
		}
		return true; 
	}

	@Override
	public void clear() {
		size = 0; 
		head = null; 
		
	}

	@Override
	public Object[] toArray() {
		//Error creating E[]
		Object[] temp = new Object[size]; 
		
		for (int i = 0; i <= size; i++)
		{
			temp[i] = current.data; 
		}
		return temp; 
	}

	@Override
	public Iterator <E> iterator() {
		return new SinglyLinkedListIterator(); 
	}

	private class SinglyLinkedListIterator implements Iterator <E> 
	{
		private boolean removable; 
		
		private Node <E> current;  
		private Node <E> prev;
		private Node <E> next;
		
		private SinglyLinkedListIterator () {
			removable = false; 
		    current = null; 
		    prev = null;
		    next = head;
		}

		@Override
		public boolean hasNext() {
			return next.next != null; 
		}

		@Override
		public E next() {
			if (!hasNext ())
			{
				throw new NoSuchElementException(); 
			}
			prev = current; 
			current = next; 
			next = next.next; 
			
			removable = true; 
			
			return current.data; 
		}
		
		public void remove() throws IndexOutOfBoundsException {
			if(prev == null)
			{
				throw new IndexOutOfBoundsException(); 
			}
			if (removable)
			{
				prev.next = next; 
			}
			removable = false; 
			
			}
		
	}
}
