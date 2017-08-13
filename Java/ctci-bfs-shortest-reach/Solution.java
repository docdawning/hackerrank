//Refs: https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
//

import java.io.*;
import java.util.*;

public class Solution {
	class Node {
		public Integer id;
		public LinkedList<Node> neighbours;

		public Node(Integer id) {
			this.id = id;
			neighbours = new LinkedList<Node>();
		}
	}

	private static final int INFINITY_DISTANCE = Integer.MAX_VALUE;
	private static final int UNDEFINED_DISTANCE = Integer.MAX_VALUE;
	private static final int EDGE_WEIGHT = 6;
	HashMap<Integer,Node> nodeMap;

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.execute();
	}

	private Node getNode(Integer id) {
		return nodeMap.get(id);
	}

	//This is an undirected graph, so both nodes need to know of this connection
	private void addEdge(Integer idA, Integer idB) {
		Node nodeA = getNode(idA);
		Node nodeB = getNode(idB);
		nodeA.neighbours.addLast(nodeB);
		nodeB.neighbours.addLast(nodeA);
	}

	private void execute() {
		Scanner scanner = new Scanner(System.in);
		int q = scanner.nextInt();

		for (int i=0;i<q;i++) {
			processGraphQuery(scanner);
		}
	}

	private void processGraphQuery(Scanner scanner) {
		nodeMap = new HashMap<Integer,Node>();
		int n = scanner.nextInt();
		int m = scanner.nextInt();


		for (int i=1;i<=n;i++) {
			Node newNode = new Node(new Integer(i));
			nodeMap.put(newNode.id, newNode);
		}

		for (int i=0;i<m;i++) {
			addEdgeToGraph(scanner);
		}

		int idS = scanner.nextInt();
		int[] dijkstraDistances = new int[n+1]; //these will only be relevant to idS
		int[] dijkstraPreviousDistances = new int[n+1];

		computeDistancesViaDijkstra(idS, dijkstraDistances, dijkstraPreviousDistances);

		printShortestDistances(new Integer(idS), dijkstraDistances);
	}

	private void printShortestDistances(Integer source, int[] dijkstraDistances) {
		for (Node each : nodeMap.values()) {
			if (each.id.equals(source)) continue;
			int distance = dijkstraDistances[each.id.intValue()];
			if (distance == Integer.MAX_VALUE) distance = -1;
			if (distance < -1) distance = -1;
			System.out.print(distance+" ");
		}
		System.out.println();

	}

	//Much help from here: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Pseudocode
	private void computeDistancesViaDijkstra(int source, int[] dist, int[] prev) {
		LinkedList<Node> vertexQueue = new LinkedList<Node>();

		for (Node vertex : nodeMap.values()) {
			dist[vertex.id.intValue()] = INFINITY_DISTANCE;		//Infinity
			prev[vertex.id.intValue()] = UNDEFINED_DISTANCE; 	//Undefined
			vertexQueue.add(vertex);
		}

		dist[source] = 0;

		while (!vertexQueue.isEmpty()) {
			//u ← vertex in Q with min dist[u]
			Node u = vertexQueue.getFirst();
			int minDist = dist[u.id.intValue()];
			for (Node vertex : vertexQueue) {
				if (dist[vertex.id.intValue()] < dist[u.id.intValue()]) u = vertex;
			}
			
			//remove u from Q 
			vertexQueue.remove(u);

			//for each neighbor v of u:        
			for (Node v : u.neighbours) {
				//alt ← dist[u] + length(u, v)
				int alt = dist[u.id.intValue()] + EDGE_WEIGHT;

				//if alt < dist[v]:               // A shorter path to v has been found
				if (alt < dist[v.id.intValue()]) {
					//dist[v] ← alt 
					dist[v.id.intValue()] = alt;
	
					//prev[v] ← u
					prev[v.id.intValue()] = u.id.intValue();
				}
			}
		}
	}

	private void addEdgeToGraph(Scanner scanner) {
		int nodeAId = scanner.nextInt();
		int nodeBId = scanner.nextInt();
		addEdge(new Integer(nodeAId), new Integer(nodeBId));
	}
}


