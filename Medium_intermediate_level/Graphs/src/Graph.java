import java.util.*;

abstract class Graph {
	protected int vertices;
	// AdjencyList important for finding paths
	protected LinkedList<Integer> adjList[];
	// For DFS
	protected LinkedList<Integer> shortPath; 
	// For weighted graphs
	protected HashMap<Integer,Map<Integer,Integer>> weightAdj;
	// Constructor
	public Graph(int vert) {
		vertices=vert;
		adjList=new LinkedList[vert];
		for(int i=0;i<vert;i++)
			adjList[i]=new LinkedList<Integer>();
	}
	public abstract void addEdge(int src,int dest);
	//public abstract void printGraph();
	
	public void printGraph() {
		for(int i=0;i<vertices;i++) {
			System.out.print("Vertex "+ i +": ");
			for(Integer adj: adjList[i])
				System.out.print(" -> "+ adj);
			System.out.println();
		}
	}
	/* Because the edges are added randomly, they can be created duplicates especially in undirected
	 * so we are removing any duplicate 
	 */
	public void removeDupl() {
		for(int i=0;i<vertices;i++) {
			// This data type very useful for our method
			Set<Integer> neighbors=new HashSet<>(adjList[i]);
			// Clear the current adjacency list and add back the unique neighbors
			adjList[i].clear();
			adjList[i].addAll(neighbors);
		}
	}
	//Djikstra not working in superclass
	public void Dijkstra(int start, int target) {
		throw new UnsupportedOperationException("Dijkstra not implemented in base class\"");
	}
	//Bellman not working in superclass
	public void bellmanFord(int start, int target) {
		throw new UnsupportedOperationException("Bellman-Ford not implemented in base class\"");
	}
	// Johnson not working in superclass
	public void Johnson(int start, int target) {
		throw new UnsupportedOperationException("Johnson not implemented in base class\"");
	}
	//Floyd-Warshall
	public void Floyd(int start, int target) {
		// Initialize the distance matrix
		// Distance and predecessor matrices
		int[][] distances = new int[vertices][vertices];
		int[][] predec = new int[vertices][vertices];
		// Set initial distances to infinity, except the diagonal to 0
		for(int i=0;i<vertices;i++)
			for(int j=0;j<vertices;j++) {
				if(i==j)
					distances[i][j]=0;
				else
					distances[i][j]=Integer.MAX_VALUE;
				predec[i][j]=-1; // -1 signifies no predecessor
			}
		//Initial distance
		initDistance(distances,predec);
		// counter to check if graph is unweighted
		// Apply Floyd-Warshall algorithm
		for(int k=0;k<vertices;k++)
			for(int i=0;i<vertices;i++)
				for(int j=0;j<vertices;j++)
					if(distances[i][k]!=Integer.MAX_VALUE && distances[k][j]!=Integer.MAX_VALUE &&
					   distances[i][k]+distances[k][j] < distances[i][j]) {
						distances[i][j] = distances[i][k]+distances[k][j];
						predec[i][j] = predec[k][j]; // Update predecessor
					}
		/* Display the shortest path distances
		System.out.println("Shortest path distances between every pair of vertices:");
		for (int i=0;i<vertices;i++) {
            for (int j=0;j<vertices;j++) 
                if (distances[i][j]==Integer.MAX_VALUE) 
                    System.out.print("INF ");
                else
                    System.out.print(distances[i][j] + " ");
            System.out.println();
        }*/
		
		// Output the shortest path distance from start to end and 
		// check if the graph is unweighted(check=0) or not(check=1)
		int check=printDistancePath(predec,start,target);
		if(check==1)
			System.out.println("\nShortest distance: "+ distances[start][target]);
		else
			System.out.println();
	}
	
	/* Even though the printing method is the same I use it to all subclass in order for
	   CHECK above (the return method) */
 	public abstract int printDistancePath(int[][] predec, int start, int target);
 	// Initialize distances
	public abstract void initDistance(int[][] distances,int[][] predec);
	
