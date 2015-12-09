package spelling;

import org.junit.Before;

public class MyTester {
	
	 public static String dictFile = "data/words.small.txt"; 

	
		
		
	
	public static void main(String[] argv){ 
		
		
		AutoCompleteDictionaryTrie largeDict = new AutoCompleteDictionaryTrie();
		AutoCompleteDictionaryTrie MyDict = new AutoCompleteDictionaryTrie();
		
		DictionaryLoader.loadDictionary(largeDict, dictFile);
		
		MyDict.addWord("Hello");
		MyDict.addWord("HElLo");
		MyDict.addWord("help");
		MyDict.addWord("he");
		MyDict.addWord("hem");
		MyDict.addWord("hot");
		MyDict.addWord("hey");
		MyDict.addWord("a");
		MyDict.addWord("subsequent");
		
	    System.out.println(MyDict.addWord("ad") );
		System.out.println("adding duplicate "+MyDict.addWord("ad") );
		System.out.println("adding empty list "+MyDict.addWord("") );
		System.out.println("adding hello "+MyDict.addWord("Hello") );
		System.out.println(MyDict.addWord("add") );
		System.out.println(MyDict.addWord("actual") );
		MyDict.addWord("more-word");
		
		MyDict.printTree();
		System.out.println("Completion list "+ MyDict.predictCompletions("hel", 10));
		System.out.println("Completion list empty-word "+ MyDict.predictCompletions("", 10));
		
		System.out.println(" isWord test on ad "+MyDict.isWord("ad") );
		System.out.println(" isWord test on hello "+MyDict.isWord("hello") );
		System.out.println(" isWord test on fake word "+MyDict.isWord("Fake word") );
		System.out.println(" isWord test on empty word "+MyDict.isWord("") );
		
		
		
	}

}
