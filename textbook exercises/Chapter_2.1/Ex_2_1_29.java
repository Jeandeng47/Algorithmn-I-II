import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Ex_2_1_29 {
    public static double time(String algo, int size, int N) {
        Double totalTime = 0.0;
        for (int i = 0; i < N; i++) {
            Stopwatch watch = new Stopwatch();
            Integer[] original = getRandomIntArray(size);
            Integer[] a = original.clone();

            if (algo.equals("shell sort")) {
                shellSort(a);
            } else if (algo.equals("shell short increment")) {
                a = original.clone();
                shellSortIncrement(a);
            }
            totalTime += watch.elapsedTime();
        }
        return totalTime / N; // return average time

    }

    private static Integer[] getRandomIntArray(int size) {
        Integer[] a = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(size);
        }
        return a;
    }

    public static <T extends Comparable<T>> void shellSort(T[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }

            }
            h = h / 3;
        }

    }

    public static <T extends Comparable<T>> void shellSortIncrement(T[] a) {
        int N = a.length;
        int[] sequences = { 1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609 };
        int sequenceIndex = 0;

        while (sequenceIndex < sequences.length && sequences[sequenceIndex] < N / 3) {
            sequenceIndex++;
        }
        sequenceIndex--; // Adjust to start with the largest valid sequence

        while (sequenceIndex >= 0) {
            int h = sequences[sequenceIndex];
            for (int i = h; i < N; i++) {
                for (int j = i; j > h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            sequenceIndex--;
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

        int index = 2;
        int base = 10;
        int numberOfSorts = 1000;

        while (index <= 4) {
            int arraySize = (int) Math.pow(base, index);
            double shellIncrTime = time("shell short increment", arraySize, numberOfSorts);
            double shellTime = time("shell sort", arraySize, numberOfSorts);

            StdOut.printf("Shell sort increment time: %.6fs\n", shellIncrTime);
            StdOut.printf("Shell sort time: %.6fs\n", shellTime);
            StdOut.printf(
                    "The array with random elements: array size is %2d, run %2d times, shell sort increment use %.3f times than shell sort\n",
                    arraySize, numberOfSorts, shellIncrTime / shellTime);

            index++;
        }
    }

}
