package assign06;

import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Stack<E>{

	private SinglyLinkedList<E> sLL = new SinglyLinkedList (); 
	
	public LinkedListStack () {	
	}
	
	@Override
	public void clear() {
		sLL.clear();
	}

	@Override
	public boolean isEmpty() {
		return sLL.isEmpty(); 
	}

	@Override
	public E peek() throws NoSuchElementException {
		return sLL.getFirst(); 
	}

	@Override
	public E pop() throws NoSuchElementException {
		return sLL.removeFirst(); 
	}

	@Override
	public void push(E element) {
		sLL.addFirst(element);
	}

	@Override
	public int size() {
		return sLL.size(); 
	}

}
