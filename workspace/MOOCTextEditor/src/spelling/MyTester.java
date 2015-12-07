package spelling;

import org.junit.Before;

public class MyTester {
	
	private String dictFile = "data/words.small.txt"; 

	AutoCompleteDictionaryTrie emptyDict; 
	AutoCompleteDictionaryTrie smallDict;
	AutoCompleteDictionaryTrie largeDict;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		emptyDict = new AutoCompleteDictionaryTrie();
		smallDict = new AutoCompleteDictionaryTrie();
		largeDict = new AutoCompleteDictionaryTrie();

		smallDict.addWord("Hello");
		smallDict.addWord("HElLo");
		smallDict.addWord("help");
		smallDict.addWord("he");
		smallDict.addWord("hem");
		smallDict.addWord("hot");
		smallDict.addWord("hey");
		smallDict.addWord("a");
		smallDict.addWord("subsequent");
		
		DictionaryLoader.loadDictionary(largeDict, dictFile);
	}
	
	public static void main(String[] argv){
		AutoCompleteDictionaryTrie MyDict = new AutoCompleteDictionaryTrie();
		
		System.out.println(MyDict.addWord("ad") );
		System.out.println("adding duplicate "+MyDict.addWord("ad") );
		System.out.println("adding empty list "+MyDict.addWord("") );
		System.out.println(MyDict.addWord("add") );
		MyDict.addWord("moreword");
		
		MyDict.printTree();
		System.out.println("Completion list"+ MyDict.predictCompletions("mo", 3));
		
	}

}
