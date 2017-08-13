//Refs: https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
//

import java.io.*;
import java.util.*;

public class Solution {
	class Node {
		public Integer id;
		public LinkedList<Node> neighbours;
		public HashMap<Integer,Integer> distances; //NodeID, Distance

		public Node(Integer id) {
			this.id = id;
			neighbours = new LinkedList<Node>();
			distances = new HashMap<Integer,Integer>();
		}

		//computes shortest distance to all other nodes. Also updates the other nodes' distance 
		//map with the found distance, since this is an undirected graph
		public void computeDistanceToNeighbours(HashMap<Integer,Node> nodeMap, Solution solution) {
			//first all immediately adjacent neighbours should be directly considered
			for (Node each : neighbours) {
				distances.put(each.id, new Integer(Solution.EDGE_WEIGHT));
				each.distances.put(this.id, new Integer(Solution.EDGE_WEIGHT));
			}

			//now use the BFS algorithm to find distance to others
			for (Node each : nodeMap.values()) {
				if (each.id.equals(this.id)) continue;
				if (distances.get(each.id) != null) continue; //already computed
				int distance = solution.getShortestDistanceBFS(this, each);
				distances.put(each.id, new Integer(distance));
				each.distances.put(this.id, new Integer(distance));
			}
		}
	}

	class SearchRecord {
		Node node;
		int depth;

		SearchRecord(Node node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	private static final Integer negativeOneInteger = new Integer(-1);
	private static final int INFINITY_DISTANCE = Integer.MAX_VALUE;
	private static final int UNDEFINED_DISTANCE = -1;
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

		//computeAllDistances();
		computeDistancesViaDijkstra(idS, dijkstraDistances, dijkstraPreviousDistances);

		//printShortestDistances(new Integer(idS));
		printShortestDistances(new Integer(idS), dijkstraDistances);
	}

	private void printShortestDistances(Integer source, int[] dijkstraDistances) {
		for (Node each : nodeMap.values()) {
			if (each.id.equals(source)) continue;
			int distance = dijkstraDistances[each.id.intValue()];
			if (distance == Integer.MAX_VALUE) distance = -1;
			System.out.print(distance+" ");
		}
		System.out.println();

	}

	//Much help from here: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Pseudocode
	private void computeDistancesViaDijkstra(int source, int[] dist, int[] prev) {
		LinkedList<Node> vertexQueue = new LinkedList<Node>();

		//System.out.println("dist size is: "+dist.length);
		for (Node vertex : nodeMap.values()) {
			//System.out.println("initializing dist["+vertex.id.intValue()+"]");
			dist[vertex.id.intValue()] = INFINITY_DISTANCE;		//Infinity
			prev[vertex.id.intValue()] = UNDEFINED_DISTANCE; 	//Undefined
			vertexQueue.add(vertex);
		}

		dist[source] = 0;

		while (!vertexQueue.isEmpty()) {
			//u ← vertex in Q with min dist[u]
			int minDist = 1000000; //an assumption, not good for most cases
			Node u = null;
			for (Node vertex : vertexQueue) {
				if (dist[vertex.id.intValue()] < minDist) u = vertex;
			}
			
			//remove u from Q 
			vertexQueue.remove(u);

			//for each neighbor v of u:        
			if (u == null) break;//System.out.println("u is null, vertexQueue.size(): "+vertexQueue.size());
			for (Node neighbour : u.neighbours) {
				if (vertexQueue.indexOf(neighbour) < 0) continue;  // where v is still in Q.
				
				//alt ← dist[u] + length(u, v)
				int alt = dist[u.id.intValue()] + EDGE_WEIGHT;

				//if alt < dist[v]:               // A shorter path to v has been found
				if (alt < dist[neighbour.id.intValue()]) {
					//dist[v] ← alt 
					dist[neighbour.id.intValue()] = alt;
	
					//prev[v] ← u
					prev[neighbour.id.intValue()] = u.id.intValue();
				}
			}

		}
			
	}

	private void computeAllDistances() {
		for (Node each : nodeMap.values()) {
			each.computeDistanceToNeighbours(nodeMap, this);
		}

	}

	//for each node in graph, print shortest distance to them, from s. -1 if there's no connection, skip mentioning self
	private void printShortestDistances(Integer idS) {
		Node nodeS = getNode(idS);
		for (Node each : nodeMap.values()) {
			if (each.id.equals(idS)) continue;
			System.out.println("Distance: "+nodeS.id+" & "+each.id);
			System.out.print(getShortestDistanceBFS(nodeS, each)+" ");
		//	System.out.print(nodeS.distances.get(each.id)+" ");
		}
		System.out.println();
	}

	private int getShortestDistanceBFS(Node src, Node dest) {
		if (src.distances.get(dest.id) != null) return src.distances.get(dest.id).intValue();

		LinkedList<SearchRecord> nextToVisit = new LinkedList<SearchRecord>();
		nextToVisit.add(new SearchRecord(src, 0));
		
		HashSet<Integer> nodesVisited = new HashSet<Integer>();

		while (!nextToVisit.isEmpty()) {
			SearchRecord next = nextToVisit.removeFirst();

			if (next.node.id.equals(dest.id)) {
				int result = EDGE_WEIGHT*next.depth;
				Integer resultInteger = new Integer(result);
				src.distances.put(dest.id, resultInteger);
				dest.distances.put(src.id, resultInteger);
				return result;
			}
		
			if (nodesVisited.contains(next.node.id)) continue;
			nodesVisited.add(next.node.id);
	
			//add neighbours of this node
			for (Node neighbour : next.node.neighbours) {
				nextToVisit.addLast(new SearchRecord(neighbour, next.depth+1));
			}
		}
	
		src.distances.put(dest.id, negativeOneInteger);	
		dest.distances.put(src.id, negativeOneInteger);
		return -1;
	}

	private void addEdgeToGraph(Scanner scanner) {
		int nodeAId = scanner.nextInt();
		int nodeBId = scanner.nextInt();
		addEdge(new Integer(nodeAId), new Integer(nodeBId));
	}
}


