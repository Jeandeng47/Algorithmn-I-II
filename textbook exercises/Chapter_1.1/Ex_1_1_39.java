import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_39 {
    public static int binarySearch(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
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

    public static int[] generateRandomArray(int N, Random rand) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = 100000 + rand.nextInt(900000);
        }
        return a;
    }

    public static int countCommon(int[] a, int[] b) {
        int common = 0;
        for (int key : a) {
            if (binarySearch(key, b) > 0) {
                common++;
            }
        }
        return common;
    }

    public static double runExperiment(int N, int T) {
        Random rand = new Random();
        int commontotal = 0;

        for (int t = 0; t < T; t++) {
            int[] a = generateRandomArray(N, rand);
            int[] b = generateRandomArray(N, rand);
            Arrays.sort(b); // sort array b
            commontotal += countCommon(a, b);
        }

        double result = commontotal / T;
        return result;
    }

    public static void main(String[] args) {
        if (args.length <= 1) {
            StdOut.println("Usage: java Ex_1_1_39 <intT>");
        }
        int T = Integer.parseInt(args[0]); // number of trials
        int[] Ns = { 1000, 10000, 100000, 1000000 }; // array of size

        StdOut.println("N\tAverage Common Elements");
        for (int N : Ns) {
            double average = runExperiment(N, T);
            StdOut.println(N + "\t" + average);
        }

    }
}
