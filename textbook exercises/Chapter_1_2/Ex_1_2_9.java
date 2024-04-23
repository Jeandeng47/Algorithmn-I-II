
import java.util.Random;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_9 {
    public static int rank(int key, int[] a, Counter counter) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            counter.increment(); // count number of keys examined
            if (key > a[mid]) {
                lo = mid + 1;
            } else if (key < a[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Counter counter = new Counter("Binary Search");

        // initialize an ascending array
        int N = 100;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }

        // initialize a list of keys
        int k = 150; // number of keys
        int[] keys = new int[k];
        Random rand = new Random();
        for (int i = 0; i < k; i++) {
            keys[i] = rand.nextInt(100);
        }

        for (int key : keys) {
            if (rank(key, a, counter) == -1) {
                System.out.println(key + " not found");
            } else {
                System.out.println(key + " found");
            }
        }
        StdOut.println("Total number of counts: " + counter);
    }
}
