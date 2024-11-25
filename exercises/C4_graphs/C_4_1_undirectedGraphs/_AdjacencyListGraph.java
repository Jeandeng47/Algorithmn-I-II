import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Represents an undirected graph using an adjacency list.
 * Each vertex maintains a list of its adjacent vertices.
 */
public class _AdjacencyListGraph {
    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Integer>[] adj; // adjacency list 

    /**
     * Initializes an empty graph with {@code V} vertices and 0 edges.
     * 
     * @param V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    @SuppressWarnings("unchecked")
    public _AdjacencyListGraph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        }
        this.V = V;
        this.E = 0;
        // create an array of list (bags), index by vertex
        this.adj = (Bag<Integer>[]) new Bag[V];
        // initialize all the lists to be empty
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * Initializes a graph from an input stream.
     * The input format is:
     * <ul>
     * <li>An integer {@code V}, the number of vertices</li>
     * <li>An integer {@code E}, the number of edges</li>
     * <li>{@code E} pairs of integers, each representing an edge</li>
     * </ul>
     *
     * @param in the input stream
     * @throws IllegalArgumentException if the input is invalid
     */
    public _AdjacencyListGraph(In in) {
        this(in.readInt()); // use constructor Graph(V)
        int E = in.readInt();
        if (E < 0) {
            throw new IllegalArgumentException("Number of edges must be non-negative");
        }
        for (int i = 0; i < E; i++) {
            // Add an edge
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    /**
     * Returns the number of vertices in the graph.
     * 
     * @return the number of vertices
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in the graph.
     * 
     * @return the number of edges
     */
    public int E() {
        return E;
    }

    /**
     * Adds an undirected edge between vertices {@code v} and {@code w}.
     * 
     * @param v one vertex
     * @param w the other vertex
     * @throws IllegalArgumentException if {@code v} or {@code w} is invalid
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);  // add w to v's list
        adj[w].add(v);  // add v to w's list
        E++;
    }

    /**
     * Returns the vertices adjacent to vertex {@code v}.
     * 
     * @param v the vertex
     * @return the list of vertices adjacent to {@code v}
     * @throws IllegalArgumentException if {@code v} is invalid
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Returns a string representation of the graph.
     * 
     * @return a string representation of the graph
     */
    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + " : ";
            for (Integer w : adj[v]) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

}
