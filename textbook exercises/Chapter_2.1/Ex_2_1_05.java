import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_05 {
    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;
        int fails = 0;

        StdOut.print("Array: ");
        printArray(a);

        for (int i = 1; i < N; i++) {
            int j = i;
            // if a[j] is less than a[j-1]
            for (; j > 0 && less(a[j], a[j - 1]); j--) {

                exchange(a, j, j - 1);
                fails++;
            }

        }
        StdOut.println("Number of fails: " + fails);
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
        Integer[] decrArray = { 10, 9, 8, 7, 6, 5, 4, 3, 1 };
        Integer[] incrArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Integer[] randomArray = new Integer[10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            randomArray[i] = rand.nextInt(10) + 1;
        }

        insertionSort(decrArray);
        insertionSort(incrArray);
        insertionSort(randomArray);

    }

}
