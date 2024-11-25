import edu.princeton.cs.algs4.Stack;

/**
 * Class for computing paths in a graph using depth-first search (DFS).
 * It determines if there is a path from a source vertex to any other vertex
 * in the graph and retrieves the path if it exists.
 */
public class _DFSPaths {
    private boolean[] marked; // Marks whether a vertex has been visited
    private int[] edgeTo; // Stores the last vertex on the known path to each vertex
    private final int s; // Source vertex

    /**
     * Constructs a DFSPaths object to compute paths in a graph from a given source
     * vertex.
     *
     * @param G the graph represented as an adjacency list
     * @param s the source vertex
     */
    public _DFSPaths(_AdjacencyListGraph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    /**
     * Performs depth-first search (DFS) recursively.
     * Marks the current vertex as visited and explores all its unvisited adjacent
     * vertices.
     *
     * @param G the graph represented as an adjacency list
     * @param v the current vertex being explored
     */
    private void dfs(_AdjacencyListGraph G, int v) {
        marked[v] = true;

        // Recursively visit all unmarked adjacent vertices
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v; // Record the path to vertex w
                dfs(G, w); // Recur for adjacent vertex w
            }
        }
    }

    /**
     * Checks if there is a path from the source vertex to the specified vertex.
     *
     * @param v the target vertex
     * @return {@code true} if there is a path to the target vertex, {@code false}
     *         otherwise
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Returns the path from the source vertex to the specified vertex, if it
     * exists.
     *
     * @param v the target vertex
     * @return an {@code Iterable<Integer>} representing the path from the source to
     *         the target vertex,
     *         or {@code null} if no such path exists
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        // Push vertices onto the stack, tracing back from target to source
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s); // Add the source
        return path;
    }
}