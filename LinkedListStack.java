/*
 * @author Sarthak Goyal
 */
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Stack<E> {
	
	private SinglyLinkedList<E> SLL = new SinglyLinkedList<E>();
	
	public LinkedListStack() {
	}
	/**
	 * Removes all of the elements from the stack.
	 */
	@Override
	public void clear() {
		SLL.clear();
	}

	/**
	 * @return true if the stack contains no elements; false, otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return SLL.isEmpty();
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	
	@Override
	public E peek() throws NoSuchElementException {
		return SLL.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E pop() throws NoSuchElementException {
		return SLL.removeFirst();
	}

	/**
	 * Adds a given element to the stack, putting it at the top of the stack.
	 * 
	 * @param element - the element to be added
	 */
	@Override
	public void push(E element) {
		SLL.addFirst(element);
	}

	/**
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() {
		return SLL.size();
	}

	
}