	//BFS
	public void BFS(int start, int target) {
		boolean[] visited = new boolean[vertices];
		int[] parent=new int[vertices];
		Queue<Integer> queue= new LinkedList<>();
		
		// Initialize parent array with -1 (indicating no parent)
		for(int i=0;i<vertices;i++)
			parent[i] = -1;
		
		 // Start BFS from the 'start' node
		visited[start] = true;
		queue.add(start);
		while(!queue.isEmpty()) {
			int current=queue.poll(); // Dequeue a vertex
			if(current==target) break; // Stop if we reach the target
			//Iterate through adjacent vertices
			for(int adjvert: adjList[current])
				if(!visited[adjvert]) {
					visited[adjvert] = true;
					parent[adjvert] = current;
					queue.add(adjvert);
				}
		}
		// Note: if target and start are the same then the parent[target] == -1
		if(parent[target] == -1) {
			System.out.println("No path from "+ start +" to "+ target);
			return;
		}
		printPath(start,target,parent);
	}
	// Recursive helper to print the path
    public void printPathRecursive(int start, int end, int[][] predecessor) {
    	if (start == end) {
            System.out.print(start);
            return;
        }
        printPathRecursive(start, predecessor[start][end], predecessor);
        System.out.print(", "+ end);
    }
    /* Even though DFS AND BFS are primarily used for unweighted graphs, they are implemented in the superclass 
	 * rather than in their specific subclasses (like UndirectedGraph or DirectedGraph).
	 * 
	 * This design choice follows the DRY (Don't Repeat Yourself) principle to avoid code duplication.
	 * 
	 * They can be correctly implemented in the superclass because they operate solely on the 
	 * adjacency list (`adjList`, which is defined here as protected) which is not affected by the type of
	 * the graph (directed or undirected?)
     */
    //DFS
	public void DFS(int start, int target) {
		boolean[] visited = new boolean[vertices];
		LinkedList<Integer> current = new LinkedList<Integer>();
		//Recursive method
		dfsUtil(start,target,visited,current);
		if(shortPath.isEmpty())
			System.out.println("No path from "+ start +" to "+ target);
		else
			System.out.println("Shortest path from "+ start +" to "+ target +": "+ shortPath);
	}
	// Recursive helper method for DFS
	private void dfsUtil(int current, int end, boolean[] vis, LinkedList<Integer> curr) {
		vis[current]=true; // Mark current vertex as visited
		curr.add(current); // Add current vertex to current path
		if(current==end) {
			// If we reached the target and this path is shorter, store it
			if(shortPath.isEmpty() || curr.size() < shortPath.size())
				shortPath = new LinkedList<>(curr);
		}else
			for(int neighbor: adjList[current]) // Explore all unvisited neighbors
				if(!vis[neighbor])
					dfsUtil(neighbor,end,vis,curr);
		
		// Backtrack: remove the current vertex and mark as unvisited
		curr.removeLast();
		vis[current]=false;
	}
	
	// Print path (mostly used for unweighted graphs)
	public void printPath(int start, int target, int[] parent) {
		LinkedList<Integer> path=new LinkedList<>();
		for(int v=target;v!=-1;v=parent[v])
			path.addFirst(v);
		
		System.out.println("Shortest path from "+ start +" to "+ target +": "+ path);
	}
	// Print the weighted paths
	/* I put this in the upperclass in order to avoid code duplication (because this printing_path method for the 
	   weighted graphs' algorithms is the same) following the DRY (Don’t Repeat Yourself) principle */
	public void printWeightPath(int start, int target, int[] distances, int[] parent) {
		if(distances[target] == Integer.MAX_VALUE) {
			System.out.println("No path from "+ start +" to "+ target);
			return;
		}
		printPath(start, target, parent);
		System.out.println("Shortest distance: "+ distances[target]);
	}
}
