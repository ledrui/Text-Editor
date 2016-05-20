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
		size = 0;	
		
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
	public boolean add(E element ) throws NullPointerException
	{   
			LLNode<E> newNode = new LLNode<E>(element);
			//LLNode<E> temp;
			if(element != null){
				
				newNode.prev = tail.prev;
				newNode.next = newNode.prev.next;
				newNode.prev.next = newNode;
				tail.prev = newNode;
				
				size++;
			}
			else{
				throw new NullPointerException("List cannot store null value");
			}
			if(tail.data == element){
				return true;
			}
		return false;
		
	}

	
	/** Get the element at position index 
	 * @author Iliass
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
		

	public E get(int index) throws IndexOutOfBoundsException
	{
		LLNode<E> current;
		if(index == 0) return head.next.data;
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		if(!isEmpty()){
			if(head.data == null){
				current = head.next ;
			}
			else{
				current = head;
			}
			//current = head;
			int counter = 0;
			while(current != null){
				if(counter == index) return current.data;
				
				counter++;
				current = current.next;
			}
			return null;
		}
		throw new IndexOutOfBoundsException();
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) throws IndexOutOfBoundsException
	{
		// check for exceptions
		if(index < 0 || index > size()){
			
			throw new IndexOutOfBoundsException("Enter the right index "+ this.size);
		}
		if(element == null){
			throw new NullPointerException("List cannot store null value");
		}
		
		LLNode<E>  newNode = new LLNode<E>(element);
		LLNode<E> current ;
		LLNode<E> temp ;
		if(head.data == null){
			current = head.next ;
		}
		else{
			current = head;
		}
		
		//check for empty 
		
		if(index == 0){
			
			newNode.next = current;
			newNode.prev = current.prev;
			newNode.next.prev = newNode;
			head.next = newNode;
			size++;
		}
		else{
			// Traverse the list up to the index or until the end of the list
			for(int i = 0; i < index && current.next!= null; i++){
				current = current.next;
			}
			
			// 
			newNode.next = current;
			newNode.prev = newNode.next.prev;
			newNode.next.prev = newNode;
			newNode.prev.next = newNode;
			size++;
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
	public E remove(int index) throws IndexOutOfBoundsException
	{
		if( index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException();
		}else{
		
			LLNode<E> current;
			LLNode<E> prev ;
			LLNode<E> temp ;
			if(head.data == null){
				current = head.next ;
				prev  = current.prev;
			}
			else{
				current = head;
				prev  = current.prev;
			}
			
			int count = 0;
			if(!isEmpty()){
				if(index == 0){
					temp = current.next;
					head.next = current.next;
					temp.prev = head;
					size--;
					return current.data;
					
				}
				
				while(current!=null){
					if(count == index){
						temp = current.next;
						prev.next = current.next;
						temp.prev = prev;
						size--;
						return current.data;
					}
					prev  = current;
					current = current.next;
					count++;
				}
			}
			
			return null;
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
		
		if(index < 0 || index > size-1 ){
			throw new IndexOutOfBoundsException();
		}
		else if(element == null){
			throw new NullPointerException("List cannot store null value");
		}
		else{
			E theData = null;
			if(index == 0){
				
				theData =  head.next.data;
				 head.next.data = element;
			}
			LLNode<E> current = head.next;
			int count = 0;
			while(current!=null){
				if(count == index) {
					theData = current.data;
					current.data = element; 
					return theData;
				}
				
				// otherwise keep running
				count ++;
				current = current.next;
			}
			
			return null;
		}
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
