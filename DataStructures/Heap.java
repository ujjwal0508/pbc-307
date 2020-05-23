package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {
	
	private List<T> data;
	private boolean isMin;
	//One more class property.

	public Heap(boolean isMin) {
		this.data = new ArrayList<>();
		this.isMin = isMin;
	}
	
	public int size() {
		return this.data.size();
	}
	
	public boolean isEmpty() {
		return this.data.isEmpty();
	}
	
	public void add(T item) {
		this.data.add(item);
		upHeapify(this.data.size() - 1);
	}
	
	public void upHeapify(int ci) {
		
		int pi = (ci - 1) / 2;
		
		if(pi >= 0 && isHp(ci, pi)) {
			swap(pi, ci);
			upHeapify(pi);
		}
	}
	
	public T remove() {
		T rv = this.data.get(0);
		this.swap(0, this.data.size() - 1);
		this.data.remove(this.data.size() - 1);
		
		downHeapify(0);
		return rv;
	}
	
	public T get() {
		return this.data.get(0);
	}
	
	public void downHeapify(int pi) {
		
		int c1 = pi * 2 + 1;
		int c2 = c1 + 1;
		
		int maxi = pi;
		
		if(c1 < this.size() && isHp(c1, maxi))
			maxi = c1;
		
		if(c2 < this.size() && isHp(c2, maxi))
			maxi = c2;
		
		if(maxi != pi) {
			swap(pi, maxi);
			downHeapify(maxi);
		}
	}
	
	public boolean isHp(int i, int j) { // is high priority
		T one = this.data.get(i);
		T two = this.data.get(j);
		
		if(isMin) {
			return one.compareTo(two) <= 0;
		}else {
			return one.compareTo(two) > 0;
		}
	}
	
	public void swap(int i, int j) {
		T temp = this.data.get(i);
		this.data.set(i, this.data.get(j));
		this.data.set(j, temp);
	}
	
//	public int getIndex(T item) {
		
//	}
}
