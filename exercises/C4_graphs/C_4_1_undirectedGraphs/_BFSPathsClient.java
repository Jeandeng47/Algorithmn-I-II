import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 0 to 0: 0
 * 0 to 1: 0-1
 * 0 to 2: 0-2
 * 0 to 3: 0-2-3
 * 0 to 4: 0-2-4
 * 0 to 5: 0-5
 */

public class _BFSPathsClient {
    public static void main(String[] args) {
        In in = new In("tinyCG.txt");
        _AdjacencyListGraph G = new _AdjacencyListGraph(in);
        int s = 0;
        _BFSPaths search = new _BFSPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            StdOut.print(s + " to " + v + ": ");
            if (search.hasPathTo(v)) {
                // pathTo(v) returns an iterable
                for (int x : search.pathTo(v)) {
                    if (x == s) {
                        StdOut.print(x);
                    } else {
                        StdOut.print("-" + x);
                    }
                }
                StdOut.println();
            }
        }
    }
}
