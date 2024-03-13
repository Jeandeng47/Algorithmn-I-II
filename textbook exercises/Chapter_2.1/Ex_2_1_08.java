import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_08 {
    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;
        int comp = 0;
        for (int i = 1; i < N; i++) {
            int j = i;
            // if a[j] is less than a[j-1]
            for (; j > 0 && less(a[j], a[j - 1]); j--) {

                exchange(a, j, j - 1);
                comp++;
            }
        }
        StdOut.println("Comparisons: " + comp);
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
        int[] sizes = { 100, 1000, 10000 };
        Integer[] values = { 1, 2, 3 }; // array with only three distinct values
        Random rand = new Random();

        for (int size : sizes) {
            Integer[] array = new Integer[size];
            for (int i = 0; i < size; i++) {
                array[i] = values[rand.nextInt(values.length)];
            }
            StdOut.println("Array size: " + size);
            insertionSort(array);
            StdOut.println();
        }

    }
}
