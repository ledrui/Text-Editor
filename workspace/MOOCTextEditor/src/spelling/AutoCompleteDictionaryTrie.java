package spelling;

import java.util.List;
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
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
		if (word.isEmpty()){
			return false;
		}
		
		HashMap<Character, TrieNode> children = root.getChildren();
		TrieNode currentNode = null;
		
		for(int i = 0; i < word.length(); i++){
			Character currChar = word.charAt(i);
			
			
			if(children.containsKey(currChar)){
				currentNode = root.getChild(currChar);
			}else{
				/* the current char doesn't already exist in the trie 
				 * create a new node to insert it*/
				currentNode = new TrieNode(currChar.toString());
				children.put(currChar, currentNode );			
				}
			children = currentNode.getChildren();
			
			// set isWord
			if(i == word.length()-1){
				currentNode.setEndsWord(true);
				// update size
				size++;
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
	    
	    if(tempNode != null && tempNode.endsWord())
	    	return true;
	    else
	    	return false;
	   }
	
	/**
	 *  search a node down 
	 * @param String word
	 * 
	 * */
	public TrieNode searchNode( String s){
		HashMap children = root.getChildren();
		TrieNode t = null;
		for(int i = 0; i < s.length(); i++){
			Character c = s.charAt(i);
			if(children.containsKey(c)){
				t = (TrieNode) children.get(c);
				children = t.getChildren();
			}else{
				return null;
			}
		}
		return t;
	}

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
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
    	 
         return null;
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