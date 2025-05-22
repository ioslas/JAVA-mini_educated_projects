import java.util.*;

public class GraphShortestPath {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numVert=new Random().nextInt(10)+1;
		Graph[] gr=new Graph[4];
		
		Scanner scan=new Scanner(System.in);
		int times,el;
		//All Graphs
		gr[0] = new UndirectGraph(numVert);
		gr[1] = new DirectGraph(numVert);
		gr[2] = new WeightDirectGraph(numVert);
		gr[3] = new WeightUndirectGraph(numVert);
		// Graph Creation
		for(int i=0;i<numVert;i++) {
			System.out.print("Add edges with src="+ i +": ");
			times=scan.nextInt();
			while(times!=0) {
				if(times>=numVert) {
					System.out.println("Unappropriated number of edges-> No Edges added!");
					break;
				}
				el=new Random().nextInt(numVert);
				for(int j=0;j<4;j++)
					gr[j].addEdge(i, el);
				times--;
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
		System.out.println();
		Character answer;
		do {
			if(numVert==1) break;

			// Give start & target
			System.out.print("Give start vertices: ");
			int s=scan.nextInt(numVert);
			System.out.print("Give target vertices: ");
			int t=scan.nextInt(numVert);
			for(int i=0;i<4;i++) {
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
					System.out.println("\nBFS algorithm: ");
					gr[i].BFS(s,t);
					System.out.println("\nDFS algorithm: ");
					gr[i].DFS(s,t);
				}else {
					//Algoriths who work only on weighted graphs
					System.out.println("\nDIJKTRSA algorithm: ");
					gr[i].Dijkstra(s,t);
					System.out.println("\nBELLMAN-FORD algorithm: ");					
					gr[i].bellmanFord(s,t);
					/* Johnson algorithm is a combination of Djikstra and Bellman-Ford 
					System.out.println("\nJOHNSON algorithm: ");					
					gr[i].Johnson(s,t);
					*/
				}
				//Algorithms who works to all graph types
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
