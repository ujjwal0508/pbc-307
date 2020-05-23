package DataStructures;

public class HeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap<Integer> hp = new Heap<Integer>(false);
		
		int[] arr = {1, 3, 5, 4, 6, 13, 10, 
                9, 8, 15, 17};
		
		for(int val: arr)
			hp.add(val);
		
		System.out.println(hp.get());
		hp.remove();
		System.out.println(hp.get());
		hp.remove();
		System.out.println(hp.get());
		hp.add(20);
		System.out.println(hp.get());
	}

}
