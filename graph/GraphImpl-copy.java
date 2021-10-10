import java.util.*;

class Vertex<T> {
	private T label;
	public Vertex(T label) {
		this.label = label;
	}
}

class GraphImpl<T> {

	private Map<Vertex<T>, List<Vertex<T>>> adjVertices;

    public GraphImpl() {
        this.adjVertices = new HashMap<Vertex<T>, List<Vertex<T>>>();
    }

    void addVertex(T label) {
        adjVertices.putIfAbsent(new Vertex<T>(label), new ArrayList<>());
    }

    void removeVertex(T label) {
        Vertex<T> v = new Vertex<>(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex<>(label));
    }

    void addEdge(T label1, T label2) {
        Vertex<T> v1 = new Vertex<>(label1);
        Vertex<T> v2 = new Vertex<>(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(T label1, T label2) {
        Vertex<T> v1 = new Vertex<>(label1);
        Vertex<T> v2 = new Vertex<>(label2);
        List<Vertex<T>> eV1 = adjVertices.get(v1);
        List<Vertex<T>> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    List<Vertex<T>> getAdjVertices(T label) {
        return adjVertices.get(new Vertex<>(label));
    }
    
	public int getVertexCount() {
		return this.adjVertices.keySet().size();
	}

	public int getEdgesCount() {
		int count = 0;
		for (Vertex<T> v: this.adjVertices.keySet()) {
			count += this.adjVertices.get(v).size();
		}
		return count;
	}

	public boolean hasVertex(T v) {
		return this.adjVertices.containsKey(v);
	}

	public boolean hasEdge(T s, T d) {
		return this.adjVertices.get(s).contains(d);
	}

	public static void main(String args[]) {
  
        // Object of graph is created.
        GraphImpl<Integer> g = new GraphImpl<Integer>();
  
        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		System.out.println(g.hasVertex(4));
		System.out.println(g.adjVertices.toString());
		System.out.println(g.adjVertices.keySet().stream().iterator().next());
        // g.addEdge(0, 1);
        // g.addEdge(0, 4);
        // g.addEdge(1, 2);
        // g.addEdge(1, 3);
        // g.addEdge(1, 4);
        // g.addEdge(2, 3);
        // g.addEdge(3, 4);
  
        // gives the no of vertices in the graph.
        System.out.println(g.getVertexCount());
  
        // gives the no of edges in the graph.
        System.out.println(g.getEdgesCount());
  
        // tells whether the edge is present or not.
        // System.out.println(g.hasEdge(3, 4));
  
        // tells whether vertex is present or notvoid
        System.out.println(g.hasVertex(5));
    }
}

  
