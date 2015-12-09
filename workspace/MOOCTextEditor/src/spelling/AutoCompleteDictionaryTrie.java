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
    /** Add a word to the trie
     * @param String containing the word */
   // public boolean addWord2(String word) {
    	//if(isWord(word)){ return false; }
        //return addWord(word.toLowerCase().toCharArray());
        //return addWord1(word);
   // }
    /** Internal method to add a word to the trie
     * @param Char array containing the word to be added */
    private boolean addWord1(String text) {
    	char[] word = text.toCharArray();
        
        if(word.length == 0 ){
        	return false;
        }
        /* If we don't already have a word that starts with this char, add the char */
        TrieNode currentNode;
        Set keySet = root.getValidNextCharacters();
        		Character ch = word[0];
        if ( !keySet.contains(word[0]) ) {
            //currentNode = new TrieNode(ch.toString());
            currentNode = root.insert(word[0]);

        } else {
            /* Otherwise get the node that contains char */
            currentNode = root.getChild(word[0]);
        }

        for ( int i = 1; i < word.length; i++ ) {
            /* If a child has this char, walk down to the next level */
            if (containsChar(currentNode, word[i]) ) {
                currentNode = currentNode.getChild(word[i]);
            } else {
                /* Otherwise add the char */
                currentNode.insert(word[i]);
                currentNode = currentNode.getChild(word[i]);
            }
        }

        /* We are at the end of the word */
        currentNode.setEndsWord(true);
        size++;
        return currentNode.endsWord();
    }
    
   ////////////////////////////////////////////////// 
    public boolean addWord(String word)	
    {		
    	if(word.isEmpty()){
    		return false;
    	}
        boolean result = false;
        TrieNode prevN = root;
        TrieNode nextN = null;
    	word = word.toLowerCase();
    	for (char ch:word.toCharArray()){
    		nextN = prevN.insert(ch);
    		if (nextN==null){
    			nextN = prevN.getChild(ch);
    		}
    		prevN = nextN;
    	}
    	if (!nextN.endsWord()) {
    		nextN.setEndsWord(true);
    		size++;result = true;
    	}
    return result;
    }
    
	 /** Whether this node's children contain character
     * @param The character to check
     * @return Boolean */
    public boolean containsChar(TrieNode Node, char character) {
    	
        Set keySet = Node.getValidNextCharacters();
        if(keySet.contains(character)){
        	return true;
        }else
           return false;
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
		if(s.isEmpty()){
			return false;
		}
	    s = s.toLowerCase();
	    TrieNode tempNode = getNodeByPrefix(s);
	    if(tempNode != null){
	    	return tempNode.endsWord();   
	    }else{
	    	return false;
	    }
	    	
	   }
	
	/**
	 *  search a node down 
	 *  Return the node that have the last Charater of the
	 * @param String word
	 * 
	 * */
	
	/** Return the node at the end of the prefix
     * @param String containing the prefix
     * @return TrieNode or null if nothing found */
    private TrieNode getNodeByPrefix(String prefix) {
        char[] pre = prefix.toCharArray();
        TrieNode currentNode;

        /* If root doesn't have the char, return null */
        if ( root.getChild(pre[0]) == null || pre.length == 0 ) {
            return null;
        } else {

            /* Otherwise get the node that contains char */
            currentNode = root.getChild(pre[0]);
        }

        for ( int i = 1; i < pre.length; i++ ) {
            /* If we don't have the char, return null */
            if ( currentNode.getChild(pre[i]) == null) {
                return null;
            } else {
                /* Otherwise keep walking the trie */
                currentNode = currentNode.getChild(pre[i]);
            }
        }

        /* We are at the end of the prefix, return the node */
        return currentNode;
    }


	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */
	//@Override
	List <String> completionTestList = new LinkedList<String>();
	Queue <TrieNode> testQ = new LinkedList< TrieNode >();
	
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
    	 
    	 char[] ch=(prefix.toLowerCase()).toCharArray();
    	 TrieNode curr=root;
    	 int flag=0;
    	 for(char c:ch){
    		 if(curr.getChild(c)!=null){
    			 curr=curr.getChild(c);
    		 }else flag=1;	 
    	   }
    	 if(flag==1) return completionList; // return an empty list
    	 
    	 //TrieNode curr = getNodeByPrefix(prefix);
    	 System.out.println("The last node of the prefix: "+curr.getValidNextCharacters() +" the prefix:  "+curr.getText());
    	 
    	 //if(curr == null) return completionList; // return an empty list
    	 
    	 Queue<TrieNode> q = new LinkedList<TrieNode>();
    	 q.add(curr);
    	 while(!(q.isEmpty())&&numCompletions>0){
    		 TrieNode tempNode = q.remove();
    		 if(tempNode != null){
    			 completionList.add(tempNode.getText());
    			 numCompletions--;
    			 for(char s:tempNode.getValidNextCharacters()){
    				 q.add(tempNode.getChild(s));
    			 }
    		    
    		 }
    	 }
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