package DataStructures;

import java.util.Collections;
import java.util.PriorityQueue;

public class TrieClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie trie = new Trie();
		
		String[] strs = {"dog", "doge", "date", "dataee", "god", "goat", "get"};
		
		for(String str: strs)
			trie.add(str);
		
		trie.display();
		System.out.println();
		System.out.println(trie.search("date"));
		System.out.println(trie.search("dati"));
		System.out.println(trie.search("da"));
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		pq.add(5);
		pq.add(6);
		pq.add(1);
		pq.add(4);
		pq.add(3);
		
		System.out.println(pq.peek());
		
		pq.remove();
		System.out.println(pq.peek());
		
		
		
	}

}
