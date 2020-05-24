package DataStructures;

public class GraphClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph = new Graph(7);

		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
//		graph.addEdge(2, 5);
		graph.addEdge(3, 4);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);

		
//		graph.display();
		
//		System.out.println(graph.hasPath(1, 6));
//		graph.dft();
//		System.out.println(graph.connectedComponents());
		System.out.println(graph.isBipartite());
	}

}
