import java.util.Iterator;
import java.util.LinkedList;
// Depth First Search graph traversal , when all nodes are reachable from a source vertex
public class DepthFirstSearch {
int V; // number of vertices
LinkedList<Integer>adjList[]; // representing the graph using adjacency list , using LinkedList Class
@SuppressWarnings({ "unchecked", "rawtypes" })
public DepthFirstSearch(int V) {
	this.V = V;
	adjList = new LinkedList[V];
	for (int i=0; i<V; i++) // an iteration  for
		adjList[i] = new LinkedList(); // creating a linked list for every vertex
}
//adding edges in a undirected graph
public void addEdge(int i , int j) {
	if(i < 0 || i >= V) {
		System.out.println("vertex " + i + " you are trying to add does not exist in this graph");
	}  if(j < 0 || j >= V) {
		System.out.println("vertex " + j + " you are trying to add does not exist in this graph");
	} else {
	adjList[i].add(j); // adding j vertices to vertex i's  linkedList	
	adjList[j].add(i); // adding i vertices to vertex j's  linkedList	
}
}
// The time complexity for this algorithm is O(V+E) where V is the number of Nodes we will visit during execution of this algorithm
//and E is the number of edges incident to a given vertex v(we are checking or looping over all the edges of every vertex)	
// the auxilliary space is O(V) because of the extra space of visited array we have created of size V 
// the space the algorithm needs to run is O(V) because we are pushing V vertices in the call stack
// therefore , the total space complexity for this algorithm is O(V) + O(V) for auxilliary space
// Hence, the space complexity this algorithm needs to run is O(V + V)
public void DFSRecursive(int s,boolean visited []){//s is the source vertex passed and called the main method
	                                          // visited[] is the array for marking visited vertices
	visited[s]= true;
	System.out.print( s + " ");
	Iterator<Integer> i = adjList[s].listIterator();
	while(i.hasNext()) {
		int n = i.next();
		if(!visited[n]) {
			DFSRecursive(n,visited);
		}
	}
}
public void DFS(int s) {
	if(s >=V) {
		System.out.println("this source vertex does not exist in this graph.please check again");
	} else {
	@SuppressWarnings("unused")
	boolean [] visited = new boolean[V];
	DFSRecursive(s,visited);
	}
}
	public static void main(String[] args) {
		DepthFirstSearch graph = new DepthFirstSearch(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(4, 3);
		graph.addEdge(4, 0);
		System.out.println("the DFS traversal is : ");
		graph.DFS(3);
		// TODO Auto-generated method stub

	}

}
