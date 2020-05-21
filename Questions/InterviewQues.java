package Questions;

import java.util.Stack;

public class InterviewQues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isReverse(Node one, Node two) {

		if (one == null && two == null)
			return true;

		if (one == null || two == null)
			return false;

		Stack<Integer> st = new Stack<>();

		Node head1 = one;
		Node head2 = two;

		do {
			st.push(one.data);
			one = one.next;
		} while (one != head1);

		do {

			if (two.data != st.peek())
				return false;

			st.pop();
			two = two.next;
			
		} while (two != head2);

		return true;
	}

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

}
