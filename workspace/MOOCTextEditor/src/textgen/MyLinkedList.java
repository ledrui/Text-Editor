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
		size = 0;
		
		head.next = tail;
		tail.prev = head;
		
	}

	/**
	 * @author Iliass
	 * 
	 * Return a Node at a particular index of the list
	 * 
	 * @param index 
	 * */
	public LLNode<E> getNode(int index){
		LLNode<E> current = new LLNode<E>(null);
		// forward traversal
		if(index < size/2){
			current = head.next;
			int i=0;
			while(i < index ){
				current = current.next;
				i++;
			}
		}else{
			current = tail.prev;
			int j = size;
			while(j > index ){
				current = current.prev;
				j--;
			}
		}
		
		return current;
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
			size++;
		}
								
		// Check for NPE before
		else if (head != null){
			LLNode<E> current = head;
			/**
			 * traverse the list up to the end of the list and add the
			 * element at the end of the list
			 */
			while(current.next!=null){
				current = current.next;			
			}
			
			// set the last node's reference to the new node
			current.next = newNode;
			newNode.prev = current;
			newNode.next = null;
			
			// update size
			size ++;
			
		}
		else{
			throw new NullPointerException();
		}
		
		if(element.equals(this.get(size))){
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
		if((index < 0 )||(index > this.size-1)){
			throw new IndexOutOfBoundsException();
			
		}
		else{
			return getNode(index).data;
	   }
		
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
			for(int i =1; i < index && current.next!= null; i++){
				current = current.next;
			}
			
			// 
			temp = current.prev;
			current.prev = newNode;
			newNode.prev = temp;
			temp.next = newNode;
			newNode.next = current;
			
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
		
		int kthNode = 1;
		
		LLNode<E> current  = head;
		LLNode<E> temp  = new LLNode<E>(null);
		
		if(index == 0){
			head = current.next;
			head.prev = null;
			current.next = null;
			current.prev = null;
			size--;
			System.out.println("deleted: "+current.data);
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
		
		LLNode<E> current = getNode(index);
		E data = current.data;
		current.data = element;
		
		return data;
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

	public LLNode(E theData) 
	{
		this.data = theData;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E theData, LLNode prev, LLNode next){
		this.data = theData;
		this.prev = prev;
		this.next = next;
	}

}
