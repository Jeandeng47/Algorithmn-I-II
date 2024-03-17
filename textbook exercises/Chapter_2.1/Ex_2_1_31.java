import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Ex_2_1_31 {
    public static double time(String algo, int size, int trials) {
        double totalTime = 0.0;
        for (int i = 0; i < trials; i++) {
            Stopwatch watch = new Stopwatch();
            Integer[] original = getRandomIntArray(size);
            Integer[] a = original.clone();
            switch (algo) {
                case "insertion":
                    insertionSort(a);
                    break;
                case "selection sort":
                    selectionSort(a);
                    break;
                case "shell sort":
                    shellSort(a);
                default:
                    break;
            }
            totalTime += watch.elapsedTime();

        }
        return totalTime / trials;
    }

    private static Integer[] getRandomIntArray(int size) {
        Integer[] a = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(size);
        }
        return a;
    }

    // shell sort
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

    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            T key = a[i]; // the key to insert
            int j = i;
            // no sentinel, check j > 0 here
            while (j > 0 && less(key, a[j - 1])) {
                a[j] = a[j - 1]; // move the larger one to the right
                j--;
            }
            a[j] = key;
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
        int numberOfDouble = 0;
        int numberOfSorts = 100;

        double prevSelectTime = 0, prevInsertTime = 0, prevShellTime = 0;

        while (numberOfDouble <= 3) {
            arraySize *= 2; // double the size each iteration

            double selectTime = time("selection sort", arraySize, numberOfSorts);
            double insertTime = time("insertion sort", arraySize, numberOfSorts);
            double shellTime = time("shell sort", arraySize, numberOfSorts);

            StdOut.printf("N = %2d: Selection sort: %.6fs, ", arraySize, selectTime);
            if (prevSelectTime > 0) {
                double ratio = selectTime / prevSelectTime;
                StdOut.printf("Ratio: %.2f, ", ratio);
            }

            StdOut.printf("Insertion sort: %.6fs, ", insertTime);
            if (prevInsertTime > 0) {
                double ratio = insertTime / prevInsertTime;
                StdOut.printf("Ratio: %.2f, ", ratio);
            }

            System.out.printf("Shell sort: %.6fs", shellTime);
            if (prevShellTime > 0) {
                double ratio = shellTime / prevShellTime;
                System.out.printf(", Ratio: %.2f", ratio);
            }

            System.out.println();

            prevSelectTime = selectTime;
            prevInsertTime = insertTime;
            prevShellTime = shellTime;

            numberOfDouble++;

        }

    }

}
