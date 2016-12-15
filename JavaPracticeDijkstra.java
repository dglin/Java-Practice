

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Stack;

public class JavaPracticeDijkstra {

	public static void main(String[] args) {
		Graph graph = new Graph(10);
		graph.print();

		HashMap<Character,Pair> closest = graph.dijkstra('C');

		System.out.println("Node A to");
		for(HashMap.Entry entry : closest.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " " + entry.getValue().toString());
		}
	}

	/**
	*	Graph node. Each node contains char "name"
	*	and a adjacency matrix of neighbor nodes, and weights.
	*/
	private static class Node {
		private char name;
		private HashMap<Character,Integer> adjacency;
		private ArrayList<Node> neighbors;

		public Node(char name) {
			this.name = name;
			this.adjacency = new HashMap();
			this.neighbors = new ArrayList();
		}

		public void addAdjacency(char node, int weight) { this.adjacency.put(node,weight); }

		public void setNeighbor (Node neighbor) { this.neighbors.add(neighbor); }

		public void printNode() { System.out.println("Node: " + this.name + " , Adjacency: " + this.adjacency.toString()); }

		public ArrayList<Node> getNeighbors() { return this.neighbors; }

		public char getName() { return name; }

		public int checkAdjacency(char name) { 
			int value = (this.adjacency.containsKey(name)) ? this.adjacency.get(name) : -1;
			return value;
		}
	}

	private static class Pair {
		public int cost;
		public ArrayList<Character> path;

		public Pair() {
			cost = -1;
			path = new ArrayList();
		}

		public String toString() {
			return "Cost: " + String.valueOf(this.cost) + ", " + path.toString();
		}
	}

	private static class Graph {

		Node[] graph;
		HashMap<Character, Pair>[] shortestPathMatrix;
		/**
		*	Constructor. Creates a random default graph
		*/
		public Graph(int numNodes) {

			this.graph = new Node[numNodes];
			Random rand = new Random();

			for (int i = 0; i < numNodes; i++) {
				this.graph[i] = new Node((char)(i + 'A'));
			}
			for (int i = 0; i < numNodes; i++) {
				for (int j = 0; j < numNodes; j++) {

					if (j != i && rand.nextInt(9) >= 5) {
						this.graph[i].addAdjacency((char)(j + 'A'), rand.nextInt(100));
						this.graph[i].setNeighbor(this.graph[j]);

					}
				}
			}
			shortestPathMatrix = new HashMap[10];
			populateDijkstra();
		}

		public void print() {
			for (int i = 0; i < graph.length; i++) {
				this.graph[i].printNode();
			}
		}

		/** 
		*	Dijkstra's shortest path algorithm. Returns a Map, which has a value of a pair
		*   Where the {pair}.cost = the cost of the shortest path, and {pair}.path is
		*	an array of chars that represent the path through the nodes.
		**/ 
		private HashMap<Character, Pair> dijkstra (char origin) {
			HashMap<Character, Pair> ret = new HashMap();
			for (int i = 0; i < graph.length; i++) {
				ret.put((char)(i + 'A'), new Pair());
			}
			int[] weights = new int[this.graph.length];
			Node head = this.graph[(int)(origin - 'A')];
			// Initialize the weights vector with "infinity"
			for (int i = 0; i < weights.length; i++) {
				weights[i] = Integer.MAX_VALUE;
			}
			weights[(int)(origin - 'A')] = -1;
			ret.get(origin).cost = 0;
			for (int iters = 0; iters < weights.length - 1; iters++) {
				// Update weights.
				for (int i = 0; i < weights.length; i++) {
					if (head.checkAdjacency((char)(i + 'A')) + ret.get(head.getName()).cost < weights[i]
						&& head.checkAdjacency((char)(i + 'A')) > -1) { 
						weights[i] = head.checkAdjacency((char)(i + 'A')) + ret.get(head.getName()).cost;
						ret.get((char)(i + 'A')).path.add(head.getName());
						ret.get((char)(i + 'A')).cost = ret.get(head.getName()).cost + weights[i];
					}
				}
				// Find min of the weights.
				int min = Integer.MAX_VALUE;
				int ptr = 0;
				for (int i = 0; i < weights.length; i++) {
					if (weights[i] <= min && weights[i] > -1) {
						min = weights[i];
						ptr = i;
					}
				}
				// Mark as visited.
				weights[ptr] = -1;
				head = this.graph[ptr];
			}
			return ret;
		}

		public void populateDijkstra() {
			for (int i = 0; i < graph.length; i++ ) {

				this.shortestPathMatrix[i] = dijkstra((char)(i + 'A'));

			}
		}
	}
}




