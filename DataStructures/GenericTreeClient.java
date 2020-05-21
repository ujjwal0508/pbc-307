package DataStructures;

public class GenericTreeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 2, 5, -1, 60, -1, -1, 3, -1, 4, 7, -1, 8, 9, -1, -1, -1, -1 };
		GenericTree gt = new GenericTree(arr);

		gt.display();
		System.out.println();
		
		System.out.println(gt.size2());
		System.out.println(gt.max());
		System.out.println(gt.height());

	}

}
