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

	private static int EDGE_WEIGHT = 6;
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

		computeAllDistances();

		printShortestDistances(new Integer(idS));
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
			//System.out.print(getShortestDistanceBFS(nodeS, each)+" ");
			System.out.print(nodeS.distances.get(each.id)+" ");
		}
		System.out.println();
	}

	private int getShortestDistanceBFS(Node src, Node dest) {
		LinkedList<SearchRecord> nextToVisit = new LinkedList<SearchRecord>();
		nextToVisit.add(new SearchRecord(src, 0));
		
		HashSet<Integer> nodesVisited = new HashSet<Integer>();

		while (!nextToVisit.isEmpty()) {
			SearchRecord next = nextToVisit.removeFirst();

			if (next.node.id.equals(dest.id)) {
				int result = EDGE_WEIGHT*next.depth;
				return result;
			}
		
			if (nodesVisited.contains(next.node.id)) continue;
			nodesVisited.add(next.node.id);
	
			//add neighbours of this node
			for (Node neighbour : next.node.neighbours) {
				nextToVisit.addLast(new SearchRecord(neighbour, next.depth+1));
			}
		}

		return -1;
	}

	private void addEdgeToGraph(Scanner scanner) {
		int nodeAId = scanner.nextInt();
		int nodeBId = scanner.nextInt();
		addEdge(new Integer(nodeAId), new Integer(nodeBId));
	}
}


