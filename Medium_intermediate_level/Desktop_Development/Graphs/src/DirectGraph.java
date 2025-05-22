import java.util.LinkedList;

public class DirectGraph extends Graph{
	public DirectGraph(int vert) {
		super(vert);
		shortPath=new LinkedList<Integer>();
	}
	public void addEdge(int src, int dest) {
		// TODO Auto-generated method stub
		adjList[src].add(dest);
	}
	@Override
	public void initDistance(int[][] distances, int[][] predec) {
		// Populate initial distances and predecessors 
		for(int src=0; src<adjList.length;src++)
			for(Integer dest: adjList[src]) {
				distances[src][dest] = 1;
				predec[src][dest]=src;
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
