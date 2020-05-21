package DataStructures;

import java.util.LinkedList;

public class HashMap<K, V> {

	class Node{
		K key;
		V value;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[" + key + "," + value + "]";
		}
	}
	
	LinkedList<Node>[] buckets;
	int size;
	static double lambda = 2;
	
	public HashMap(int initSize) {
		this.buckets = new LinkedList[initSize];
	}
	
	
	public int size() {
		return this.size;
	}
	
	public void put(K key, V value) {
		
		int bn = getBucketNumber(key);
		
		if(buckets[bn] == null) {
			
			buckets[bn] = new LinkedList<HashMap<K,V>.Node>();
			buckets[bn].add(new Node(key, value));
			this.size++;
			
		}else {
			
			int nodeIdx = findInList(buckets[bn], key);
			if(nodeIdx == -1) {
				Node node = new Node(key, value);
				buckets[bn].add(node);
				this.size++;
				
			}else {
				
				Node nodeInList = buckets[bn].get(nodeIdx);
				nodeInList.value = value;
			}
			
			double lambdaValue = (this.size * 1.0) / buckets.length;
			
			if(lambdaValue > HashMap.lambda)
				rehash();
		}
	}
	
	private int findInList(LinkedList<HashMap<K, V>.Node> linkedList, K key) {
		
		int rv = -1;
		for(int idx=0; idx < linkedList.size();idx++) {
			Node node = linkedList.removeFirst();
		
			if(node.key == key)
				rv = idx;
			
			linkedList.addLast(node);
		}
		return rv;
	}


	private int getBucketNumber(K key) {
		int hc = key.hashCode();
		return hc % buckets.length;
	}
	
	public K remove(K key) {
		
		int bn = this.getBucketNumber(key);
		
		if(buckets[bn] == null)
			return null;
		
		int nodeIdx = this.findInList(buckets[bn], key);
		
		if(nodeIdx == -1)
			return null;
		
		Node node = buckets[bn].remove(nodeIdx);
		return node.key;
	}
	
	private void rehash() {
		
		LinkedList<Node>[] ol = this.buckets;
		this.buckets = new LinkedList[ol.length * 2];
		
		for(LinkedList<Node> list: ol) {
			
			while(!list.isEmpty()) {
				Node node = list.removeFirst();
				this.put(node.key, node.value);
			}
		}
		
	}
	
	public boolean containsKey(K key) {
		int bn = this.getBucketNumber(key);
		
		if(buckets[bn] == null)
			return false;
		
		int nodeIdx = this.findInList(buckets[bn], key);
		
		return nodeIdx != -1;
	}
	
	
	public void display() {
		
		int cnt = 1;
		for(LinkedList<Node> list: this.buckets) {
			System.out.println(cnt + " -> " + list);
			cnt++;
		}
		
	}
	
	public V get(K key) {
		int bn = this.getBucketNumber(key);
		
		if(buckets[bn] == null)
			return null;
		
		int nodeIdx = this.findInList(buckets[bn], key);
		
		if(nodeIdx == -1)
			return null;
		
		Node node = buckets[bn].get(nodeIdx);
		return node.value;
	}
	
}
