import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_15 {
    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        int N = a.length;
        int compares = 0;
        int exchanges = 0;

        StdOut.println("The original ship time array: ");
        printArray(a);
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                compares++;
                if (less(a[j], a[min])) {
                    min = j;

                }
            }
            exchange(a, i, min);
            exchanges++;
        }
        StdOut.println("The selection-sorted ship time array: ");
        printArray(a);

        StdOut.println("Number of compares: " + compares);
        StdOut.println("Number of exchanges: " + exchanges);
        StdOut.println();

    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;
        int compares = 0;
        int exchanges = 0;

        StdOut.println("The original ship time array: ");
        printArray(a);

        for (int i = 1; i < N; i++) {
            int j = i;
            for (; j > 0 && less(a[j], a[j - 1]); j--) {
                compares++;
                exchange(a, j, j - 1);
                exchanges++;

            }
        }
        StdOut.println("The insertion-sorted ship time array: ");
        printArray(a);

        StdOut.println("Number of compares: " + compares);
        StdOut.println("Number of exchanges: " + exchanges);
        StdOut.println();
    }

    private static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T extends Comparable<T>> void printArray(T[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        Integer[] shipTimes = new Integer[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            shipTimes[i] = rand.nextInt(10) + 1;
        }
        Integer[] time1 = shipTimes.clone();
        Integer[] time2 = time1.clone();

        selectionSort(time1);
        insertionSort(time2);
    }
}
