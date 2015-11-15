package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 * @author Iliass 
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
		
		head.next = tail;
		tail.prev = head;
		
	}

	/**
	 * @author Iliass
	 * 
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element )
	{   
		LLNode<E> newNode = new LLNode<E>(element);
		
		if(head == null){
			head = newNode;
		}
								
		// Check for NPE before
		else if (head != null){
			LLNode<E> current = head;
			/**
			 * iterate through the list up to the end of the list and add the
			 * element at the end of the list
			 */
			while(current.next!=null){
				current = current.next;
			}
			
			// set the last node's reference to the new node
			current.next = newNode;
			newNode.prev = current;
			newNode.next = null;
			
		}
		else{
			throw new NullPointerException();
		}
		
		if(element.equals(get(size))){
			return true;
		}
		else {return false ;}
			
	}

	/** Get the element at position index 
	 * @author Iliass
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		if (index == 0) return (E)this.head;
		else if(this.head == null){
			throw new IndexOutOfBoundsException();
		}
		else if((index < 0 )||(index > this.size)){
			throw new IndexOutOfBoundsException();
			
		}
		else{
			LLNode<E> newNode = head.next;
			int count = 1; 
			
				while(newNode!=null){
					if (count == index){
						return (E)newNode;
					}
					count ++;
					newNode = newNode.next;
				}
	   }
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element )	
	{
		LLNode<E>  newNode = new LLNode<E>(element);
		LLNode<E> current = head;
		LLNode<E> temp = new LLNode<E>(null);
		
		// check for NPE
		if (current!=null){
			// Traverse the list up to the index or until the end of the list
			for(int i =1; i < index && current.next!= null; i++){
				current = current.next;
			}
		}
		
		// 
		temp = current.prev;
		newNode.next = current;
		newNode.prev = current.prev;
		
	}


	/**
	 * @author Iliass
	 *  Return the size of the list 
	 * */
	public int size() 
	{
		int size = 0;
		LLNode<E> current = head.next;
		
		while(current.next != null)
		{
			size++;
			current = current.next;
		}
		
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E theData) 
	{
		this.data = theData;
		this.prev = null;
		this.next = null;
	}

}
