package DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenericTree {

	public class Node {
		int data;
		List<Node> children;

		public Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.data + "";
		}
	}

	Node root;
	int size;

	public GenericTree(int[] arr) {

		Stack<Integer> entries = populateStack(arr);

		this.root = populateGetChild(entries);
	}

	private Node populateGetChild(Stack<Integer> entries) {

		Node node = new Node(entries.pop());
		this.size++;

		while (entries.peek() != -1) {
			node.children.add(populateGetChild(entries));
		}

		entries.pop();

		return node;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {

		System.out.print(node.data + " children are ");
		System.out.println(node.children);

		for (Node child : node.children)
			display(child);

	}

	private Stack<Integer> populateStack(int[] arr) {

		Stack<Integer> st = new Stack<Integer>();

		for (int i = arr.length - 1; i >= 0; i--)
			st.push(arr[i]);

		return st;
	}

	public int size() {
		return this.size;
	}

	public int size2() {

		if (this.root == null)
			return 0;

		return size2(this.root);
	}

	private int size2(Node node) {

		int mySize = 1;

		for (Node child : node.children)
			mySize += size2(child);

		return mySize;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		int max = node.data;

		for (Node child : node.children) {
			max = Math.max(max, max(child));
		}

		return max;
	}
	
	public class diapair{
		int dia;
		int height;
	}
	
	public int findDiameter() {
		
		return findDiameter(root).dia;
	}
	
	private diapair findDiameter(Node node) {
		
		diapair pair = new diapair();
		int max = Integer.MIN_VALUE, smax = Integer.MIN_VALUE;
		for(Node child: node.children) {
			
			diapair cp = findDiameter(child);
			if(cp.height > pair.height)
				pair.height = cp.height + 1;
			
			if(cp.dia > pair.dia)
				pair.dia = cp.dia;
			
			if(cp.height > max) {
				smax = max;
				max = cp.height;
			} else if(cp.height < max && cp.height > smax) {
				smax = cp.height;
			}else {
				// do nothing
			}
			
		}
		
		if(node.children.size() < 2) {
			pair.dia = pair.height;
			return pair;
		}
		
		int myDia = max + smax + 2;
		if(myDia > pair.dia)
			pair.dia = myDia;
		
		return pair;
	
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {

		int maxChildH = 0;

		for (Node child : node.children) {
			maxChildH = Math.max(maxChildH, height(child));
		}

		return maxChildH + 1;
	}

}
