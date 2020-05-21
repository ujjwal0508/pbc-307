package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

import DataStructures.BinaryTree.l2lpair;

public class BinaryTree {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		Node(int data) {
			this.data = data;
		}
	}

	public static class Pair {
		Node node;
		int state;

		Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static Node createTree(int arr[], int n) {
		// Your code here
		Node[] nodes = new Node[n];

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
		}

		int rootIdx = -1;

		for (int i = 0; i < arr.length; i++) {

			if(arr[i] == -1)
				rootIdx = i;
			else {
				
				Node parent = nodes[arr[i]];
				if(parent.left == null) {
					parent.left = nodes[i];
				}else
					parent.right = nodes[i];
			}
		}

		return nodes[rootIdx];
	}

	public static class l2lpair {
		int l2l;
		int n2l;
	}

	public static int maxPathSum(Node root) {
		// your code here

		return maxPathSumHelper(root).l2l;
	}

	private static l2lpair maxPathSumHelper(Node node) {

		if (node == null) {
			l2lpair base = new l2lpair();
			base.n2l = Integer.MIN_VALUE;
			base.l2l = Integer.MIN_VALUE;
			return base;
		}

		if (node.left == null && node.right == null) {
			l2lpair base = new l2lpair();
			base.n2l = node.data;
			base.l2l = Integer.MIN_VALUE;
			return base;
		}

		l2lpair lans = maxPathSumHelper(node.left);
		l2lpair rans = maxPathSumHelper(node.right);

		l2lpair mypair = new l2lpair();

		mypair.n2l = Math.max(lans.n2l, rans.n2l) + node.data;

		int myl2l = lans.n2l + node.data + rans.n2l;

		mypair.l2l = Math.max(Math.max(lans.l2l, rans.l2l), myl2l);

		return mypair;
	}

	public static Node construct(Integer[] arr) {
		Node root = new Node(arr[0], null, null);
		Pair rtp = new Pair(root, 1);

		Stack<Pair> st = new Stack<>();
		st.push(rtp);

		int idx = 0;
		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == 1) {
				idx++;
				if (arr[idx] != null) {
					top.node.left = new Node(arr[idx], null, null);
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				} else {
					top.node.left = null;
				}

				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != null) {
					top.node.right = new Node(arr[idx], null, null);
					Pair rp = new Pair(top.node.right, 1);
					st.push(rp);
				} else {
					top.node.right = null;
				}

				top.state++;
			} else {
				st.pop();
			}
		}

		return root;
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data + "";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static class pair {
		int dist;
		boolean found;

	}

	public static int printKNodesFar(Node node, int data, int k) {
		// write your code here
		if (node == null)
			return -1;

		if (node.data == data) {

			printKDown(node.left, k - 1);
			printKDown(node.right, k - 1);
			return k - 1;
		}

		int lp = printKNodesFar(node.left, data, k);
		int rp = printKNodesFar(node.right, data, k);

		if (lp >= 0) {

			if (lp == 0) {
				System.out.println(node.data);
			}
			printKDown(node.right, lp - 1);

			return lp - 1;
		} else if (rp >= 0) {

			if (rp == 0) {
				System.out.println(node.data);
			}

			printKDown(node.left, rp - 1);

			return rp - 1;
		} else {

			return -1;
		}

	}

	public static void printKDown(Node node, int k) {

		if (node == null)
			return;

		if (k == 0) {
			System.out.println(node.data);
			return;
		}

		printKDown(node.left, k - 1);
		printKDown(node.right, k - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			if (values[i].equals("n") == false) {
				arr[i] = Integer.parseInt(values[i]);
			} else {
				arr[i] = null;
			}
		}

		int data = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		Node root = construct(arr);
		printKNodesFar(root, data, k);
	}
}
