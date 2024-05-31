/*
 * @author Sarthak Goyal
 */
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class LinkedListTest {
	
	@Test
	public void isEmpty() {
		SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>();
		assertTrue(s.isEmpty());
	}
	
	@Test
	public void isEmptyFalse() {
		SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>();
		s.addFirst(1);
		assertFalse(s.isEmpty());
	}
	
	@Test
	public void addFirst() {
		SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>();
		s.addFirst(1);
		int a = s.getFirst();
		assertEquals(1, a);
	}
	
	@Test
	public void getFirst() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		int a = b.getFirst();
		assertEquals(1, a);
	}
	
	@Test
	public void getMid() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		int a = b.get(1);
		assertEquals(2, a);
	}
	
	@Test
	public void getEnd() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		int a = b.get(0);
		assertEquals(1, a);
	}
	
	@Test
	public void removeFirst() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		int a = b.removeFirst();
		assertEquals(1, a);
	}
	
	@Test
	public void removeFirstException() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		assertThrows(IndexOutOfBoundsException.class, () -> {b.remove(-2);});
	}
	
	@Test
	public void removeBeg() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		b.remove(0);
		Object[] arr = new Object[] {2,3};
		
		Object[] a = b.toArray();
		assertArrayEquals(a, arr);
	}
	
	@Test
	public void removeMid() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		b.add(3, 4);
		b.add(4, 5);
		b.remove(2);
		Object[] arr = new Object[] {1,2,4,5};
		
		Object[] a = b.toArray();
		assertArrayEquals(a, arr);
	}
	
	@Test
	public void removeEnd() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		b.add(3, 4);
		b.add(4, 5);
		b.remove(4);
		Object[] arr = new Object[] {1,2,3,4};
		
		Object[] a = b.toArray();
		assertArrayEquals(a, arr);
	}
	
	@Test
	public void indexOfBeg() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		b.add(3, 4);
		b.add(4, 5);
		
		assertEquals(b.indexOf(4), 3);
	}
	
	@Test
	public void indexOfMid() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		b.add(3, 4);
		b.add(4, 5);
		b.add(5, 4);
		b.add(6, 4);
		b.add(7, 8);
		b.add(8, 9);
		
		assertEquals(b.indexOf(4), 3);
	}
	
	@Test
	public void indexOfEnd() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		b.add(3, 4);
		b.add(4, 5);
		b.add(5, 4);
		b.add(6, 4);
		b.add(7, 8);
		b.add(8, 9);
		
		assertEquals(b.indexOf(9), 8);
	}
	
	@Test
	public void sizeEmpty() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		
		assertEquals(b.size(), 0);
	}
	
	@Test
	public void size() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		b.add(3, 4);
		b.add(4, 5);
		b.add(5, 4);
		b.add(6, 4);
		b.add(7, 8);
		b.add(8, 9);
		
		assertEquals(b.size(), 9);
	}
	
	@Test
	public void clear() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		b.add(3, 4);
		b.add(4, 5);
		b.add(5, 4);
		b.add(6, 4);
		b.add(7, 8);
		b.add(8, 9);
		b.clear();
		
		assertEquals(b.size(), 0);
	}
	
	@Test
	public void toSmallArray() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(1, 3);
		Object[] arr = new Object[] {1,3,2};
		

		Object[] a = b.toArray();
		assertArrayEquals(a, arr);
		}
	
	@Test
	public void toMedArray() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		b.add(3, 4);
		b.add(4, 5);
		b.add(5, 6);
		b.add(1, 5);
		
		Object[] arr = new Object[] {1,5,2,3,4,5,6};
		

		Object[] a = b.toArray();
		assertArrayEquals(a, arr);
	}
	
	@Test
	public void toLargeArray() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();
		b.addFirst(1);
		b.add(1, 2);
		b.add(2, 3);
		b.add(3, 4);
		b.add(3, 7);
		
		Object[] arr = new Object[] {1,2,3,7,4};
		

		Object[] a = b.toArray();
		assertArrayEquals(a, arr);
	}
	
	
	

	
//***********************************************************************************************************************************************
//							                   	LinkedListStack tests
//***********************************************************************************************************************************************	

	
	
	@Test
	public void peek() {
		LinkedListStack<Integer> b = new LinkedListStack<Integer>();
		b.push(3);
		b.push(2);
		b.push(1);
		
		int a = b.peek();
		assertEquals(a, 1);

	}
	
	@Test
	public void pop() {
		LinkedListStack<Integer> b = new LinkedListStack<Integer>();
		b.push(4);
		b.push(3);
		b.push(2);
		b.push(1);
		int a = b.pop();
		assertEquals(a, 1);

	}
	
	
	@Test
	public void push() {
		LinkedListStack<Integer> b = new LinkedListStack<Integer>();
		b.push(4);
		b.push(3);
		int a = b.pop();
		b.push(2);
		
		assertEquals(a, 3);
	}
	
	@Test
	public void sizeStack() {
		LinkedListStack<Integer> b = new LinkedListStack<Integer>();
		b.push(4);
		b.push(3);
		b.push(2);
		
		assertEquals(b.size(), 3);
	}
	
	@Test
	public void sizeStackWhenPop() {
		LinkedListStack<Integer> b = new LinkedListStack<Integer>();
		b.push(6);
		b.push(5);
		b.push(4);
		b.push(3);
		b.push(2);
		b.pop();
		
		assertEquals(b.size(), 4);
	}
	
	@Test
	public void stackIsEmpty() {
		LinkedListStack<Integer> b = new LinkedListStack<Integer>();
		b.push(4);
		b.push(3);
		b.push(2);
		b.pop();
		b.pop();
		b.pop();
		assertTrue(b.isEmpty());
	}
	
	@Test
	public void stackClear() {
		LinkedListStack<Integer> b = new LinkedListStack<Integer>();
		b.push(4);
		b.push(3);
		b.push(2);
		b.clear();
		assertTrue(b.isEmpty());
	}
		
}