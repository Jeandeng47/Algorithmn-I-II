// Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be mlogn or better and use extra space proportional to n

import java.util.Arrays;

class UnionFind {
    private int[] parent;
    private int[] size;
    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;
        Arrays.fill(size, 1);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        int root = p;
        // find root of the set that p belongs to
        while (root != parent[root]) { // until it reaches the root
            root = parent[root]; // traverses through the parents
        }
        // perform path compression (flatten tree)
        while (p != root) { // until it reaches the root
            int next = parent[p]; // store parent
            parent[p] = root; // point p to the loop
            p = next;
        }
        return root;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // ensure p is in the larger tree
        if (size[rootP] < size[rootQ]) {
            int temp = rootP;
            rootP = rootQ;
            rootQ = temp;
        }
        // append tree Q to tree P
        parent[rootQ] = rootP;
        size[rootP] += size[rootQ];
        count--;
    }

    public int getCount() {
        return count;
    }
}

public class SocialNetworkConnectivity {
    public static int earliestTimeAllConnected(int n, int[][] timestamps) {
        UnionFind unionFind = new UnionFind(n);

        for (int[] timestamp : timestamps) {
            int time = timestamp[0];
            int member1 = timestamp[1];
            int member2 = timestamp[2];
            unionFind.union(member1, member2);
            if (unionFind.getCount() == 1) { // when all members are connected
                return time;
            }
        }
        return -1; // All members weren't connected
    }

    public static void main(String[] args) {
        int n = 5; //   number of members
        int[][] timestamps = {
                { 1, 0, 1 },
                { 2, 1, 2 },
                { 3, 3, 4 },
                { 3, 2, 3 }
                // Add more timestamps as needed...
        };
        Arrays.sort(timestamps, (a, b) -> Integer.compare(a[0], b[0]));
        // Sort timestamps by time
        int result = earliestTimeAllConnected(n, timestamps);
        System.out.println("Earliest time when all members are connectd: " + result);

    }

}