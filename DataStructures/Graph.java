package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	List<Integer>[] edges;

	public Graph(int nodes) {
		edges = new List[nodes+1];
		
		for(int node = 1; node < edges.length ; node++ ) {
			edges[node] = new ArrayList<Integer>();
		}
	
	
//		for(List<Integer> node: edges) {
//			node = new ArrayList<Integer>();
//		}
	}

	public void addEdge(int src, int dest) {
		edges[src].add(dest);
//		edges[dest].add(src);
	}
	
	public void display() {
		
		for(int node = 1; node < edges.length ; node++ ) {
			System.out.println(node + " - " + edges[node]);
		}
	}
}
