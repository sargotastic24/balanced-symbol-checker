/*
 * @author Sarthak Goyal
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<Type> implements List<Type> {
	
	private class Node {
		public Type data;
		public Node next;
		
		public Node(Type data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	private Node head;
	private int count;
	
	/*
	 * default constructor
	 */
	public SinglyLinkedList() {
		head = null;
		count = 0;
	}
	
	/**
	 * Inserts an element at the beginning of the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @param element - the element to add
	 */
	@Override
	public void addFirst(Type element) {
			head = new Node(element, head);
			count++;
	}
	
	/**
	 * Inserts an element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index > size())
	 */
	@Override
	public void add(int index, Type element) throws IndexOutOfBoundsException {
		
		if (index == 0) {
			head = new Node(element, head);
			count++;
		}
		
		if(count == index) {
			Node addNode = new Node(element, head);
		    int position = count - 1;
		    Node curr = head;
		    for (int i = 0; i <= position; i++) {
		      if(i == position) {
		        addNode.next = curr.next;
		        curr.next = addNode;
		      }
		      curr = curr.next;
		    }
		   ++count;
		}
		
		else {	
			Node curr = head;
			for(int i = 0; i < index - 1; i++)
			{
				curr = curr.next;
			}
			 Node addNode = new Node(element, curr.next);

			    int position = index - 1;
			    addNode.next = head;

			    Node previous = head;

			    for (int i = 0; i < position; i++) {
			        previous = previous.next;
			    }
			    
			    Node rechange = previous.next;

			    previous.next = addNode;
			    addNode.next = rechange;
			    ++count;
		 	}		
		}
		
	
	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public Type getFirst() throws NoSuchElementException {
		if(count == 0) {           
			throw new NoSuchElementException("List is empty");
		}
		Type temp = head.data;
		return temp;
	}
	
	/**
	 * Gets the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	@Override
	public Type get(int index) throws IndexOutOfBoundsException {
		if (index > count) {
			throw new IndexOutOfBoundsException("index out of range");
		}
		Node n = head;
		for(int i = 0; i < index; i++) {
			n = n.next;
		}
		return n.data;
	}
	
	/**
	 * Removes and returns the first element from the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public Type removeFirst() throws NoSuchElementException {
		if(count == 0) { 
			throw new NoSuchElementException("List is empty");
		}
		Type temp = head.data;
		head = head.next;
		count--;
		return temp;
	}
	
	/**
	 * Removes and returns the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	@Override
	public Type remove(int index) throws IndexOutOfBoundsException {
		Type a = null;
		if (index > count || index < 0) {
			throw new IndexOutOfBoundsException("index out of range");
		}
		
		if (index == 0) {
			head = head.next;
			count--;
		} 
		else {
	
			Node curr = head;
			for  (int i = 0; i < index - 1; i++) {
				curr = curr.next; 
			}
			a = curr.data;
			curr.next = curr.next.next;
			count--;
		}
		return a;
	}

	/**
	 * Determines the index of the first occurrence of the specified element in the list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a singly-linked list.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	@Override
	public int indexOf(Type element) {
		Node n = head;
		int index = 0;
		for(int i = 0; i <= count; i++) {
			n = n.next;
			if(n.data.equals(element)) {
				i++;
				index = i;
				break;
			}
		}
		return index;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() {
		if(count == 0) {
			return true;
		}
		return false; 
	}

	/**
	 * Removes all of the elements from this list.
	 * O(1) for a singly-linked list.
	 */
	@Override
	public void clear() {
		head.next = null;
		head = null;
		count = 0;
	}
	
	/**
	 * Generates an array containing all of the elements in this list in proper sequence 
	 * (from first element to last element).
	 * O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
	@Override
	public Object[] toArray() {
		Object[] arr = new Object[count];
		int i = 0;
		Node n = head;
		while(n != null) {
			arr[i] = n.data;
			n = n.next;
			i++;
		}
		return arr;
	}

	/**
	 * @return an iterator over the elements in this list in proper sequence 
	 * (from first element to last element)
	 */
	@Override
	public Iterator<Type> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
