import java.util.*;

public class WeightDirectGraph extends Graph{
	/* I use flag as a semaphore in order to ensure that if an alogorithm (Johnson) use other algorithm
	   flag=0 -> it's called from main
	   flag=1 -> it's called from other algorithm (Johnson) */
	// Main purpose avoid code(printing) duplication
	private int flag=0;	
	// Same as explained in the UndirectGraph.java
	int[] distances, parent;
	// Constructor
	public WeightDirectGraph(int vert) {
		super(vert);
		weightAdj=new HashMap<>();
		for(int i=0;i<vert;i++)
			weightAdj.put(i, new HashMap<>());
	}
	@Override
	public void addEdge(int src, int dest) {
		// TODO Auto-generated method stub
		weightAdj.putIfAbsent(src, new HashMap<>());
		addEdge(src,dest,new Random().nextInt(100)+1);
	}
	public void addEdge(int src, int dest, int weight) {		
		//if(weightAdj.get(src).get(dest) > weight) 
		weightAdj.get(src).put(dest, weight);
	}
	public void setflag(int s) {
		flag=s;
	}
	@Override
	public void printGraph() {
		// TODO Auto-generated method stub
		for(int i=0;i<vertices;i++) {
			System.out.print("Vertex "+ i +": ");
			for(Map.Entry<Integer,Integer> entry: weightAdj.get(i).entrySet())
				System.out.print(" -> (Dest: "+ entry.getKey() +", Weight: "+ entry.getValue() +")");
			System.out.println();
		}
	}
	//Dijkstra
	public void Dijkstra(int start, int target) {
		// Priority Queue where each element is an int[] with two elements: [distance, vertex]
		PriorityQueue<int[]> priority = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		distances = new int[vertices];
		
		parent = new int[vertices];
		boolean[] visited = new boolean[vertices];
		
		// Initialize distances and parents
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		distances[start] = 0;
		
		// Add the start vertex to the priority queue with a distance of 0
		priority.add(new int[] {0,start});
		while(!priority.isEmpty()) {
			int[] current = priority.poll();
			int currentDistance = current[0];
			int currentVert = current[1];
			
			// If we've reached the target vertex, stop early
			if(currentVert == target) break;
			// Skip if this vertex has already been processed
			if(visited[currentVert]) continue;
			visited[currentVert] = true;
			
			// Explore the neighbors of the current vertex
			if(weightAdj.containsKey(currentVert))
				for(Map.Entry<Integer, Integer> neighborEntry : weightAdj.get(currentVert).entrySet()) {
					int neighbor = neighborEntry.getKey();
					int weight = neighborEntry.getValue();
					// Relax the edge (update distance if a shorter path is found)
					if(!visited[neighbor] && (currentDistance + weight) < distances[neighbor]) {
						distances[neighbor] = currentDistance + weight;
						parent[neighbor] = currentVert;// Update the parent for path reconstruction
						priority.add(new int[] {distances[neighbor], neighbor});
					}
				}	
		}
		// Ensuring it's called from main
		if(flag==0)
			super.printWeightPath(start, target, distances, parent);	
	}
	//Bellman-Ford
	public void bellmanFord(int start, int target) {
        // Initialize distances from start vertex to all other vertices as infinite
		distances = new int[vertices];
		
		parent = new int[vertices];
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		distances[start]=0;
		// Relax edges |V| - 1 times
		for(int i=1;i<vertices;i++)
			for(int src: weightAdj.keySet())
				for(int dest: weightAdj.get(src).keySet()) {
					int weight = weightAdj.get(src).get(dest);
					if(distances[src] != Integer.MAX_VALUE && distances[src]+weight<distances[dest]) {
						distances[dest] = distances[src]+weight;
						parent[dest]=src; // Track the parent for path reconstruction
					}
				}
		/* Check for negative-weight cycles
        for (int source : adjacencyMap.keySet()) 
            for (int destination : adjacencyMap.get(source).keySet()) {
                int weight = adjacencyMap.get(source).get(destination);
                if (distances[source] != Integer.MAX_VALUE && distances[source] + weight < distances[destination]) {
                    System.out.println("Graph contains a negative-weight cycle");
                    return;
                }
            }
        */ 

		// Ensuring it's called from main
		if(flag==0)
			super.printWeightPath(start, target, distances, parent);
	}
	@Override
	// Johnson 
	public void Johnson(int start, int target) {
		// Add a new vertex and connect it to all other vertices with 0-weight edges
		int newVertex=vertices;
		vertices++;
		
		// Initialize the adjacency for the new vertex
		weightAdj.putIfAbsent(newVertex, new HashMap<>());
		for (int i = 0; i < vertices; i++) {
			weightAdj.get(newVertex).put(i, 0); // temporary vertex V as the source
        }
		// flag=1 -> this algorithm will use other algorithms
		setflag(1);
		
		// Bellman-Ford algorithm to calculate vertex weights for re-weighting
		 bellmanFord(newVertex, -1); // No target needed, we want all distances
		 int[] h = Arrays.copyOf(distances, distances.length); // Store potential function h[v]
		
		// Remove temporary vertex V
		weightAdj.remove(newVertex);
		vertices--;
		
		// Reweight all edges
		HashMap<Integer, Map<Integer, Integer>> reweightedAdj = new HashMap<>();
	    for (int u : weightAdj.keySet()) {
	        reweightedAdj.putIfAbsent(u, new HashMap<>());
	        for (int v : weightAdj.get(u).keySet()) {
	            int w = weightAdj.get(u).get(v);
	            int newW = w + h[u] - h[v];
	            reweightedAdj.get(u).put(v, newW);
	        }
	    }
	    // Temporarily replace the adjacency list with reweighted one
	    HashMap<Integer, Map<Integer, Integer>> originalAdj = weightAdj;
	    weightAdj = reweightedAdj;
		
	    // Dijkstra algorithm
        Dijkstra(start,target);
        
        // Fix distances to reflect original weights
        for (int v = 0; v < distances.length; v++) {
            if (distances[v] < Integer.MAX_VALUE && h[start] < Integer.MAX_VALUE && h[v] < Integer.MAX_VALUE)
                distances[v] = distances[v] - h[start] + h[v];
        }
        // Restore original graph
        weightAdj = originalAdj;
        
        // flag=0 -> this algorithm won't use other algorithms anymore
     	setflag(0);
        
     	// Print path and distance
		super.printWeightPath(start, target, distances, parent);
        
	}
	@Override
	public void initDistance(int[][] distances, int[][] predec) {
		// Populate initial distances and predecessors from weightAdj
		for(Integer src: weightAdj.keySet())
			for(Integer dest: weightAdj.get(src).keySet()) {
				distances[src][dest] = weightAdj.get(src).get(dest);
				predec[src][dest]=src;
			}
	}
	@Override
	public int printDistancePath(int[][] predec, int s, int t) {
		// Output the shortest path distance from start to end
		if(predec[s][t] == -1 /* || distances[start][target]==Integer.MAX_VALUE */) {
			System.out.print("No path from "+ s +" to "+ t);
			return 0;
		}else {
			System.out.print("Shortest path from " + s + " to " + t + ": ");
        	System.out.print("[");
        	printPathRecursive(s, t, predec);
        	System.out.print("]");
        	return 1;
		}
	}
}
