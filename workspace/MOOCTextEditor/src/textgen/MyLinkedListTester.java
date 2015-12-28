/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * Iliass 
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH = 10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		list1.add(109);
		
	}
	
	
	
	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 3, list1.size());
		
		// remove from empty list 
		try{
			emptyList.remove(1);
		  }
		catch(IndexOutOfBoundsException e){
			
		}
		// remove from lower bound 
		try{
			list1.remove(-1);
		  }
		catch(IndexOutOfBoundsException e){
			
		}
		// remove from upper bound
		try{
			shortList.remove(3);
		  }
		catch(IndexOutOfBoundsException e){
			
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        
		//test empty list, get should throw an exception
		try {
			emptyList.add(0);
			
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// add to shortlist
		try {
			
			System.out.println("ShortList size before: "+ shortList.size());
			shortList.add("C");
			System.out.println("C added to ShortList. new size: "+ shortList.size());
			for(int i = 0; i < shortList.size(); i++ ){
				System.out.println("ShortList's "+i+"th element :"+ shortList.get(i));
			}
			
		}
		catch(IndexOutOfBoundsException e){
			
		}
		
		//test add null value
		try {
			list1.add(null);
			
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// test on list1 size
		try
		{
			System.out.println("List1 size: "+list1.size());
			//fail("fail to check the size");
			
		}
		catch(IndexOutOfBoundsException e){
			
		}
		
		assertEquals("size: check list1 size is correct ", 4, list1.size());
		
		// test on empty list, throw exception
		try
		{
			System.out.println("Empty list Size: "+emptyList.size());
		}
		catch(IndexOutOfBoundsException e){
			
		}
		assertEquals("size: check emptyList size is correct ", 0, emptyList.size());
		// Test on shortList
		try
		{
			System.out.println("Shorlist Sisze : "+shortList.size());
			
		}
		catch(IndexOutOfBoundsException e){
			
		}
		assertEquals("size: check shortList size is correct ", 2, shortList.size());
		
		// Test on LongList
		try
		{
			System.out.println("Longer list: "+longerList.size());
			
		}
		catch(IndexOutOfBoundsException e){
			
		}
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		// test lower bound
        try{
        	list1.add(-1, 5);
        }
		catch(IndexOutOfBoundsException e){
			
		}
     // test upper bound
        try{
        	list1.add(list1.size(), 5);
        }
		catch(IndexOutOfBoundsException e){
			
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		try{
			int a = list1.set(1, 100);
			assertEquals("set: check  is correct ", 21, a);
			assertEquals("Set: check element 0 is correct ", (Integer)100, list1.get(1));
			assertEquals("Set: check size is correct ", 4, list1.size());
		}
		catch(IndexOutOfBoundsException e){
			
		}
		// test upper bound
		 try{
	        	list1.set(list1.size(), 5);
	        }
			catch(IndexOutOfBoundsException e){
				
			}
		// test lower bound
		 try{
	        	list1.set(-1, 5);
	        }
			catch(IndexOutOfBoundsException e){
				
			}
	    
	    
	}
	
	
}
