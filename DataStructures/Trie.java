package DataStructures;

public class Trie {

	static int SIZE_OF_CHARACTERS = 26;

	public class Node {
		char ch;
		Node[] children;
		boolean eow;

		public Node() {
			children = new Node[SIZE_OF_CHARACTERS];
			eow = false;
		}
	}

	Node root;

	public void add(String str) {

		if (root == null)
			root = new Node();

		Node node = root;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int idx = ch - 'a';

			if (node.children[idx] == null)
				node.children[idx] = new Node();

			node = node.children[idx];
		}
		
		node.eow = true;
	}

	public boolean search(String str) {

		if (root == null)
			return false;

		Node node = root;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int idx = ch - 'a';

			if (node.children[idx] == null)
				return false;

			node = node.children[idx];
		}

		return node.eow;
	}

	public void display() {
		display(root, "");
	}

	private void display(Node node, String asf) {

		if (node == null)
			return;

		if(node.eow) {
			System.out.println(asf);
		}

		for (int i = 0; i < node.children.length; i++) {
			display(node.children[i], asf + (char)('a' + i));
		}
	}

}
