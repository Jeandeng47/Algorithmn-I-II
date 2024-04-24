import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.In;

public class Ex_2_1_34 {

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

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            // if a[j] is less than a[j-1]
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
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

    public static Integer[] getSortedArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static Integer[] getReversedArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = size - 1; i >= 0; i--) {
            array[i] = size - i;
        }
        return array;
    }

    public static Integer[] getAllSameArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }
        return array;
    }

    public static Integer[] getTwoDistinctArray(int size) {
        int[] values = { 1, 2 };
        Random rand = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = values[rand.nextInt(values.length)];
        }
        return array;
    }

    private static <T extends Comparable<T>> void testSort(String testName, T[] array) {
        System.out.println("Before " + testName + ": " + Arrays.toString(array));
        selectionSort(array); // replace with other sort methods
        System.out.println("After " + testName + ": " + Arrays.toString(array) + "\n");
    }

    public static void main(String[] args) {
        int arraySize = 10;
        // Define test cases
        Integer[] alreadySorted = getSortedArray(arraySize);
        Integer[] reverseOrder = getReversedArray(arraySize);
        Integer[] allSame = getAllSameArray(arraySize);
        Integer[] twoDistinct = getTwoDistinctArray(arraySize);
        Integer[] empty = {};
        Integer[] singleElement = { 1 };

        // Run tests
        testSort("Already Sorted", alreadySorted);
        testSort("Reverse Order", reverseOrder);
        testSort("All Same", allSame);
        testSort("Two Distinct", twoDistinct);
        testSort("Empty", empty);
        testSort("Single Element", singleElement);
    }
}
