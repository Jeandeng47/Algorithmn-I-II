import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Class for computing paths in a graph using breadth-first search (BFS).
 * It determines if there is a path from a source vertex to any other vertex
 * in the graph and retrieves the shortest path (in terms of the number of
 * edges) if it exists.
 */
public class _BFSPaths {
    private boolean[] marked; // Marks whether a vertex has been visited
    private int[] edgeTo; // Stores the last vertex on the shortest known path to each vertex
    private final int s; // Source vertex

    /**
     * Constructs a BFSPaths object to compute shortest paths in a graph from a
     * given source vertex.
     *
     * @param G the graph represented as an adjacency list
     * @param s the source vertex
     */
    public _BFSPaths(_AdjacencyListGraph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    /**
     * Performs breadth-first search (BFS) iteratively.
     * Marks the source vertex and explores all reachable vertices level by level.
     *
     * @param G the graph represented as an adjacency list
     * @param s the source vertex from which the search begins
     */
    private void bfs(_AdjacencyListGraph G, int s) {
        Queue<Integer> queue = new Queue<>();

        // Mark the source and enqueue it
        marked[s] = true;
        queue.enqueue(s);

        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // Dequeue the next vertex
            for (int w : G.adj(v)) {
                if (!marked[w]) { // Process each unvisited adjacent vertex
                    edgeTo[w] = v; // Record the path to vertex w
                    marked[w] = true; // Mark as visited
                    queue.enqueue(w); // Enqueue vertex w
                }
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
     * Returns the shortest path from the source vertex to the specified vertex, if
     * it exists.
     *
     * @param v the target vertex
     * @return an {@code Iterable<Integer>} representing the path from the source to
     *         the target vertex,
     *         or {@code null} if no such path exists
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        // Push vertices onto the stack, tracing back from target to source
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s); // Add the source vertex
        return path;
    }
}