import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Ex_2_1_26 {
    public static double time(String algo, int size, int N) {
        Double totalTime = 0.0;
        for (int i = 0; i < N; i++) {
            Stopwatch watch = new Stopwatch();
            Integer[] original = getRandomIntArray(size);

            // Convert Integer[] to int[]
            int[] aPrimitive = new int[size];
            for (int j = 0; j < size; j++) {
                aPrimitive[j] = original[j].intValue();
            }

            if (algo.equals("insertion primitive")) {
                insertionSortPrimitive(aPrimitive);
            } else if (algo.equals("insertion")) {
                Integer[] aCopy = original.clone();
                insertionSort(aCopy);
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

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            // if a[j] is less than a[j-1]
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }

        }
    }

    public static void insertionSortPrimitive(int[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && (a[j] < a[j - 1]); j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
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
        int arraySize = 1000;
        int numberOfSorts = 1000;
        double insertionPrimTime = time("insertion primitive", arraySize, numberOfSorts);
        double insertionTime = time("insertion", arraySize, numberOfSorts);

        StdOut.printf("Insertion primitive: %.3fs\n", insertionPrimTime);
        StdOut.printf("Insertion time: %.3fs\n", insertionTime);
        StdOut.printf(
                "The array with random elements: array size is %2d, run %2d times, insertion primitive use %.3f times than insertion sort\n",
                arraySize, numberOfSorts, insertionPrimTime / insertionTime);
    }
}
