import java.util.*;

public class GraphShortestPath {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Give a random number of vertices (max=10)
		int numVert=new Random().nextInt(10)+1;
		Graph[] gr=new Graph[4];
		
		Scanner scan=new Scanner(System.in);
		int edges,ed;
		
		//All Graphs
		gr[0] = new UndirectGraph(numVert);
		gr[1] = new DirectGraph(numVert);
		gr[2] = new WeightDirectGraph(numVert);
		gr[3] = new WeightUndirectGraph(numVert);
		
		// Graph Creation
		for(int i=0;i<numVert;i++) {
			// Give number of edges for each graph
			System.out.print("Add edges with src="+ i +": ");
			edges=scan.nextInt();
			// while there are edges for the vertice
			while(edges!=0) {
				// In graph a vertice can't have edges more than the total number of vertices 
				if(edges>=numVert) {
					System.out.println("Unappropriated number of edges-> No Edges added!");
					break;
				}
				//Give me a random number < number of vertices
				ed=new Random().nextInt(numVert);
				// Add edges randomly for every graph
				for(int j=0;j<4;j++)
					gr[j].addEdge(i, ed);
				edges--;
			}
		}
		//Print all Graphs
		for(int i=0;i<4;i++) {
			System.out.println();
			if(i==0)
				System.out.println("Undirected Graph");
			else if(i==1)
				System.out.println("Directed Graph");
			else if(i==2)
				System.out.println("Weighted Directed Graph");
			else
				System.out.println("Weighted Undirected Graph");

			if(i<2)
				gr[i].removeDupl();
			gr[i].printGraph();
		}
	    
		System.out.println("\n\nFIND SHORTEST PATH with SRC and TARGET");
		Character answer;
		do {
			if(numVert==1) break; // With 1 vertice there is no point of following this task

			// Give start & target
			System.out.print("Give start vertices: ");
			int s=scan.nextInt(numVert);
			System.out.print("Give target vertices: ");
			int t=scan.nextInt(numVert);
			for(int i=0;i<4;i++) {
				System.out.println();
				if(i==0)
					System.out.println("\n- Undirected Graph");
				else if(i==1)
					System.out.println("- Directed Graph");
				else if(i==2)
					System.out.println("- Weighted Directed Graph");
				else
					System.out.println("- Weighted Undirected Graph");
				//Find short paths algorithms
				if(i<2) { 
					//Algoriths who work only on unweighted graphs
					//BFS
					System.out.println("\nBFS algorithm: ");
					gr[i].BFS(s,t);
					//DFS
					System.out.println("\nDFS algorithm: ");
					gr[i].DFS(s,t);
				}else {
					//Algoriths who work only on weighted graphs
					//DIJKTRSA
					System.out.println("\nDIJKTRSA algorithm: ");
					gr[i].Dijkstra(s,t);
					
					/* Note: BELLMAN AND JOHSNON can work in undirected graphs only if 
					 * the weights!=0 (non-negative) else => negative cycle.
					 *   
					 *  But because the weights are giving RANDOMLY so we ensure that they
					 *  are non-negative 
					 */
					
					//BELLMAN-FORD
					System.out.println("\nBELLMAN-FORD algorithm: ");					
					gr[i].bellmanFord(s,t);
					//JOHNSON
					/* Johnson algorithm is a combination of Djikstra and Bellman-Ford */
					System.out.println("\nJOHNSON algorithm: ");					
					gr[i].Johnson(s,t);
				}
				//Algorithms who works to all graph types
				//Floyd-Warshall
				System.out.println("\nFLOYD-WARSHALL algorithm: ");					
				gr[i].Floyd(s,t);
				System.out.println();	
			}
			do {
				System.out.print("Do you want to continue(y/n)? ");
				answer = Character.toLowerCase(scan.next().charAt(0));
				if(answer!='y' && answer!='n')
					System.out.println("Invalid answer.Try again!");
			}while(answer!='y' && answer!='n');
			System.out.println();
		}while(answer!='n');
		
		System.out.println("End of operations!");
		scan.close();
	}
}
