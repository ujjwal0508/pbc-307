package DataStructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Graph {

	List<Integer>[] edges;

	public Graph(int nodes) {
		edges = new List[nodes + 1];

		for (int node = 1; node < edges.length; node++) {
			edges[node] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		edges[src].add(dest);
		edges[dest].add(src);
	}

	public void display() {

		for (int node = 1; node < edges.length; node++) {
			System.out.println(node + " - " + edges[node]);
		}
	}

	public boolean hasPath(int src, int dest) {

		return hasPathHelper(src, dest, new boolean[this.edges.length + 1]);
	}

	private boolean hasPathHelper(int src, int dest, boolean[] visited) {

		if (src == dest)
			return true;

		if (visited[src])
			return false;

		visited[src] = true;

		for (int neigh : this.edges[src]) {
			if (hasPathHelper(neigh, dest, visited))
				return true;
		}

		visited[src] = false;
		return false;
	}

	public void dft() {

		boolean[] visited = new boolean[this.edges.length + 1];
		for (int node = 1; node < this.edges.length; node++)
			dft(node, visited);
		System.out.println();
	}

	private void dft(int src, boolean[] visited) {

		if (visited[src])
			return;

		System.out.print(src + " -> ");

		visited[src] = true;
		for (int neigh : this.edges[src])
			dft(neigh, visited);

//		visited[src] = false;
	}

	public int connectedComponents() {

		boolean[] visited = new boolean[this.edges.length + 1];
		int components = 0;
		for (int node = 1; node < this.edges.length; node++) {

			components += visited[node] != true ? 1 : 0;

			dft(node, visited);
		}
		System.out.println();
		return components;
	}

	public boolean isBipartite() {

		HashSet<Integer> one = new HashSet<Integer>();
		HashSet<Integer> two = new HashSet<Integer>();

		boolean[] visited = new boolean[this.edges.length + 1];
		for (int node = 1; node < this.edges.length; node++) {

			if (visited[node])
				continue;

			one.add(node);
			boolean ans = isBipartiteHelper(node, one, two, visited);
			
			if(!ans)
				return false;
		}

		return true;
	}

	public boolean isBipartiteHelper(int src, HashSet<Integer> one, HashSet<Integer> two, boolean[] visited) {

		if (visited[src])
			return true;

		boolean amIOne = one.contains(src);
		visited[src] = true;
		for (int neigh : this.edges[src]) {

			if (amIOne && one.contains(neigh))
				return false;

			if (!amIOne && two.contains(neigh))
				return false;

			if (amIOne)
				two.add(neigh);
			else
				one.add(neigh);

			if (!isBipartiteHelper(neigh, one, two, visited))
				return false;
		}

		return true;
	}

}
