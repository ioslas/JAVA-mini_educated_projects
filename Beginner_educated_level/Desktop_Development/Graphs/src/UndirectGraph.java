import java.util.*;

public class UndirectGraph extends Graph{
	public UndirectGraph(int vert) {
		super(vert);
		shortPath=new LinkedList<Integer>();
	}
	// Add edge
	public void addEdge(int src,int dest) {
		adjList[src].add(dest);
		
		if(src!=dest)
			adjList[dest].add(src);
	}
	@Override
	public void initDistance(int[][] distances, int[][] predec) {
		// Populate initial distances and predecessors 
		for(int src=0; src<adjList.length;src++)
			for(Integer dest: adjList[src]) {
				distances[src][dest] = 1;
				distances[dest][src] = 1;
				predec[src][dest]=src;
				predec[dest][src]=dest;
			}
	}
	@Override
	public int printDistancePath(int[][] predec, int s, int t) {
		// Output the shortest path distance from start to end
		if(predec[s][t] == -1 /* || distances[start][target]==Integer.MAX_VALUE */)
			System.out.print("No path from "+ s +" to "+ t);
		else {
			System.out.print("Shortest path from " + s + " to " + t + ": ");
        	System.out.print("[");
        	printPathRecursive(s, t, predec);
        	System.out.print("]");
		}
		return 0;
	}
}
