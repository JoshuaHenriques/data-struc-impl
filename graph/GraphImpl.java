import java.util.*;

class GraphImpl<T> {

	// edges
	private Map<T, List<T>> map = new HashMap();

	// insert vertex
	public void addVertex(T v) {
		this.map.put(v, new LinkedList<T>());
	}

	public void addEdge(T src, T dest, boolean bi) {
		if (!this.map.containsKey(src)) addVertex(src);
		if (!this.map.containsKey(dest)) addVertex(dest);
		this.map.get(src).add(dest);
		if (bi) {
			this.map.get(dest).add(src);
		}
	}

	public int getVertexCount() {
		return this.map.keySet().size();
	}

	public int getEdgesCount(boolean bi) {
		int count = 0;
		for (T v: map.keySet()) {
			count += map.get(v).size();
		}
		if (bi) {
			count /= 2;
		}
		return count;
	}

	public boolean hasVertex(T v) {
		return this.map.containsKey(v);
	}

	public boolean hasEdge(T s, T d) {
		return this.map.get(s).contains(d);
	}

	public static void main(String args[]) {
  
        // Object of graph is created.
        GraphImpl<Integer> g = new Graph<Integer>();
  
        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);
  
        // print the graph.
        System.out.println("Graph:\n"
                           + g.toString());
  
        // gives the no of vertices in the graph.
        System.out.println(g.getVertexCount());
  
        // gives the no of edges in the graph.
        System.out.println(g.getEdgesCount(true));
  
        // tells whether the edge is present or not.
        System.out.println(g.hasEdge(3, 4));
  
        // tells whether vertex is present or notvoid
        System.out.println(g.hasVertex(5));
    }
}

  
