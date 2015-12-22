package textgen;

import java.util.AbstractList;
import java.util.NoSuchElementException;


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
		
		head.next = tail;
		tail.prev = head;
		
	}
	
	/*check if list is Empty*/
	public boolean isEmpty(){
		return (head == null);
	}

	/**
	 * @author Iliass
	 * 
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element )
	{   
			
	}

	
	/** Get the element at position index 
	 * @author Iliass
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
		

	public E get(int index) throws IndexOutOfBoundsException
	{
		LLNode<E> current = new LLNode<E>(null);
		current = head;
		int counter = 0;
		for(current = head; current.next!= null; current = current.next){
			if(counter == index) return current.data;
			
			counter++;
			if(counter > size) {
				//throw  IndexOutOfBoundsException;
			}
		}
	
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) throws IndexOutOfBoundsException
	{
		// check for exceptions
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E>  newNode = new LLNode<E>(element);
		LLNode<E> current = head;
		LLNode<E> temp = new LLNode<E>(null);
		
		// check for NPE
		if (current!=null){
			// Traverse the list up to the index or until the end of the list
			for(int i = 0; i < index && current.next!= null; i++){
				current = current.next;
			}
			
			// 
			temp = current.prev;
			current.prev = newNode;
			newNode.prev = temp;
			temp.next = newNode;
			newNode.next = current;
			System.out.println("Added: "+ current.data + "at index" + index);
			// Increment size;
			size++;
		}
		else{
			throw new IndexOutOfBoundsException();
		}				
	}


	/**
	 * @author Iliass
	 *  Return the size of the list 
	 * */
	public int size() 
	{
		LLNode<E> tempNode = head;
		size = 0;
		while(tempNode.next != null){
			size++;
			tempNode = tempNode.next;
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
		// Check for Exceptions
		if(size == 0) throw new  NoSuchElementException();
		
		if(index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		
		
		LLNode<E> current  = head;
		LLNode<E> temp  = new LLNode<E>(null);
		
		if(index == 0){
			head = current.next;
			head.prev = null;
			current.next = null;
			current.prev = null;
			size--;
			System.out.println("deleted: "+ current.data);
			return (E) current.data;
		}
		else{
			
			// Traverse the list
			while(kthNode != index){
				current = current.next;
				
				kthNode++;
			}
			if (current.next == null){
				
				current.prev.next = null;
				current.prev = null;
				size--;
				
				return (E) current.data;
			}
			else{
				current.prev.next = current.next;
				current.next.prev = current.prev;
				size--;
				System.out.println("deleted: "+ current.data);
				
				return (E) current.data;
				
			}
		}
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
		if(index < 0 || index > size-1 ) throw new IndexOutOfBoundsException();
		
		LLNode<E> current = new LLNode<E>(element);
		
		
		return current.data;
	}   
	
		 
	 public String toStirng(){
		    String output = "";
		    if(head!=null){
				LLNode<E> current = head.next;
				
				while(current.next != null)
				{
					output += "["+ current.data.toString() + "]" ;
					current = current.next;
				}
		    }
		    return output;
	 }
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E Data) 
	{
		this.data = Data;
		this.prev = null;
		this.next = null;
	}
	

}
