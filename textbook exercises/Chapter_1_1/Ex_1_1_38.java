import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Ex_1_1_38 {
    public static int rankBruteForce(int key, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int rankBinary(int key, int[] a) {
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

    public static void main(String[] args) {
        String pathToT = "largeT.txt";
        String pathToW = "largeW.txt";

        try {
            // load files
            int[] list = Files.lines(Paths.get(pathToT))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] keys = Files.lines(Paths.get(pathToW))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // sort the array
            Arrays.sort(list);

            // Time binary sort
            Stopwatch watch = new Stopwatch();
            for (int key : keys) {
                rankBinary(key, list);
            }
            double timeBinary = watch.elapsedTime();
            StdOut.println("Binary search time: " + timeBinary + "ms.");

            // Time brute-force seach
            watch = new Stopwatch();
            for (int key : keys) {
                rankBruteForce(key, list);
            }
            double timeBruteForce = watch.elapsedTime();
            StdOut.println("Brute force search time: " + timeBruteForce + "ms.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
