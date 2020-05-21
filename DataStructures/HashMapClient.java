package DataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findMaxFre("zxrzecstaaaaaaaaa"));
		
		
	}

	public static char findMaxFre(String str) {

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			hm.put(ch, hm.getOrDefault(ch, 0) + 1);
		}
		
		System.out.println(hm);
	
		int maxCnt = 0;
		char maxFrqChar = ' ';
//		for(char key: keyset) {
//			
//			if(hm.get(key) > maxCnt) {
//				maxCnt = hm.get(key);
//				maxFrqChar = key;
//			}
//		}
		
		for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
			if(entry.getValue() > maxCnt) {
				maxCnt = entry.getValue();
				maxFrqChar = entry.getKey();
			}
		}
		
		return maxFrqChar;

	}

}
