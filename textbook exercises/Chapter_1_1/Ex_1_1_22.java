import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_22 {
 
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int recur_depth) {
        // Indentation based on the depth of recursion
        for (int i = 0; i < recur_depth; i++) {
            StdOut.printf("-");
        }
        StdOut.println("Lo: " + lo + " Hi: " + hi);
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

    public static int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue + 1);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(50, 100);
        Arrays.sort(array); // sort the array to prepare for binary search
        System.out.println("Sorted Array: " + Arrays.toString(array));

        int key = array[new Random().nextInt(array.length)];
        System.out.println("Searching for: " + key); // randomly pick a key and search

        int resultIndex = rank(key, array, 0, array.length - 1, 0);

        if (resultIndex != -1) {
            StdOut.println("Element found at index: " + resultIndex);
        } else {
            StdOut.println("Element not found.");
        }
    }
}
