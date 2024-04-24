import java.util.LinkedList;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Ex_2_1_30 {

    public static double time(int size, int N, double t) {
        Double totalTime = 0.0;
        for (int i = 0; i < N; i++) {
            Stopwatch watch = new Stopwatch();
            Integer[] a = getRandomIntArray(size);
            shellSortGeometric(a, t);
            totalTime += watch.elapsedTime();
        }
        return totalTime / N;

    }

    private static Integer[] getRandomIntArray(int size) {
        Integer[] a = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(size);
        }
        return a;
    }

    public static <T extends Comparable<T>> void shellSortGeometric(T[] a, double t) {
        int N = a.length;
        LinkedList<Integer> hSequences = new LinkedList<>();

        for (int k = 0; (int) Math.pow(t, k) < N; k++) {
            int h = (int) Math.floor(Math.pow(t, k));
            if (!hSequences.contains(h)) {
                hSequences.addFirst(h); // make h arrange in descending order
            }
        }

        for (int h : hSequences) {
            for (int i = h; i < N; i++) {
                for (int j = i; j > h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
        }

    }

    private static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        int arraySize = 10000;
        int numberOfSorts = 100;
        double[] tValues = { 2.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5, 10.5 };

        for (double t : tValues) {
            double sortTime = time(arraySize, numberOfSorts, t);
            StdOut.printf(
                    "The array with random elements: array size is %2d, run %2d times, shell sort with t value %.2f use time: %.6fs\n",
                    arraySize, numberOfSorts, t, sortTime);
        }

    }
}
