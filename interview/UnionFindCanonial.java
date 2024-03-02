
// Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing i. The operations, union(), connected() and find() should all take logarithmic time or better
// For example, if one of the connected component is {1,2,6,9}, then the find() method should return 9 for each of the 4 elements in the connected components.

class UnionFind {
    private int[] parent;
    private int[] size;
    private int[] maxElement; // array to store max in each component

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        maxElement = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            maxElement[i] = i;
        }
    }

    public int find(int p) {

        int root = p;
        // find root of the set that p belongs to
        while (root != parent[root]) {
            root = parent[root];
        }

        // perform path compression (flatten tree)
        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        return root;
    }

    public int findMax(int p) {
        // find max value using root
        int root = find(p);
        return maxElement[root];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] < size[rootQ]) {
            // append tree P to tree Q
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            // update the max value of root Q
            maxElement[rootQ] = Math.max(maxElement[rootP], maxElement[rootQ]);
        } else {
            // append tree Q to tree P
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            // update the max value of root P
            maxElement[rootP] = Math.max(maxElement[rootP], maxElement[rootQ]);
        }

    }
}

public class UnionFindCanonial {
    public static void main(String[] args) {
        int n = 10; // Number of elements

        // Initialize UnionFind data structure
        UnionFind uf = new UnionFind(n);

        // Perform union operations
        uf.union(1, 2);
        uf.union(2, 6);
        uf.union(6, 9);

        // Find the largest element in the connected component for each element
        for (int i = 0; i < n; i++) {
            int largestInComponent = uf.findMax(i);
            System.out.println("Largest element in the component containing " + i + ": " + largestInComponent);
        }
    }
}
