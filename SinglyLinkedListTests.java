package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTests {
	
	@Test
	void addFirst_getFirst_single ()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 
		
		Integer expected = 1;
		
		sLL.addFirst(1); 

		assertEquals(expected, sLL.getFirst()); 
	}
	
	@Test
	void addFirst_Multiple()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> ();

		Integer expected = 3;
		
		sLL.addFirst(1); 
		sLL.addFirst(2);
		sLL.addFirst(3);
		
		assertEquals(expected, sLL.getFirst()); 
	}
	
	@Test
	void toArray_Object()
	{
		SinglyLinkedList<Object> sLL = new SinglyLinkedList<Object> ();

		Object puck = new Object();
		Object stain = new Object();
		Object quirk = new Object();
		
		sLL.addFirst(puck); 
		sLL.addFirst(stain);
		sLL.addFirst(quirk);
		
		//quirk is at the beginning
		Object a1 = sLL.toArray()[0];
		Object a2 = sLL.toArray()[1];
		//puck should be at the end
		Object a3 = sLL.toArray()[2];
		
		assertEquals(puck, a3); 
		assertEquals(stain, a2);
		assertEquals(quirk, a1);
	}
	
	@Test
	void add_middleIndex ()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 
		
		Integer expected = 10;
		
		sLL.addFirst(1); 
		sLL.addFirst(5);
		sLL.addFirst(8);
		
		sLL.add(2, 10);
		Integer actual = (Integer) sLL.toArray()[2];
				
		assertEquals(expected, actual);
	}
	
	@Test
	void add_firstIndex()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 
		Integer expected = 10;
		
		sLL.addFirst(1); 
		sLL.addFirst(5);
		sLL.addFirst(8);
		
		sLL.add(0, 10);
		Integer actual = (Integer) sLL.toArray()[0];
				
		assertEquals(expected, actual);	
	}
	
	@Test
	void add_lastIndex()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 
		Integer expected = 10;
		
		sLL.addFirst(1); 
		sLL.addFirst(5);
		sLL.addFirst(8);
		
		sLL.add(3, 10);
		Integer actual = (Integer) sLL.toArray()[3];
						
		assertEquals(expected, actual);	
	}
	
	@Test
	void add_outOfBoundsThrows()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 
		
		sLL.addFirst(1); 
		sLL.addFirst(5);
		sLL.addFirst(8);
		
		assertThrows(IndexOutOfBoundsException.class, () -> { sLL.add(4, 10); });
	}
	
	@Test
	void get_String()
	{
		SinglyLinkedList<String> sLL = new SinglyLinkedList<String> (); 
		
		sLL.addFirst("Hat"); 
		sLL.addFirst("the");
		sLL.addFirst("in");
		sLL.addFirst("Cat");
		
		String s1 = "Cat";
		String s2 = "in";
		String s4 = "Hat";
				
		assertEquals(s1, sLL.get(0));
		assertEquals(s2, sLL.get(1));
		assertEquals(s4, sLL.get(3));
		assertThrows(IndexOutOfBoundsException.class, () -> { sLL.get(4); });
	}
	
	@Test
	void removeFirst()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 
		assertThrows(NoSuchElementException.class, () -> { sLL.removeFirst(); });
		
		sLL.addFirst(1); 
		sLL.addFirst(5);
		
		Integer e1 = 5;
		Integer e2 = 1;
		
		assertEquals(e1, sLL.removeFirst());
		assertEquals(e2, sLL.get(0));		
	}

	@Test
	void remove()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 
		assertThrows(NoSuchElementException.class, () -> { sLL.removeFirst(); });
		
		sLL.addFirst(1); 
		sLL.addFirst(5);
		sLL.addFirst(8);
		
		Integer e1 = 5;
		Integer e2 = 1;
		
		assertEquals(e1, sLL.remove(1));
		assertEquals(e2, sLL.get(1));
		assertThrows(IndexOutOfBoundsException.class, () -> { sLL.remove(2); });
	}
	
	@Test
	void indexOf()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 
		
		sLL.addFirst(1);
		sLL.addFirst(5);
		sLL.addFirst(4);
		sLL.addFirst(8);
		sLL.addFirst(23);

		assertEquals(3, sLL.indexOf(5));
		assertEquals(0, sLL.indexOf(23));
		assertEquals(-1, sLL.indexOf(14));
	}
	
	@Test
	void sizeOf()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 

		sLL.addFirst(1);
		sLL.addFirst(5);
		sLL.addFirst(4);
		sLL.addFirst(8);
		sLL.addFirst(23);
		
		assertEquals(5, sLL.size());
	}

	@Test
	void isEmpty()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 

		assertTrue(sLL.isEmpty());
		
		sLL.addFirst(1);
		sLL.addFirst(5);
		sLL.addFirst(4);
		sLL.addFirst(8);
		sLL.addFirst(23);
		
		assertFalse(sLL.isEmpty());
	}
	
	@Test
	void clear()
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer> (); 

		sLL.addFirst(1);
		sLL.addFirst(5);
		sLL.addFirst(4);
		sLL.addFirst(8);
		sLL.addFirst(23);
		sLL.clear();
		
		assertTrue(sLL.isEmpty());
		assertThrows(IndexOutOfBoundsException.class, () -> { sLL.get(4); });
	}
}
