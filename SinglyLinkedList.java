package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a SinglyLinkedList and implements from List
 * @author Casey Rand and Morgan Mischo
 *
 * @param <E>
 */
public class SinglyLinkedList<E> implements List<E> {

	private class Node<E> {
		public E data;
		public Node<E> next;
		
		public Node(E data, Node<E> next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head, last;
	private int size;
	
	public SinglyLinkedList()
	{
		head = null;
		last = null;
		size = 0;
	}
	
	@Override
	public void addFirst(E element) {
		if(head == null)
		{
			head = new Node<E> (element, last);
		}
		else
		{
			head = new Node<E> (element, head);
		}
		size++;
	}

	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException (); 
		}
		
		//Index 0 acts as add first.
		if (index == 0)
		{
			addFirst(element);
			return;
		}
		
		Node<E> current = head;
		for (int i = 1; i <= size; i++)
		{
			if (i == index)
			{	
				Node<E> temp = new Node<E> (element, current.next);
				current.next = temp; 
				break; 
			}
			current = current.next;
		}
		size++;
	}

	@Override
	public E getFirst() throws NoSuchElementException {
		if (head.data == null)
		{
			throw new NoSuchElementException();
		}
		
		return head.data;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException (); 
		}
		
		Node<E> current = head;
		for (int i = 0; i <= size; i++)
		{
			if (i == index)
			{	
				return current.data; 
			}
			current = current.next;
		}
		return null;
	}

	@Override
	public E removeFirst() throws NoSuchElementException {
		if (head == null)
		{
			throw new NoSuchElementException();
		}
		
		E result = head.data; 
		
		head = head.next; 
		size--;
		return result; 		
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException(); 
		}
		
		Node<E> current = head;
		Node<E> prev = null;
		
		for (int i = 0; i <= size; i++)
		{
			if (i == index)
			{	
				prev.next = current.next;
				size--;
				break;
			}
			prev = current;
			current = current.next;
		}
		return current.data;
	}

	@Override
	public int indexOf(E element) {
		int count = 0; 
		
		Node<E> current = head;
		while(count < size)
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
		if (size > 0)
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
		Object[] temp = new Object[size]; 
		
		Node<E> current = head;
		for (int i = 0; i < size; i++)
		{
			temp[i] = current.data;
			current = current.next;
		}
		return temp; 
	}
	
//	public String toString() {
//		String temp = "";
//		Node<E> current = head;
//		for (int i = 0; i < size; i++)
//		{
//			temp = temp + current.data + " ";
//			current = current.next;
//		}
//		return temp;
//	}
	
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
