import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_03 {
    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        int N = a.length;
        int fails = 0;

        StdOut.print("Array: ");
        printArray(a);

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                    fails++; // number of updates of min
                }
            }
            exchange(a, i, min);

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
        Integer[] decrArray = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        Integer[] incrArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Integer[] randomArray = new Integer[10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            randomArray[i] = rand.nextInt(10) + 1;
        }

        selectionSort(decrArray);
        selectionSort(incrArray);
        selectionSort(randomArray);
    }
}
