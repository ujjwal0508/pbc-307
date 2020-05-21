package Questions;

public class RandomLLClone {

	public static class Node {

		int data;
		Node next;
		Node random;

		public Node(int d) {
			this.data = d;
		}
	}

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		head.random = head.next.next;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head.next;
		
		display(head);
		Node clone = createClone(head);
		display(clone);
	}
	
	public static void display(Node node) {
		
		System.out.println("start");
		
		while(node != null) {
			
			System.out.println(node.data + "," + node.random.data + "," + node);		
			node = node.next;
		}
		
		System.out.println("end");
		System.out.println();
	}

	public static Node createClone(Node node) {

		createCopy(node);
		setRandom(node);
		return breakLl(node);
	}

	public static void createCopy(Node node) {

		while (node != null) {
			Node nn = node.next;

			Node newNode = new Node(node.data);
			node.next = newNode;
			newNode.next = nn;

			node = nn;
		}

	}

	public static void setRandom(Node node) {

		// here i know size will be even for sure
		while (node != null) {

			// THE MOST IMPORTANT LINE OF THIS PROGRAM
			node.next.random = node.random.next;
			node = node.next.next;
		}

	}

	public static Node breakLl(Node node) {

		Node dummy = new Node(0);
		Node clonePointer = dummy;

		// here i know size will be even for sure
		while (node != null) {
			
			Node cloneNode = node.next;
			Node nn = node.next.next;
			
			node.next = nn;
			cloneNode.next = null;
			clonePointer.next = cloneNode;
			clonePointer = clonePointer.next;
			
			node = nn;
		}

		return dummy.next;
	}

}
