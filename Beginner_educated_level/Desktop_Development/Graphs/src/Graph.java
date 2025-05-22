import java.util.*;

abstract class Graph {
	protected int vertices;
	protected LinkedList<Integer> adjList[];
	// For DFS
	protected LinkedList<Integer> shortPath; 
	// For weighted graphs
	protected HashMap<Integer,Map<Integer,Integer>> weightAdj;
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
	public void removeDupl() {
		for(int i=0;i<vertices;i++) {
			Set<Integer> neighbors=new HashSet<>(adjList[i]);
			// Clear the current adjacency list and add back the unique neighbors
			adjList[i].clear();
			adjList[i].addAll(neighbors);
		}
	}
	//BFS
	public void BFS(int start, int target) {
		boolean[] visited = new boolean[vertices];
		int[] parent=new int[vertices];
		Queue<Integer> queue= new LinkedList<>();
		
		for(int i=0;i<vertices;i++)
			parent[i] = -1;
		
		visited[start] = true;
		queue.add(start);
		while(!queue.isEmpty()) {
			int current=queue.poll();
			if(current==target) break;
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
	//Djikstra not working in superclass
	public void Dijkstra(int start, int target) {
		throw new UnsupportedOperationException("Dijkstra not implemented in base class\"");
	}
	//Bellman not working in superclass
	public void bellmanFord(int start, int target) {
		throw new UnsupportedOperationException("Bellman-Ford not implemented in base class\"");
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
	public abstract int printDistancePath(int[][] predec, int start, int target);
	public abstract void initDistance(int[][] distances,int[][] predec);
	// Recursive helper to print the path
    public void printPathRecursive(int start, int end, int[][] predecessor) {
    	if (start == end) {
            System.out.print(start);
            return;
        }
        printPathRecursive(start, predecessor[start][end], predecessor);
        System.out.print(", "+ end);
    }
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
	private void dfsUtil(int current, int end, boolean[] vis, LinkedList<Integer> curr) {
		vis[current]=true;
		curr.add(current);
		if(current==end) {
			if(shortPath.isEmpty() || curr.size() < shortPath.size())
				shortPath = new LinkedList<>(curr);
		}else
			for(int neighbor: adjList[current])
				if(!vis[neighbor])
					dfsUtil(neighbor,end,vis,curr);
		
		curr.removeLast();
		vis[current]=false;
	}
	public void printPath(int start, int target, int[] parent) {
		LinkedList<Integer> path=new LinkedList<>();
		for(int v=target;v!=-1;v=parent[v])
			path.addFirst(v);
		
		System.out.println("Shortest path from "+ start +" to "+ target +": "+ path);
	}
	/* Johnson algorithm is a combination of Djikstra and Bellman-Ford 
	public void Johnson(int start,int target) {
		// Add a new vertex and connect it to all other vertices with 0-weight edges
		int[] distances= new int[vertices]
		for (int i = 0; i < vertices; i++) {
            addEdge(vertices,i,0); // temporary vertex V as the source
        }
	 	// Bellman-Ford algorithm to calculate vertex weights for re-weighting
		bellmanFord(start,target);
		
		// Remove temporary vertex V
		weightAdj.remove(vertices);
		// Reweight all edges
		for (int u : weightAdj.keySet()) 
            for (int v : weightAdj.get(u).keySet()) {
                int weight = weightAdj.get(u).get(v);
                weightAdj.get(u).put(v, weight + distances[u] - distances[v]);
            }
        // Djikstra algorithm
        Dijkstra(start,target);
        
        // Print path and distance
        if (distances[target] == Integer.MAX_VALUE) {
            System.out.println("No path from "+ start +" to "+ target);
        } else {
            System.out.println("Shortest path from "+ start +" to "+ target +": "+ distances[target]);
        }
	}
	*/
}
