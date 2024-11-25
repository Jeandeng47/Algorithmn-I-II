import edu.princeton.cs.algs4.In;

/**
 * 13 vertices, 13 edges
 * 0 : 6 2 1 5
 * 1 : 0
 * 2 : 0
 * 3 : 5 4
 * 4 : 5 6 3
 * 5 : 3 4 0
 * 6 : 0 4
 * 7 : 8
 * 8 : 7
 * 9 : 11 10 12
 * 10 : 9
 * 11 : 9 12
 * 12 : 11 9
 */

public class _AdjacencyListGraphClient {
    public static void main(String[] args) {
        In in = new In("tinyG.txt");
        _AdjacencyListGraph g = new _AdjacencyListGraph(in);
        System.out.println(g);
    }
}
