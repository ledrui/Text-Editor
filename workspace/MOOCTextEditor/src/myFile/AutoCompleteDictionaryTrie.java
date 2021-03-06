package spelling;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author Iliass 
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size = 0;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
    
    /** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. 
	 * @author Iliass
	 * */
    private int depth = 0; // longest word
    public boolean addWord(String text) {
    	
    	if(isWord(text)){ return false; }
    	int wdepth = 0;   
    	char word[] = text.toLowerCase().toCharArray();
        TrieNode currentNode = root;
        
        for (char ch : word) {
        	Character c = (Character)ch;
        	currentNode = root.getChild(c);
        	if(currentNode == null){
        		currentNode = new TrieNode(c.toString());
        		currentNode.insert(c);
        	}
            wdepth++;
        }
        if (currentNode.endsWord() == false) { //  only add new words....
        	currentNode.setEndsWord(true);
            size++;
            if (wdepth > depth) {
                depth = wdepth;
            }
        }      
        
        return currentNode.endsWord();        	
    }
    
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    return size;	    		
	}
	
	
	/** Returns whether the string is a word in the trie */
	
	public boolean isWord(String s) 
	{
	    s = s.toLowerCase();
	    TrieNode tempNode = searchNode(s);
	    
	    if(tempNode != null){
	           return tempNode.endsWord();  
	    }
	    	return false;
	   }
	
	/**
	 *  search a node down 
	 *  Return the node that have the last Charater of the
	 * @param String word
	 * 
	 * */
	
	public TrieNode searchNode( String prefix){
		// Find the node which represents the last letter of the prefix.
			if(prefix.isEmpty()){
			 return null;	
			}
			char[] prefixChar = prefix.toCharArray();	
			TrieNode lastNode = root;
            for (Character c : prefixChar ){
				while(lastNode !=null){
				lastNode = lastNode.getChild(c);
				}
			}	
				
			return lastNode;	
	}

	/**
	 * get word of the prefix
	 * @param prefix
	 * return list of String containing
	 * */
	
	
	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */
	//@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
    	 List <String> completionList = new LinkedList<String>();
    	 /*Can't do much with an empty String*/
    	 if(prefix.length() == 0){
    		 return completionList;
    	 }
    	 
    	 /*Get node by prefix*/
    	 TrieNode currentNode = searchNode(prefix);
    	 if(currentNode == null){
    		 return completionList;
    	 }
    	 
    	 Queue <TrieNode> q = new LinkedList< TrieNode >();
    	 q.add(currentNode);
    	 
    	 int count = 0;
    	 while(!q.isEmpty() && count < numCompletions ){
    		 TrieNode curr = q.remove();
    		 if(isWord(curr.getText()) ){
    			 completionList.add(curr.getText());
    			 
    			 // walk down and Add all his Children
    			 TrieNode next = null;
    	 	       for (Character c : currentNode.getValidNextCharacters()) {
    	 	 			next = currentNode.getChild(c);
    	 	 			completionList.add(next.getText());
    	 	 		}
	    		 
	    		 }
    		  count++;
    		 }
    		 
    		     	 
    	 System.out.println(""+ completionList);
         return completionList;
     }

     /**
 	 * @author Iliass
 	 * return the all the children of the Trie
 	 * */
 	 public ArrayList<TrieNode> getChildren(TrieNode theNode ) {
 		
 	        ArrayList<TrieNode> nodesList = new ArrayList<TrieNode>();
 	        
 	       TrieNode next = null;
 	       for (Character c : theNode.getValidNextCharacters()) {
 	 			next = theNode.getChild(c);
 	 			nodesList.add(next);
 	 		}
 	        return nodesList;
 	    }
     
 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}	
}