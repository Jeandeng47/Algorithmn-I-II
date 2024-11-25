/**
 * Implements depth-first search (DFS) for an undirected graph.
 * Allows querying connectivity and the count of vertices reachable from a
 * source vertex.
 */
public class _DepthFirstSearch {
    private boolean[] marked; // Marks if a vertex has been visited
    private int count; // Count of vertices connected to the source vertex

    /**
     * Performs depth-first search in the given graph starting from the source
     * vertex {@code s}.
     *
     * @param G the graph to search
     * @param s the source vertex
     * @throws IllegalArgumentException if {@code s} is invalid
     */
    public _DepthFirstSearch(_AdjacencyListGraph G, int s) {
        this.marked = new boolean[G.V()]; 
        validateVertex(G, s); 
        dfs(G, s); // start DFS from source 
    }

    /**
     * Recursive depth-first search.
     * Marks the current vertex and recursively visits all unmarked adjacent
     * vertices.
     *
     * @param G the graph
     * @param v the current vertex
     */
    private void dfs(_AdjacencyListGraph G, int v) {
        marked[v] = true; 
        count++; 
        
        // Recursively visit all unmarked adjacent vertices
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * Returns whether the vertex {@code w} is reachable from the source vertex.
     *
     * @param w the vertex to check
     * @return {@code true} if {@code w} is reachable, {@code false} otherwise
     * @throws IllegalArgumentException if {@code w} is invalid
     */
    public boolean marked(int w) {
        validateIndex(w);
        return marked[w];
    }

    /**
     * Returns the number of vertices connected to the source vertex.
     *
     * @return the count of vertices reachable from the source
     */
    public int count() {
        return count;
    }

    /**
     * Validates that a vertex index is within bounds.
     *
     * @param G the graph
     * @param v the vertex index to validate
     * @throws IllegalArgumentException if {@code v} is not a valid vertex index
     */
    private void validateVertex(_AdjacencyListGraph G, int v) {
        if (v < 0 || v >= G.V()) {
            throw new IllegalArgumentException("Vertex " + v + " is not valid");
        }
    }

    /**
     * Validates that a vertex index is within bounds for the marked array.
     *
     * @param w the vertex index to validate
     * @throws IllegalArgumentException if {@code w} is not a valid vertex index
     */
    private void validateIndex(int w) {
        if (w < 0 || w >= marked.length) {
            throw new IllegalArgumentException("Vertex " + w + " is not valid");
        }
    }
}
