import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Ex_2_1_27 {

    public static double time(String algo, int size, int N) {
        Double totalTime = 0.0;
        for (int i = 0; i < N; i++) {
            Stopwatch watch = new Stopwatch();
            Integer[] original = getRandomIntArray(size);
            Integer[] a = original.clone();

            if (algo.equals("shell sort")) {
                shellSort(a);
            } else if (algo.equals("insertion")) {
                a = original.clone();
                insertionSort(a);
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

    public static <T extends Comparable<T>> void shellSort(T[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // decide sort interval based on size N
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

    private static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {

        int index = 7;
        int base = 2;
        int numberOfSorts = 1000;

        while (index <= 10) {
            int arraySize = (int) Math.pow(base, index);
            double shellTime = time("shell sort", arraySize, numberOfSorts);
            double insertionTime = time("insertion", arraySize, numberOfSorts);

            StdOut.printf("Shell sort time: %.6fs\n", shellTime);
            StdOut.printf("Insertion time: %.6fs\n", insertionTime);
            StdOut.printf(
                    "The array with random elements: array size is %2d, run %2d times, shell sort use %.3f times than insertion sort\n",
                    arraySize, numberOfSorts, shellTime / insertionTime);

            index++;
        }
    }

}
