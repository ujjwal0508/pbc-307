package DataStructures;

public class stack {

	private int[] arr;
	private int top;
	
	public stack(int cap) {
		this.arr = new int[cap];
		this.top = -1;
	}
	
	public void push(int val){
		
		if(this.top == this.arr.length - 1) {
			System.out.println("Stack overflow");
			return;
		}
		
		this.top++;
		this.arr[this.top] = val;
	}
	
	public int pop() {
		
		if(this.top == -1) {
			System.out.println("Stack underflow");
			return -1;
		}
		
		int rv = this.arr[this.top];
		this.top--;
		return rv;
	}
	
	public void display() {
			
		for(int i = this.top ;i >= 0;i --) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println();
	}
	
	public int size() {
		return top + 1;
	}
	
	public int top() {
		
		if(top == -1) {
			System.out.println("Stack underflow");
			return -1;
		}
		
		return arr[top];
		
	}
	
}
