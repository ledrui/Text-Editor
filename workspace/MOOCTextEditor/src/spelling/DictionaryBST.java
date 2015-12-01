package spelling;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author  Iliass
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
    
   public DictionaryBST(){
		this.dict = new TreeSet<String>();

	}
	
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @author Iliass
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	return dict.add(word.toLowerCase());
    }


    /** Return the number of words in the dictionary
     * @author Iliass
     *  */
    public int size()
    {
    	
        return dict.size();
    }

    /** Is this a word according to this dictionary?
     * @author Iliass
     *  */
    public boolean isWord(String s) {
    	s = s.toLowerCase();
        return dict.contains(s);
    }

}
