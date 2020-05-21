package DataStructures;

public class TwoStacks {

	int[] arr;
	int topOne;
	int topTwo;
	
	public TwoStacks(int cap) {
		this.arr = new int[cap];
		this.topOne = -1;
		this.topTwo = cap;
	}
	
	public void push(int val, boolean isStackOne) {
		
		if(this.topTwo - this.topOne == 1) {
			System.out.println("stack full");
			return;
		}
		
		if(isStackOne) {
			this.topOne++;
			this.arr[this.topOne] = val;
		}else {
			this.topTwo--;
			this.arr[this.topTwo] = val;
		}
	}
	
	public int pop(boolean isStackOne) {
		
		if(!isStackOne) {
			
			if(this.topTwo == arr.length) {
				System.out.println("stack empty");
				return -1;
			}
			
			int rv = this.arr[this.topTwo];
			this.topTwo++;
			return rv;
			
		}else {
			
			if(this.topOne == -1) {
				System.out.println("stack empty");
				return -1;
			}
			
			int rv = this.arr[this.topOne];
			this.topOne--;
			return rv;
		}
	}
}
