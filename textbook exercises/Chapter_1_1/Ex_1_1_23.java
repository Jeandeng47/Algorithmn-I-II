import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_23 {

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int recur_depth) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1, recur_depth + 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi, recur_depth + 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        // read whitelist from tinyW.txt
        // java Ex_1_1_23.java tinyW.txt - < tinyT.txt
        // java Ex_1_1_23.java tinyW.txt + < tinyT.txt
        int[] whitelist = new In(args[0]).readAllInts();
        // read + for printing non-whitelist inputs
        // read - for printing whitelist inputs
        String op = args[1];
        Arrays.sort(whitelist);
        // countinue to read from tinyT.txt
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int rank = rank(key, whitelist);
            if (rank > 0 && op.equals("-")) {
                StdOut.printf("%d ", key);
            } else if (rank == -1 && op.equals("+")) {
                StdOut.printf("%d ", key);
            }
        }
        StdOut.println();
    }
}
