import edu.princeton.cs.algs4.In;

public class _AdjacencyListGraphClient {
    public static void main(String[] args) {
        In in = new In("tinyG.txt");
        _AdjacencyListGraph g = new _AdjacencyListGraph(in);
        System.out.println(g);
    }
}
