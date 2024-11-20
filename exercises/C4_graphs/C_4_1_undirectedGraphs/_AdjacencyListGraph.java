import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;


public class _AdjacencyListGraph {
    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Integer>[] adj; // adjacency list 

    // Create array of lists
    @SuppressWarnings("unchecked")
    public _AdjacencyListGraph(int V) {
        this.V = V;
        this.E = 0;
        // create an array of list (bags), index by vertex
        this.adj = (Bag<Integer>[]) new Bag[V];
        // initialize all the lists to be empty
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    // Read from input and construct the graph
    // input format: V, E, 0, 5, 4, 3 ... (pairs of connected vertices)
    public _AdjacencyListGraph(In in) {
        this(in.readInt()); // use constructor Graph(V)
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            // Add an edge
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    // Return number of vertices
    public int V() {
        return V;
    }

    // Return number of edges
    public int E() {
        return E;
    }

    // Add an edge v-w
    public void addEdge(int v, int w) {
        adj[v].add(w);  // add w to v's list
        adj[w].add(v);  // add v to w's list
        E++;
    }

    // Return the list of vertices adjacent to v
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // Print the content of the graph
    @Override
    public String toString() {
        String s = "V: " + V + " E: " + E + "\n";
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
