package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTests {

	@BeforeEach
	void setUp () {
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void addFirstTest ()
	{
		SinglyLinkedList sLL = new SinglyLinkedList (); 
		
		int element = 1; 
		int next = 2; 
		int third = 3; 
		
		sLL.addFirst(element); 
		sLL.addFirst(next);
		sLL.addFirst(third);
		
		assertEquals(3, sLL.getFirst()); 
	}
	
	@Test
	void addingTest ()
	{
		SinglyLinkedList sLL = new SinglyLinkedList (); 
		
		int element = 1; 
		int next = 2; 
		int third = 3; 
		
		int temp = 6; 
		int index = 2; 
		
		sLL.addFirst(element); 
		sLL.addFirst(next);
		sLL.addFirst(third);
		
		sLL.add(index, element);
		
		assertEquals(3, sLL.getFirst());
	}
	
	

}
