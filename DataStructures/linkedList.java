package DataStructures;

public class linkedList {

	private Node head;
	private int size;
	private Node tail;

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	// O(1)
	public void add(int val) {

		if (this.head == null) {
			this.head = new Node(val);
			this.tail = head;
			this.size++;
			return;
		}

		Node node = new Node(val);
		this.tail.next = node;
		this.size++;
		this.tail = tail.next;
	}

	// O(n)
	public void display() {

		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + ",");
			temp = temp.next;
		}
		System.out.println(".");
	}

	// O(1)
	public int removeFirst() {

		if (this.head == null) {
			return -1;
		} else if (this.head == this.tail) {
			int rv = this.head.data;
			this.head = null;
			this.tail = null;
			this.size--;
			return rv;

		} else {
			int rv = this.head.data;
			this.head = this.head.next;
			this.size--;
			return rv;
		}

	}
	
	
	
	public void kReverse(int k) {
		this.head = kReverse(head, k);
	}
	
	private Node kReverse(Node node, int k) {
		
		if(!isLargerThanK(node, k))
			return node;
		
		Node prev = null, nn = null;
		Node tail = node;
		int cnt = k;
		while(cnt -- > 0) {
			nn = node.next;
			
			node.next = prev;
			prev = node;
			node = nn;
		}
		
		tail.next = kReverse(node, k);
		return prev;
	}
	
	
	
	public void reverseDataRec() {
		
		reverseDataRec(head,head);
	}
	
	private Node reverseDataRec(Node node, Node n2u) {
		
		if(node.next == null) {
			n2u.data = node.data;
			return n2u.next;
		}
		
		int newData = node.data;
		n2u = reverseDataRec(node.next, n2u);
		n2u.data = newData;
		
		return n2u.next;
	}
	
	
	private boolean isLargerThanK(Node node, int k) {
		int rv = 0;
		
		while(node!=null) {
			rv++;
			node = node.next;
			
			if(rv >= k)
				return true;
//			
		}
		
		return false;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public int getFirst() {
		if (this.head == null) {
			return -1;

		}

		return this.head.data;
	}

	public int getLast() {
		if (this.tail == null)
			return -1;

		return this.tail.data;
	}

	public int getAt(int pos) {

		if (this.head == null)
			return -1;

		Node temp = this.head;
		while (temp != null && pos > 0) {
			temp = temp.next;
			pos--;
		}

		if (temp == null)
			return -1;

		return temp.data;

	}
	

	public void reverseLlRec() {
		
		Node temphead = this.head;
		this.head = this.tail;
		Node newTail = reverseLlRec(temphead);
//		newTail.next = null;
		this.tail = newTail;
	}
	
	private Node reverseLlRec(Node node) {
		
		if(node.next == null)
			return node;
		
		Node rv = reverseLlRec(node.next);
		rv.next = node;
		node.next = null;
		return node;
	}
	
	public void reverseLlRec2() {
		reverseLlRec2(head, head.next);
		
		Node temp = head;
		head = tail;
		tail = temp;
		
		tail.next = null;
		
		
	}
	
	private void reverseLlRec2(Node prev, Node node) {
		
		if(node == null)
			return;
		
		reverseLlRec2(prev.next, node.next);
		
		node.next = prev;
	}
	

	public void reverseLl() {

		Node prev = null;
		Node node = this.head;

		this.tail = this.head;

		while (node != null) {
			Node next = node.next;

			node.next = prev;
			prev = node;
			node = next;
		}

		this.head = prev;

	}

	public void merge(linkedList other) {

		Node one = this.head;
		Node two = other.head;

		Node node = new Node(0);
		this.head = node;

		while (one != null && two != null) {

			if (one.data < two.data) {
				node.next = one;
				one = one.next;
			} else {
				node.next = two;
				two = two.next;
			}

			node = node.next;
		}

		if (one == null) {
			node.next = two;
		} else {
			node.next = one;
		}

		this.head = this.head.next;
		
		while(node.next != null)
			node = node.next;
		
		this.tail = node;
	}
}
