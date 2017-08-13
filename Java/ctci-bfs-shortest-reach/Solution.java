//Refs: https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
//

import java.io.*;
import java.util.*;


public class Solution {
	class Node {
		public int id;
		public LinkedList<Node> neighbours;

		public Node(int id) {
			this.id = id;
			neighbours = new LinkedList<Node>();
		}
	}

	private static int EDGE_WEIGHT = 6;
	private static boolean debugging = true;
	HashMap<Integer,Node> nodeMap;
	HashSet<Integer> nodesVisitedBySearch;
	LinkedList<Integer> searchQueue;

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.execute();
	}

	private Node getNode(int id) {
		return nodeMap.get(new Integer(id));
	}

	//This is an undirected graph, so both nodes need to know of this connection
	private void addEdge(int idA, int idB) {
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
			Node newNode = new Node(i);
			nodeMap.put(new Integer(i), newNode);
		}

		for (int i=0;i<m;i++) {
			addEdgeToGraph(scanner);
		}

		int idS = scanner.nextInt();
		//if (debugging) System.out.println("Graph assembled. There are "+nodeMap.size()+" nodes. Starting node is "+idS);

		printShortestDistances(idS);
	}

	//for each node in graph, print shortest distance to them, from s. -1 if there's no connection, skip mentioning self
	private void printShortestDistances(int idS) {
		Node nodeS = getNode(idS);
		for (Node each : nodeMap.values()) {
			if (each.id == idS) continue;

			nodesVisitedBySearch = new HashSet<Integer>();
			searchQueue = new LinkedList<Integer>();
			int shortestDistance = getShortestDistanceBFS(nodeS, each);
			System.out.print(shortestDistance+" ");
		}
		System.out.println();
	}

	private int getShortestDistanceBFS(Node src, Node dest) {
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		LinkedList<Integer> depthQueue = new LinkedList<Integer>();
		HashSet<Integer> nodesVisited = new HashSet<Integer>();

		
		int depthIterator = 0;
		nextToVisit.add(src);
		depthQueue.add(new Integer(depthIterator));

		while (!nextToVisit.isEmpty()) {
			Node next = nextToVisit.removeFirst();
			Integer depth = depthQueue.removeFirst();

			if (next.id == dest.id) {
				return EDGE_WEIGHT*depth.intValue();
			}

			if (nodesVisited.contains(new Integer(next.id))) continue;
			nodesVisited.add(new Integer(next.id));
		
			//add neighbours of this node
			int addedCount = 0;
			depthIterator++;
			for (Node neighbour : next.neighbours) {
				addedCount++;
				nextToVisit.add(neighbour);
				depthQueue.add(new Integer(depthIterator));
			}
		}

		return -1;
	}

	private void addEdgeToGraph(Scanner scanner) {
		int nodeAId = scanner.nextInt();
		int nodeBId = scanner.nextInt();
		addEdge(nodeAId, nodeBId);
		//if (debugging) System.out.println("Added undirected edge between nodes "+nodeAId+" and "+nodeBId);
	}
}
