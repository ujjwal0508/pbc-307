package DataStructures;

public class LinkedListClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		linkedList ll = new linkedList();
		
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		ll.add(50);
		ll.add(60);
		ll.add(70);
		ll.add(80);
		ll.add(90);
		
		ll.display();
		
		ll.reverseDataRec();
		ll.display();
	}

}
