package DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanEncoder {

	class Node implements Comparable<Node> {
		char data;
		int wt;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.wt - o.wt;
		}
	}

	HashMap<Character, String> encoder = new HashMap<Character, String>();
	HashMap<String, Character> decoder = new HashMap<String, Character>();

	
	public void display() {
		System.out.println("encoder");
		System.out.println(encoder);
		System.out.println();
		System.out.println("decoder");
		System.out.println(decoder);
	}
	
	public HuffmanEncoder(String str) {

		java.util.HashMap<Character, Integer> freq = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Node> pq = new PriorityQueue<HuffmanEncoder.Node>();
		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {

			Node node = new Node();
			node.data = entry.getKey();
			node.wt = entry.getValue();

			pq.add(node);
		}

		while (pq.size() > 1) {
			Node one = pq.remove();
			Node two = pq.remove();

			Node node = new Node();
			node.data = '\0';
			node.wt = one.wt + two.wt;
			node.left = one;
			node.right = two;

			pq.add(node);
		}

		populateEncoderDecoder(pq.remove(), "");
	}

	public void populateEncoderDecoder(Node node, String asf) {

		if (node == null)
			return;

		if (node.left == null && node.right == null) {

			encoder.put(node.data, asf);
			decoder.put(asf, node.data);
		}

		populateEncoderDecoder(node.left, asf + "0");
		populateEncoderDecoder(node.right, asf + "1");
	}

	public String encode(String str) {

		String rv = "";

		for (int i = 0; i < str.length(); i++)
			rv += encoder.get(str.charAt(i));

		return rv;
	}

	public String decode(String str) {
		String rv = "";

		String qsf = "";
		for (int i = 0; i < str.length(); i++) {
			
			qsf += str.charAt(i);
			
			if(decoder.containsKey(qsf)) {
				rv += decoder.get(qsf);
				qsf = "";
			}
		}

		return rv;
	}

}
