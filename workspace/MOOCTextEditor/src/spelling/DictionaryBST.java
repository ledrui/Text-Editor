package spelling;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
    // TODO: Implement the dictionary interface using a TreeSet.  
   public DictionaryBST(){
		this.dict = new TreeSet<String>();

	}
	
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	if(isWord(word)){
	    	word = word.toLowerCase();
	        boolean temp = dict.add(word);
	        // System.out.print(temp);
	        return true;
	     }
    	return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	s = s.toLowerCase();
        return isWord(s);
    }

}
